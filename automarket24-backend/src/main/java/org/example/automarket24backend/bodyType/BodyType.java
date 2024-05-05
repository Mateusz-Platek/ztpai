package org.example.automarket24backend.bodyType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;

import java.util.Set;

@Entity
@Table(name = "body_types")
@Data
public class BodyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(
            mappedBy = "bodyType",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private Set<Car> cars;
}
