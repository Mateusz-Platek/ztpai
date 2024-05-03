package org.example.automarket24backend.offer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.user.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    @EqualsAndHashCode.Exclude
    private Car car;

    @ManyToMany(
        mappedBy = "observed",
        cascade = CascadeType.ALL
    )
    @JsonIgnore
    private Set<User> observers;
}
