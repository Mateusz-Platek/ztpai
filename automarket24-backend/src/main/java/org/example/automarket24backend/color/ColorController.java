package org.example.automarket24backend.color;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colors")
@AllArgsConstructor
public class ColorController {

    private ColorRepository colorRepository;

    @GetMapping
    private ResponseEntity<List<Color>> getColors() {
        return new ResponseEntity<>(colorRepository.findAll(), HttpStatus.OK);
    }
}
