package org.example.automarket24backend.condition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;

import java.util.Set;

@Entity
@Table(name = "conditions")
@Data
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(
            mappedBy = "condition",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private Set<Car> cars;
}
