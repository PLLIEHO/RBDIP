package study.cursach.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "customs_param")
public class CustomsParamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;
    private Integer max_size;
    private Integer max_weight;
}
