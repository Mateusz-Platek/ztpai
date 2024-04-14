package org.example.automarket24backend.bodyType;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/body-types")
@AllArgsConstructor
public class BodyTypeController {

    private BodyTypeRepository bodyTypeRepository;

    @GetMapping
    public ResponseEntity<List<BodyType>> getBodyTypes() {
        return new ResponseEntity<>(bodyTypeRepository.findAll(), HttpStatus.OK);
    }
}
