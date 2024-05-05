package org.example.automarket24backend.offer;

import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.user.UserDataResponse;

import java.sql.Timestamp;

public record OfferResponse(
        Integer id,
        Timestamp postTime,
        String description,
        Integer price,
        UserDataResponse user,
        Car car
) {
}
