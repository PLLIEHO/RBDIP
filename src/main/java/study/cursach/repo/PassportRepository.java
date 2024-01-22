package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
}