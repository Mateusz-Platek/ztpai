package org.example.automarket24backend.make;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MakeController {

    private MakeRepository makeRepository;

    @GetMapping("/makes")
    public ResponseEntity<List<Make>> getMakes() {
        return new ResponseEntity<>(makeRepository.findAll(), HttpStatus.OK);
    }
}
