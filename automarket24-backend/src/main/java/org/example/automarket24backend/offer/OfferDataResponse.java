package org.example.automarket24backend.offer;

import org.example.automarket24backend.car.Car;

import java.sql.Timestamp;

public record OfferDataResponse(
        Integer id,
        Timestamp postTime,
        String description,
        Integer price,
        Car car
) {
}
