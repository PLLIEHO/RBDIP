package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.EntryPurpose;

public interface EntryPurposeRepository extends JpaRepository<EntryPurpose, Integer> {
}