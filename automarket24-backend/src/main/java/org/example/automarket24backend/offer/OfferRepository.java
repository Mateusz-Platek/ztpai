package org.example.automarket24backend.offer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    List<Offer> findAllByUserId(Integer id);
}
