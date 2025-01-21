package study.cursach.services;

import jakarta.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.cursach.dto.Validation;
import study.cursach.entity.*;
import study.cursach.repo.*;

import java.util.Date;
import java.util.Objects;

@Service
public class BdFunctionsService {

    @Inject
    NextGeneratedEntityRepository nextGeneratedEntityRepository;
    @Inject
    GetByIdService getByIdService;
    @Inject
    CountryEntityRepository countryEntityRepository;
    @Inject
    EntryListRepository entryListRepository;
    @Inject
    JobEntityRepository jobEntityRepository;
    @Inject
    CustomsCategoryRepository customsCategoryRepository;
    @Inject
    CustomsParamEntityRepository customsParamEntityRepository;
    @Inject
    CriminalEntityRepository criminalEntityRepository;

    Logger logger = LoggerFactory.getLogger(BdFunctionsService.class);


    public void nextOne(boolean accepted) {
        NextGeneratedEntity now = nextGeneratedEntityRepository.findAllByOrderById().get(0);
        logger.info("NextOne from bd: {}", now.toString());
        if (accepted) {
            EntryList entryList = new EntryList();
            entryList.setPassportId(now.getId());
            entryListRepository.save(entryList);
            logger.info("Saved nextOne to entry list");
        }

        nextGeneratedEntityRepository.deleteById(now.getId());
        logger.info("Deleted nextOne last instance");
    }

    public Validation validate(){
        NextGeneratedEntity now = nextGeneratedEntityRepository.findAllByOrderById().get(0);
        logger.info("Validate from bd: {}", now.toString());
        boolean workPurpose = Objects.equals(getByIdService.getEntryPurpose(now.getEnpurpose()), "Работа");
        boolean decStatus = now.getLugsize() != null && now.getLugweight() != null;
        Validation output = new Validation();
        output.setPassport(passportCheck(now));
        output.setEntry(entryCheck(now));
        if (workPurpose) {
            output.setWork(workCheck(now));
        } else {
            output.setWork("No work permission needed.");
        }
        if (decStatus) {
            output.setDeclaration(declarationCheck(now));
        } else {
            output.setDeclaration("No declaration needed.");
        }
        output.setCriminal(criminalCheck(now));
        logger.info("Validate sent to client: {}", output);
        return output;
    }

    public String passportCheck(NextGeneratedEntity now) {
        logger.info("Started passport check");
        StringBuilder out = new StringBuilder();
        if (!Objects.equals(now.getName(), now.getPsname())) {
            out.append("names not equal, ");
        }
        if (!Objects.equals(now.getSurname(), now.getPssurname())) {
            out.append("surnames not equal, ");
        }
        if (!Objects.equals(now.getLastname(), now.getPslastname())) {
            out.append("lastnames not equal, ");
        }
        if (!Objects.equals(now.getEyeColor(), now.getPseyeColor())) {
            out.append("eye colors not equal, ");
        }
        if (!Objects.equals(now.getNationality(), now.getPsnationality())) {
            out.append("nationality not equal, ");
        } else {
            if (countryEntityRepository.existsCountryEntityByName(now.getNationality())) {
                out.append("unknown nationality, ");
            }
        }
        if (!out.isEmpty()) {
            out.delete(out.length() - 2, out.length());
            out.append(".");
            out.replace(0, 1, String.valueOf(out.charAt(0)).toUpperCase());
        }
        return out.toString();
    }

    public String entryCheck(NextGeneratedEntity now) {
        logger.info("Started entry permission check");
        StringBuilder out = new StringBuilder();
        if (!Objects.equals(now.getName(), now.getEnname())) {
            out.append("names not equal, ");
        }
        if (!Objects.equals(now.getSurname(), now.getEnsurname())) {
            out.append("surnames not equal, ");
        }
        if (!Objects.equals(now.getLastname(), now.getEnlastname())) {
            out.append("lastnames not equal, ");
        }
        if (Objects.equals(getByIdService.getEntryPurpose(now.getEnpurpose()), "false")) {
            out.append("unknown entry purpose, ");
        }
        if (now.getEndateExpired().after(now.getEndateGaned())) {
            out.append("date gained less than date expired, ");
        }
        Date today = new Date();
        if (today.after(now.getEndateExpired())) {
            out.append("entry permission is expired, ");
        }
        if (!out.isEmpty()) {
            out.delete(out.length() - 2, out.length());
            out.append(".");
            out.replace(0, 1, String.valueOf(out.charAt(0)).toUpperCase());
        }
        return out.toString();
    }


