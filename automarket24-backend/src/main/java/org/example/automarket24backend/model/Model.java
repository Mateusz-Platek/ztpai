package org.example.automarket24backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.generation.Generation;
import org.example.automarket24backend.make.Make;

import java.util.List;

@Entity
@Table(name = "models")
@Data
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "make_id")
    @JsonIgnore
    private Make make;

    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private List<Generation> generations;

    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private List<Car> cars;
}
