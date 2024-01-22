package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.JobType;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {
}