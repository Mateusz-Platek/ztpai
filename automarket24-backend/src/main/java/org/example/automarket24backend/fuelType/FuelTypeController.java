package org.example.automarket24backend.fuelType;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fuel-types")
@AllArgsConstructor
public class FuelTypeController {

    private FuelTypeRepository fuelTypeRepository;

    @GetMapping
    public ResponseEntity<List<FuelType>> getFuelTypes() {
        return new ResponseEntity<>(fuelTypeRepository.findAll(), HttpStatus.OK);
    }
}
