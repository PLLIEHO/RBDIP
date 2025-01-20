package study.cursach.services;

import org.springframework.stereotype.Service;
import study.cursach.entity.CustomsCategory;
import study.cursach.repo.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetByIdService {

    private final CompanyRepository companyRepository;
    private final JobEntityRepository jobEntityRepository;
    private final EntryPurposeRepository entryPurposeRepository;
    private final JobTypeRepository jobTypeRepository;
    private final EntryListRepository entryListRepository;
    private final CustomsCategoryRepository customsCategoryRepository;
    private final CountryEntityRepository countryEntityRepository;

    public GetByIdService(CompanyRepository companyRepository,
                          JobEntityRepository jobEntityRepository,
                          EntryPurposeRepository entryPurposeRepository,
                          JobTypeRepository jobTypeRepository,
                          EntryListRepository entryListRepository,
                          CustomsCategoryRepository customsCategoryRepository,
                          CountryEntityRepository countryEntityRepository){

        this.companyRepository = companyRepository;
        this.jobEntityRepository = jobEntityRepository;
        this.entryPurposeRepository = entryPurposeRepository;
        this.jobTypeRepository = jobTypeRepository;
        this.entryListRepository = entryListRepository;
        this.customsCategoryRepository = customsCategoryRepository;
        this.countryEntityRepository = countryEntityRepository;
    }


    public String getEntryPurpose(Integer id){
        try {
            return entryPurposeRepository.findById(id).get().getName();
        } catch (Exception e){
            return "false";
        }
    }

    public String getCompanyName(Integer id, int flag){
        try {
            int company_id;
            if (flag == 0) {
                company_id = jobEntityRepository.findById(id).get().getCompany_id();
            } else {
                company_id = id;
            }
            return companyRepository.findById(company_id).get().getName();
        } catch (Exception e){
            return "false";
        }
    }

    public String getJobTypeName(Integer id){
        try {
            return jobTypeRepository.findById(id).get().getName();
        } catch (Exception e){
            return "false";
        }
    }

    public String getCountryName(Integer id){
        try {
            return countryEntityRepository.findById(id).get().getName();
        } catch (Exception e){
            return "false";
        }
    }

    public boolean isInEntryList(Integer id){
        try{
            entryListRepository.findById(id).get();
            return true;
        } catch (Exception e){
            return false;
        }
    }


    public List<String> getCustomsInfo(Integer id){
        List<String> output = new ArrayList<>();
        try{
            CustomsCategory category = customsCategoryRepository.findById(id).get();
            output.add(category.getName());
            output.add(category.getIsImportable().toString());
            return output;
        } catch (Exception e){
            output.add("false");
            output.add("false");
            return output;
        }
    }

}
