package org.example.automarket24backend.generation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.model.Model;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "generations")
@Data
public class Generation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "model_id")
    @JsonIgnore
    private Model model;

    @OneToMany(mappedBy = "generation")
    @JsonIgnore
    private Set<Car> cars;
}
