package study.cursach.services;

import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import study.cursach.entity.CountryEntity;
import study.cursach.repo.CountryEntityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Inject
    CountryEntityRepository countryRepo;

    public List<CountryEntity> getCountries() {
        return new ArrayList<>(countryRepo.findAll());
    }
}

