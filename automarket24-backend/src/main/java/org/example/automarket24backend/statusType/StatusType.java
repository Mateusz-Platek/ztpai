package org.example.automarket24backend.statusType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.user.User;

import java.util.List;

@Entity
@Table(name = "status_types")
@Data
public class StatusType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "statusType",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<User> users;
}
