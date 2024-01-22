package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.CriminalEntity;

public interface CriminalEntityRepository extends JpaRepository<CriminalEntity, Long> {
}