package org.example.automarket24backend.offer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.user.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "offers")
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Timestamp postTime = Timestamp.valueOf(LocalDateTime.now());

    private String description;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(
        mappedBy = "offer",
        cascade = CascadeType.ALL
    )
    private Car car;

    @ManyToMany(mappedBy = "observedOffers")
    @JsonIgnore
    private Set<User> observingUsers;

    public OfferResponse toOfferResponse() {
        return new OfferResponse(id, postTime, description, price, user.toUserDataResponse(), car);
    }

    public OfferDataResponse toOfferDataResponse() {
        return new OfferDataResponse(id, postTime, description, price, car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer offer)) return false;
        return Objects.equals(id, offer.id) && Objects.equals(postTime, offer.postTime) && Objects.equals(description, offer.description) && Objects.equals(price, offer.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postTime, description, price);
    }
}
