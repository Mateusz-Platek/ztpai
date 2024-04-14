package org.example.automarket24backend.color;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;

import java.util.List;

@Entity
@Table(name = "colors")
@Data
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(
            mappedBy = "color",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Car> cars;
}
