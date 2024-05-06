package org.example.automarket24backend.car;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.automarket24backend.bodyType.BodyType;
import org.example.automarket24backend.color.Color;
import org.example.automarket24backend.condition.Condition;
import org.example.automarket24backend.damageType.DamageType;
import org.example.automarket24backend.drivetrain.Drivetrain;
import org.example.automarket24backend.feature.Feature;
import org.example.automarket24backend.fuelType.FuelType;
import org.example.automarket24backend.generation.Generation;
import org.example.automarket24backend.make.Make;
import org.example.automarket24backend.model.Model;
import org.example.automarket24backend.offer.Offer;
import org.example.automarket24backend.photo.Photo;
import org.example.automarket24backend.transmission.Transmission;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer productionYear;

    private Integer mileage;

    private Integer power;

    private Integer engineSize;

    private Integer seats;

    private Integer doors;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "generation_id")
    private Generation generation;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private BodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "drivetrain_id")
    private Drivetrain drivetrain;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;

    @ManyToOne
    @JoinColumn(name = "damage_type_id")
    private DamageType damageType;

    @ManyToOne
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.ALL
    )
    @EqualsAndHashCode.Exclude
    private Set<Photo> photos;

    @OneToOne
    @JoinColumn(name = "offer_id")
    @JsonIgnore
    private Offer offer;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> features;

    public SimpleCarResponse toSimpleCarResponse() {
        Photo images = photos.stream().filter(photo -> photo.getPath().contains("-1-")).findFirst().orElse(null);
        if (images == null) {
            return new SimpleCarResponse(make.getName(), model.getName(), productionYear, mileage, power, engineSize, fuelType.getName(), null);
        }

        return new SimpleCarResponse(make.getName(), model.getName(), productionYear, mileage, power, engineSize, fuelType.getName(), images.getPath());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(id, car.id) && Objects.equals(productionYear, car.productionYear) && Objects.equals(mileage, car.mileage) && Objects.equals(power, car.power) && Objects.equals(engineSize, car.engineSize) && Objects.equals(seats, car.seats) && Objects.equals(doors, car.doors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productionYear, mileage, power, engineSize, seats, doors);
    }
}
