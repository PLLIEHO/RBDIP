package study.cursach.services;

import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.cursach.entity.CustomsCategory;
import study.cursach.repo.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetByIdService {

    @Inject
    CompanyRepository companyRepository;
    @Inject
    JobEntityRepository jobEntityRepository;
    @Inject
    EntryPurposeRepository entryPurposeRepository;
    @Inject
    JobTypeRepository jobTypeRepository;
    @Inject
    CustomsCategoryRepository customsCategoryRepository;
    @Inject
    CountryEntityRepository countryEntityRepository;

    Logger logger = LoggerFactory.getLogger(GetByIdService.class);


    public String getEntryPurpose(Integer id) {
        try {
            var entry = entryPurposeRepository.findById(id).get().getName();
            logger.info("Find entry purpose by id: {}", entry);
            return entry;
        } catch (Exception e) {
            logger.info("Illegal entry id: {}", id);
            return "Illegal entry id: " + id;
        }
    }

    public String getCompanyName(Integer id) {
        try {
            var company = companyRepository.findById(id).get().getName();
            logger.info("Find company by id: {}", company);
            return company;
        } catch (Exception e) {
            logger.info("Illegal company id: {}", id);
            return "Illegal company id: " + id;
        }
    }

    public String getCompanyNameFromJob(Integer id){
        try {
            int company_id = jobEntityRepository.findById(id).get().getCompany_id();
            var company_name = getCompanyName(company_id);
            logger.info("Find company_name from job by id: {}", company_name);
            return company_name;
        } catch (Exception e) {
            logger.info("Illegal job id: {}", id);
            return "Illegal job id: " + id;
        }
    }

    public String getJobTypeName(Integer id) {
        try {
            var job_type = jobTypeRepository.findById(id).get().getName();
            logger.info("Find job_type by id: {}", job_type);
            return job_type;
        } catch (Exception e) {
            logger.info("Illegal job type id: {}", id);
            return "Illegal job type: " + id;
        }
    }

    public String getCountryName(Integer id) {
        try {
            var country = countryEntityRepository.findById(id).get().getName();
            logger.info("Find country by id: {}", country);
            return country;
        } catch (Exception e) {
            logger.info("Illegal country id: {}", id);
            return "Illegal country id: " + id;
        }
    }


    public List<String> getCustomsInfo(Integer id) {
        List<String> output = new ArrayList<>();
        try {
            CustomsCategory category = customsCategoryRepository.findById(id).get();
            output.add(category.getName());
            output.add(category.getIsImportable().toString());
            logger.info("Find category by id: {}", category);
            return output;
        } catch (Exception e) {
            output.add("Illegal category id: " + id);
            output.add("Illegal category id: " + id);
            logger.info("Illegal category id: {}", id);
            return output;
        }
    }

}
