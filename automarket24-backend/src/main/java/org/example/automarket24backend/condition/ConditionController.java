package org.example.automarket24backend.condition;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conditions")
@AllArgsConstructor
public class ConditionController {

    private ConditionRepository conditionRepository;

    @GetMapping
    public ResponseEntity<List<Condition>> getConditions() {
        return new ResponseEntity<>(conditionRepository.findAll(), HttpStatus.OK);
    }
}
