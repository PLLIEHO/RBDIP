package study.cursach.dto;

import lombok.Data;

@Data
public class CriminalDTO {
    private Long fingerprint;
    private String name;
    private String surname;
    private String lastname;
    private String nationality;
    private Integer eye_color;
}
