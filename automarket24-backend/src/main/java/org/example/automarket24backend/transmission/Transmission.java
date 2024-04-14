package org.example.automarket24backend.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;

import java.util.List;

@Entity
@Table(name = "transmissions")
@Data
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(
            mappedBy = "transmission",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Car> cars;
}
