package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.InstructionEntity;

public interface InstructionEntityRepository extends JpaRepository<InstructionEntity, String> {
}