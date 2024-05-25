package org.example.automarket24backend.make;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.model.Model;

import java.util.Objects;
import java.util.Set;

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
//    @JsonIgnore
    private Set<Model> models;

    @OneToMany(mappedBy = "make")
    @JsonIgnore
    private Set<Car> cars;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Make make)) return false;
        return Objects.equals(id, make.id) && Objects.equals(name, make.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
