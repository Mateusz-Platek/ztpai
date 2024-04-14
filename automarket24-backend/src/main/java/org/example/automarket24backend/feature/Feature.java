package org.example.automarket24backend.feature;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;

import java.util.List;

@Entity
@Table(name = "features")
@Data
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToMany(
            mappedBy = "features",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Car> cars;
}
