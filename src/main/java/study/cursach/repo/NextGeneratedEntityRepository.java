package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.NextGeneratedEntity;

import java.util.List;

public interface NextGeneratedEntityRepository extends JpaRepository<NextGeneratedEntity, Integer> {
    List<NextGeneratedEntity> findAllByOrderById();
}