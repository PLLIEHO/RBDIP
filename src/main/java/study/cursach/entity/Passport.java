package study.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "passport")
public class Passport {
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "surname", nullable = false, length = Integer.MAX_VALUE)
    private String surname;

    @Column(name = "lastname", length = Integer.MAX_VALUE)
    private String lastname;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "eye_color", nullable = false)
    private Integer eyeColor;

    @Column(name = "nationality", nullable = false, length = Integer.MAX_VALUE)
    private String nationality;

}