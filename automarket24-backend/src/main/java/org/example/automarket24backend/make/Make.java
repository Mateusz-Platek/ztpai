package org.example.automarket24backend.make;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.model.Model;

import java.util.List;

@Entity
@Table(name = "makes")
@Data
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "make")
    @JsonIgnore
    private List<Model> models;

    @OneToMany(mappedBy = "make")
    @JsonIgnore
    private List<Car> cars;
}
