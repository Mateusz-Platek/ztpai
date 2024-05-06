package org.example.automarket24backend.offer;

import org.example.automarket24backend.car.SimpleCarResponse;

public record SimpleOfferResponse(
        Integer id,
        Integer price,
        SimpleCarResponse car
) {
}
