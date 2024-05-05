package org.example.automarket24backend.damageType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;

import java.util.Set;

@Entity
@Table(name = "damage_types")
@Data
public class DamageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(
            mappedBy = "damageType",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private Set<Car> cars;
}
