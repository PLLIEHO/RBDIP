package study.cursach.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "entry_purpose")
public class EntryPurpose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

}