package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.DocumentPack;

public interface DocumentPackRepository extends JpaRepository<DocumentPack, Integer> {
}