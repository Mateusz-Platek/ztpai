package org.example.automarket24backend.offer;

import org.example.automarket24backend.car.Car;

import java.sql.Timestamp;

public record OfferSearchResponse(
    Integer id,
    Timestamp postTime,
    Integer price,
    String location,
    Car car
) {
}
