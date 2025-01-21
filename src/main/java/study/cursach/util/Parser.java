package study.cursach.util;

import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import study.cursach.dto.*;
import study.cursach.entity.*;
import study.cursach.services.GetByIdService;

import java.text.SimpleDateFormat;

@Service
public class Parser {

    @Inject
    GetByIdService getByIdService;

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    public JobDTO jobToDTO(JobEntity job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setCapacity(job.getCapacity());
        jobDTO.setCompany(getByIdService.getCompanyName(job.getCompany_id()));
        jobDTO.setType(getByIdService.getJobTypeName(job.getType_id()));
        return jobDTO;
    }

    public CriminalDTO criminalToDTO(CriminalEntity criminal) {
        CriminalDTO criminalDTO = new CriminalDTO();
        criminalDTO.setSurname(criminal.getSurname());
        criminalDTO.setName(criminal.getName());
        criminalDTO.setLastname(criminal.getLastname());
        criminalDTO.setEye_color(criminal.getEye_color());
        criminalDTO.setFingerprint(criminal.getFingerprint());
        criminalDTO.setNationality(getByIdService.getCountryName(criminal.getNationality()));
        return criminalDTO;
    }

    public CustomsDTO customToDTO(CustomsParamEntity customs) {
        CustomsDTO custom = new CustomsDTO();
        custom.setMax_size(customs.getMax_size());
        custom.setMax_weight(customs.getMax_weight());
        var info = getByIdService.getCustomsInfo(customs.getCategory_id());
        custom.setName(info.get(0));
        custom.set_importable(Boolean.parseBoolean(info.get(1)));
        return custom;
    }

    public InstructionDTO instructionToDTO(InstructionEntity instruction) {
        InstructionDTO instructionDTO = new InstructionDTO();
        instructionDTO.setName(instruction.getName());
        instructionDTO.setLastname(instruction.getLastname());
        instructionDTO.setNationality(getByIdService.getCountryName(instruction.getNationality()));
        instructionDTO.setEye_color(instruction.getEye_color());
        instructionDTO.setDate_of_order(instruction.getDate_of_order());
        instructionDTO.setSurname(instruction.getSurname());
        instructionDTO.setPositive_negative_type(instruction.isPositive_negative_type());
        instructionDTO.setJob_type(getByIdService.getJobTypeName(instruction.getJob_type_id()));
        instructionDTO.setJob_company(getByIdService.getCompanyNameFromJob(instruction.getJob_id()));
        return instructionDTO;
    }

    public NextDTO nextToDTO(NextGeneratedEntity next) {
        NextDTO nextDTO = new NextDTO();
        nextDTO.setName(next.getName());
        nextDTO.setSurname(next.getSurname());
        nextDTO.setLastname(next.getLastname());
        nextDTO.setNationality(next.getNationality());
        nextDTO.setEyeColor(next.getEyeColor());
        nextDTO.setFingerprint(next.getFingerprint());
        nextDTO.setPsname(next.getPsname());
        nextDTO.setPssurname(next.getPssurname());
        nextDTO.setPslastname(next.getPslastname());
        nextDTO.setPseyeColor(next.getPseyeColor());
        nextDTO.setPsnationality(next.getPsnationality());
        nextDTO.setEnname(next.getEnname());
        nextDTO.setEnsurname(next.getEnsurname());
        nextDTO.setEnlastname(next.getEnlastname());
        nextDTO.setEndateGaned(formatter.format(next.getEndateGaned()));
        nextDTO.setEndateExpired(formatter.format(next.getEndateExpired()));
        nextDTO.setEnpurpose(getByIdService.getEntryPurpose(next.getEnpurpose()));
        nextDTO.setWorkname(next.getWorkname());
        nextDTO.setWorksurname(next.getWorksurname());
        nextDTO.setWorklastname(next.getWorklastname());
        nextDTO.setWorkcompany(getByIdService.getCompanyName(next.getWorkcompany()));
        nextDTO.setLugsize(next.getLugsize());
        nextDTO.setLugweight(next.getLugweight());
        nextDTO.setLugcategory(getByIdService.getCustomsInfo(next.getLugcategory()).get(0));
        nextDTO.setDecname(next.getDecname());
        nextDTO.setDecsurname(next.getDecsurname());
        nextDTO.setDeclastname(next.getDeclastname());
        nextDTO.setDecsize(next.getDecsize());
        nextDTO.setDecweight(next.getDecweight());
        nextDTO.setDeccat(getByIdService.getCustomsInfo(next.getDeccat()).get(0));
        return nextDTO;
    }
}
