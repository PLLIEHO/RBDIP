package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.CustomsCategory;

public interface CustomsCategoryRepository extends JpaRepository<CustomsCategory, Integer> {
}