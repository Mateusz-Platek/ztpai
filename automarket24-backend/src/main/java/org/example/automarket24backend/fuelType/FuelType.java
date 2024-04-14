package org.example.automarket24backend.fuelType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;

import java.util.List;

@Entity
@Table(name = "fuel_types")
@Data
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(
            mappedBy = "fuelType",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Car> cars;
}
