package study.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "next_generated")
public class NextGeneratedEntity {

    @Id
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "surname", length = Integer.MAX_VALUE)
    private String surname;

    @Column(name = "lastname", length = Integer.MAX_VALUE)
    private String lastname;

    @Column(name = "nationality", length = Integer.MAX_VALUE)
    private String nationality;

    @Column(name = "eye_color")
    private Integer eyeColor;

    @Column(name = "fingerprint")
    private Long fingerprint;

    @Column(name = "psname", length = Integer.MAX_VALUE)
    private String psname;

    @Column(name = "pssurname", length = Integer.MAX_VALUE)
    private String pssurname;

    @Column(name = "pslastname", length = Integer.MAX_VALUE)
    private String pslastname;

    @Column(name = "pseye_color")
    private Integer pseyeColor;

    @Column(name = "psnationality", length = Integer.MAX_VALUE)
    private String psnationality;

    @Column(name = "enname", length = Integer.MAX_VALUE)
    private String enname;

    @Column(name = "ensurname", length = Integer.MAX_VALUE)
    private String ensurname;

    @Column(name = "enlastname", length = Integer.MAX_VALUE)
    private String enlastname;

    @Column(name = "endate_ganed")
    private Date endateGaned;

    @Column(name = "endate_expired")
    private Date endateExpired;

    @Column(name = "enpurpose")
    private Integer enpurpose;

    @Column(name = "workname", length = Integer.MAX_VALUE)
    private String workname;

    @Column(name = "worksurname", length = Integer.MAX_VALUE)
    private String worksurname;

    @Column(name = "worklastname", length = Integer.MAX_VALUE)
    private String worklastname;

    @Column(name = "workcompany")
    private Integer workcompany;

    @Column(name = "lugsize")
    private Integer lugsize;

    @Column(name = "lugweight")
    private Integer lugweight;

    @Column(name = "lugcategory")
    private Integer lugcategory;

    @Column(name = "decname", length = Integer.MAX_VALUE)
    private String decname;

    @Column(name = "decsurname", length = Integer.MAX_VALUE)
    private String decsurname;

    @Column(name = "declastname", length = Integer.MAX_VALUE)
    private String declastname;

    @Column(name = "decsize")
    private Integer decsize;

    @Column(name = "decweight")
    private Integer decweight;

    @Column(name = "deccat")
    private Integer deccat;
}
