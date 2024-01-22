package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}