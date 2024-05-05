package org.example.automarket24backend.user;

import org.example.automarket24backend.offer.OfferDataResponse;

import java.util.List;

public record UserResponse(
        Integer id,
        String email,
        String phoneNumber,
        String location,
        List<OfferDataResponse> offers,
        List<OfferDataResponse> observedOffers
) {
}
