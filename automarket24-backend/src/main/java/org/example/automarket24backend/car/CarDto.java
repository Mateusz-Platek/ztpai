package org.example.automarket24backend.car;

import java.util.List;

public record CarDto(
        Integer productionYear,
        Integer mileage,
        Integer power,
        Integer engineSize,
        Integer seats,
        Integer doors,
        Integer make,
        Integer model,
        Integer generation,
        Integer bodyType,
        Integer transmission,
        Integer drivetrain,
        Integer color,
        Integer fuelType,
        Integer damageType,
        Integer condition,
        List<Integer> features
) {
}
