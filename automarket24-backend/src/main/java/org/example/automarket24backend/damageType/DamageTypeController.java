package org.example.automarket24backend.damageType;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/damage-types")
@AllArgsConstructor
public class DamageTypeController {

    private DamageTypeRepository damageTypeRepository;

    @GetMapping
    public ResponseEntity<List<DamageType>> getDamageTypes() {
        return new ResponseEntity<>(damageTypeRepository.findAll(), HttpStatus.OK);
    }
}
