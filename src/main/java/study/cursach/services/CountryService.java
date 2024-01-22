package study.cursach.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.cursach.entity.CountryEntity;
import study.cursach.repo.CountryEntityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private final CountryEntityRepository countryRepo;

    public CountryService(CountryEntityRepository countryRepo){
        this.countryRepo = countryRepo;
    }
    public List<CountryEntity> getCountries(){
        return new ArrayList<>(countryRepo.findAll());
        }
}

