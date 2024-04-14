package org.example.automarket24backend.model;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ModelController {

    private ModelRepository modelRepository;

    @GetMapping("/models")
    public ResponseEntity<List<Model>> getModels(@RequestParam String makeName) {
        return new ResponseEntity<>(modelRepository.findAllByMakeNameContaining(makeName), HttpStatus.OK);
    }
}
