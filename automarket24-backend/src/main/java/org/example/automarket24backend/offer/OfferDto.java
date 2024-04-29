package org.example.automarket24backend.offer;

import org.example.automarket24backend.car.CarDto;

public record OfferDto(
        String description,
        Integer price,
        Integer userId,
        CarDto car
) {
}
