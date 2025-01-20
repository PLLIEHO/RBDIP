package study.cursach.dto;

import lombok.Data;

@Data
public class InstructionDTO {
    private String date_of_order;
    private boolean positive_negative_type;
    private String name;
    private String surname;
    private String lastname;
    private String nationality;
    private Integer eye_color;
    private String job_company;
    private String job_type;
}
