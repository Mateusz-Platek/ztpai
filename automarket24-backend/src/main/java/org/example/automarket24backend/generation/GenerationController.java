package org.example.automarket24backend.generation;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generations")
@AllArgsConstructor
public class GenerationController {

    private GenerationRepository generationRepository;

    @GetMapping
    public ResponseEntity<List<Generation>> getGenerations(@RequestParam String modelName) {
        return new ResponseEntity<>(generationRepository.findAllByModelNameContaining(modelName), HttpStatus.OK);
    }
}
