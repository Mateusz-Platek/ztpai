package org.example.automarket24backend.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.automarket24backend.offer.Offer;
import org.example.automarket24backend.offer.OfferDataResponse;
import org.example.automarket24backend.statusType.StatusType;
import org.example.automarket24backend.userType.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
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
    @EqualsAndHashCode.Exclude
    private Set<Offer> offers;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id")
    )
    private Set<Offer> observedOffers;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority(userType.getName()));
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

    public UserResponse toUserResponse() {
        List<OfferDataResponse> offersData = offers.stream().map(Offer::toOfferDataResponse).toList();
        List<OfferDataResponse> observedOffersData = observedOffers.stream().map(Offer::toOfferDataResponse).toList();
        return new UserResponse(id, email, phoneNumber, location, offersData, observedOffersData);
    }

    public UserDataResponse toUserDataResponse() {
        return new UserDataResponse(id, email, phoneNumber, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(location, user.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, phoneNumber, location);
    }
}