    public String workCheck(NextGeneratedEntity now) {
        logger.info("Started work permission check");
        StringBuilder out = new StringBuilder();
        if (!Objects.equals(now.getName(), now.getWorkname())) {
            out.append("names not equal, ");
        }
        if (!Objects.equals(now.getSurname(), now.getWorksurname())) {
            out.append("surnames not equal, ");
        }
        if (!Objects.equals(now.getLastname(), now.getWorklastname())) {
            out.append("lastnames not equal, ");
        }
        JobEntity jobEntity = jobEntityRepository.findById(now.getWorkcompany()).orElse(null);
        if (jobEntity != null) {
            if (jobEntity.getCapacity() == 0) {
                out.append("job capacity is zero, ");
            }
        } else {
            out.append("unknown work company, ");
        }
        if (!out.isEmpty()) {
            out.delete(out.length() - 2, out.length());
            out.append(".");
            out.replace(0, 1, String.valueOf(out.charAt(0)).toUpperCase());
        }
        return out.toString();
    }

    public String declarationCheck(NextGeneratedEntity now) {
        logger.info("Started declaration check");
        StringBuilder out = new StringBuilder();
        if (!Objects.equals(now.getName(), now.getDecname())) {
            out.append("names not equal, ");
        }
        if (!Objects.equals(now.getSurname(), now.getDecsurname())) {
            out.append("surnames not equal, ");
        }
        if (!Objects.equals(now.getLastname(), now.getDeclastname())) {
            out.append("lastnames not equal, ");
        }
        if (!Objects.equals(now.getDecsize(), now.getLugsize())) {
            out.append("luggage size not equal, ");
        }
        if (!Objects.equals(now.getDecweight(), now.getLugweight())) {
            out.append("luggage weight not equal, ");
        }
        if (!Objects.equals(now.getDeccat(), now.getLugcategory())) {
            out.append("luggage category not equal, ");
        } else {
            CustomsCategory customsCategory = customsCategoryRepository.findById(now.getDeccat()).orElse(null);
            if (customsCategory == null) {
                out.append("unknown luggage category, ");
            } else {
                if (!customsCategory.getIsImportable()) {
                    out.append("luggage category can not be imported, ");
                }
                CustomsParamEntity customsParamEntity = customsParamEntityRepository.findById(now.getDeccat()).orElse(null);
                assert customsParamEntity != null;
                if (customsParamEntity.getMax_size() < now.getLugsize() || customsParamEntity.getMax_weight() < now.getLugweight()) {
                    out.append("your luggage is too big for your category");
                }
            }
        }
        if (!out.isEmpty()) {
            out.delete(out.length() - 2, out.length());
            out.append(".");
            out.replace(0, 1, String.valueOf(out.charAt(0)).toUpperCase());
        }
        return out.toString();
    }

    public String criminalCheck(NextGeneratedEntity now) {
        logger.info("Started criminal check");
        for (CriminalEntity criminalEntity : criminalEntityRepository.findAll()) {
            if (Objects.equals(criminalEntity.getName(), now.getName()) &&
                    Objects.equals(criminalEntity.getSurname(), now.getSurname()) &&
                    Objects.equals(criminalEntity.getLastname(), now.getLastname()) &&
                    Objects.equals(getByIdService.getCountryName(criminalEntity.getNationality()), now.getNationality()) &&
                    Objects.equals(criminalEntity.getEye_color(), now.getEyeColor()) ||
                    Objects.equals(criminalEntity.getFingerprint(), now.getFingerprint())) {
                return "ITS A CRIMINAL KILL HIM.";
            }
        }
        return "It's not a criminal.";
    }
}
