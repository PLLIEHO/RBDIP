package study.cursach.services;

import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.cursach.entity.CountryEntity;
import study.cursach.repo.CountryEntityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Inject
    CountryEntityRepository countryRepo;

    Logger logger = LoggerFactory.getLogger(CountryService.class);


    public List<CountryEntity> getCountries() {
        var countries = countryRepo.findAll();
        logger.info("Send countries from db {}", countries);
        return new ArrayList<>(countries);
    }
}

