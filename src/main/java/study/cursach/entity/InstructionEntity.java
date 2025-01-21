package study.cursach.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "instruction")
public class InstructionEntity {
    @Id
    private String date_of_order;
    private boolean positive_negative_type;
    private String name;
    private String surname;
    private String lastname;
    private Integer nationality;
    private Integer eye_color;
    private Integer job_id;
    private Integer job_type_id;
}
