package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.CustomsParamEntity;

public interface CustomsParamEntityRepository extends JpaRepository<CustomsParamEntity, Integer> {
}