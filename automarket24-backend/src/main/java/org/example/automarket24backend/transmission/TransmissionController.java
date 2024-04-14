package org.example.automarket24backend.transmission;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transmissions")
@AllArgsConstructor
public class TransmissionController {

    private TransmissionRepository transmissionRepository;

    @GetMapping
    public ResponseEntity<List<Transmission>> getGearboxes() {
        return new ResponseEntity<>(transmissionRepository.findAll(), HttpStatus.OK);
    }
}
