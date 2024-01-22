package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.CountryEntity;

public interface CountryEntityRepository extends JpaRepository<CountryEntity, Integer> {
}