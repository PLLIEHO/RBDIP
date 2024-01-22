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

    public GetByIdService(CompanyRepository companyRepository,
                          JobEntityRepository jobEntityRepository,
                          EntryPurposeRepository entryPurposeRepository,
                          JobTypeRepository jobTypeRepository,
                          EntryListRepository entryListRepository,
                          CustomsCategoryRepository customsCategoryRepository){

        this.companyRepository = companyRepository;
        this.jobEntityRepository = jobEntityRepository;
        this.entryPurposeRepository = entryPurposeRepository;
        this.jobTypeRepository = jobTypeRepository;
        this.entryListRepository = entryListRepository;
        this.customsCategoryRepository = customsCategoryRepository;
    }


    public String getEntryPurpose(int id){
        try {
            return entryPurposeRepository.findById(id).get().getName();
        } catch (Exception e){
            return "false";
        }
    }

    public String getCompanyName(int id){
        try {
            return companyRepository.findById(id).get().getName();
        } catch (Exception e){
            return "false";
        }
    }

    public String getJobTypeName(int id){
        try {
            return jobTypeRepository.findById(id).get().getName();
        } catch (Exception e){
            return "false";
        }
    }

    public boolean isInEntryList(int id){
        try{
            entryListRepository.findById(id).get();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<String> getCustomsInfo(int id){
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
