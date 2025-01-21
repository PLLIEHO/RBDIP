package study.cursach.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "job")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer type_id;
    private Integer capacity;
    private Integer company_id;
}
