package study.cursach.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean is_borders_open;

    @Override
    public String toString(){
        return name + is_borders_open;
    }
}


