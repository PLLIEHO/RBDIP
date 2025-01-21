package study.cursach.services;

import jakarta.inject.Inject;
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
    EntryListRepository entryListRepository;
    @Inject
    CustomsCategoryRepository customsCategoryRepository;
    @Inject
    CountryEntityRepository countryEntityRepository;


    public String getEntryPurpose(Integer id) {
        try {
            return entryPurposeRepository.findById(id).get().getName();
        } catch (Exception e) {
            return "Illegal entry id: " + id;
        }
    }

    public String getCompanyName(Integer id) {
        try {
            return companyRepository.findById(id).get().getName();
        } catch (Exception e) {
            return "Illegal company id: " + id;
        }
    }

    public String getCompanyNameFromJob(Integer id){
        try {
            int company_id = jobEntityRepository.findById(id).get().getCompany_id();
            return getCompanyName(company_id);
        } catch (Exception e) {
            return "Illegal job id: " + id;
        }
    }

    public String getJobTypeName(Integer id) {
        try {
            return jobTypeRepository.findById(id).get().getName();
        } catch (Exception e) {
            return "Illegal job type: " + id;
        }
    }

    public String getCountryName(Integer id) {
        try {
            return countryEntityRepository.findById(id).get().getName();
        } catch (Exception e) {
            return "Illegal country id: " + id;
        }
    }


    public List<String> getCustomsInfo(Integer id) {
        List<String> output = new ArrayList<>();
        try {
            CustomsCategory category = customsCategoryRepository.findById(id).get();
            output.add(category.getName());
            output.add(category.getIsImportable().toString());
            return output;
        } catch (Exception e) {
            output.add("Illegal company id: " + id);
            output.add("Illegal company id: " + id);
            return output;
        }
    }

}
