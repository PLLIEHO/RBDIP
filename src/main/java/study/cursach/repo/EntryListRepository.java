package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.cursach.entity.EntryList;

public interface EntryListRepository extends JpaRepository<EntryList, Integer> {
}