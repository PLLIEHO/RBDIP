package study.cursach.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.cursach.entity.NextGeneratedEntity;

import java.util.Date;
import java.util.List;

public interface NextGeneratedEntityRepository extends JpaRepository<NextGeneratedEntity, Integer> {

    @Query (value = "Select min(id) from next_generated", nativeQuery = true)
    Integer findMinimum();

    List<NextGeneratedEntity> findAllByOrderById();

    @Query(nativeQuery = true, value = "SELECT allow(:pass_id)")
    void allow(@Param("pass_id") int pass_id);

    @Query(nativeQuery = true, value = "SELECT passport_check()")
    String passport_check();

    @Query(nativeQuery = true, value = "SELECT entry_check()")
    String entry_check();

    @Query(nativeQuery = true, value = "SELECT work_check()")
    String work_check();

    @Query(nativeQuery = true, value = "SELECT declaration_check()")
    String declaration_check();

    @Query(nativeQuery = true, value = "SELECT criminal_check()")
    String criminal_check();

    @Query(nativeQuery = true, value = "SELECT next_one(:name, :surname, :lastname, :nationality, :eye_color, :fingerprint, :psname, :pssurname, :pslastname, :pseye_color, :psnationality, :enname, :ensurname, :enlastname, :endate_ganed, :endate_expired, :enpurpose, :workname, :worksurname, :worklastname, :workcompany, :lugsize, :lugweight, :lugcategory, :decname, :decsurname, :declastname, :decsize, :decweight, :deccat)")
    void next_one(@Param("name") String name,
                  @Param("surname") String surname,
                  @Param("lastname") String lastname,
                  @Param("nationality") String nationality,
                  @Param("eye_color") Integer eye_color,
                  @Param("fingerprint") Long fingerprint,
                  @Param("psname") String psname,
                  @Param("pssurname") String pssurname,
                  @Param("pslastname") String pslastname,
                  @Param("pseye_color") Integer pseye_color,
                  @Param("psnationality") String psnationality,
                  @Param("enname") String enname,
                  @Param("ensurname") String ensurname,
                  @Param("enlastname") String enlastname,
                  @Param("endate_ganed") Date endate_ganed,
                  @Param("endate_expired") Date endate_expired,
                  @Param("enpurpose") Integer enpurpose,
                  @Param("workname") String workname,
                  @Param("worksurname") String worksurname,
                  @Param("worklastname") String worklastname,
                  @Param("workcompany") Integer workcompany,
                  @Param("lugsize") Integer lugsize,
                  @Param("lugweight") Integer lugweight,
                  @Param("lugcategory") Integer lugcategory,
                  @Param("decname") String decname,
                  @Param("decsurname") String decsurname,
                  @Param("declastname") String declastname,
                  @Param("decsize") Integer decsize,
                  @Param("decweight") Integer decweight,
                  @Param("deccat") Integer deccat
                  );
}