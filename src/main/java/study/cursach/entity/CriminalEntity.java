package study.cursach.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "criminal")
public class CriminalEntity {
    @Id
    private Long fingerprint;
    private String name;
    private String surname;
    private String lastname;
    private Integer nationality;
    private Integer eye_color;
}
