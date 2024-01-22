package study.cursach.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login", length = Integer.MAX_VALUE)
    private String login;

    @Column(name = "pass", length = Integer.MAX_VALUE)
    private String pass;

}