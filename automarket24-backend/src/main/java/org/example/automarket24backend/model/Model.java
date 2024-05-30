package org.example.automarket24backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.generation.Generation;
import org.example.automarket24backend.make.Make;

import java.util.Objects;
import java.util.Set;

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
//    @JsonIgnore
    private Set<Generation> generations;

    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private Set<Car> cars;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model model)) return false;
        return Objects.equals(id, model.id) && Objects.equals(name, model.name) && Objects.equals(make, model.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, make);
    }
}
