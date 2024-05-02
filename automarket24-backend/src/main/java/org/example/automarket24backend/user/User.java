package org.example.automarket24backend.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.automarket24backend.offer.Offer;
import org.example.automarket24backend.statusType.StatusType;
import org.example.automarket24backend.userType.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String phoneNumber;

    private String location;

    @ManyToOne
    @JoinColumn(name = "status_type_id")
    private StatusType statusType;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Offer> offers;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id")
    )
    private List<Offer> observed;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userType.getName()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (statusType.getName().equals("Blocked")) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
