package org.example.automarket24backend.car;

public record SimpleCarResponse(
        String make,
        String model,
        Integer productionYear,
        Integer mileage,
        Integer power,
        Integer engineSize,
        String fuelType,
        String photoPath
) {
}
