package org.example.automarket24backend.feature;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/features")
@AllArgsConstructor
public class FeatureController {

    private FeatureRepository featureRepository;

    @GetMapping
    public ResponseEntity<List<Feature>> getFeatures() {
        return new ResponseEntity<>(featureRepository.findAll(), HttpStatus.OK);
    }
}
