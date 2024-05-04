package org.example.automarket24backend.userType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.automarket24backend.user.User;

import java.util.Set;

@Entity
@Table(name = "user_types")
@Data
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(
            mappedBy = "userType",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<User> users;
}
