package org.example.automarket24backend.drivetrain;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drivetrains")
@AllArgsConstructor
public class DrivetrainController {

    private DrivetrainRepository drivetrainRepository;

    @GetMapping
    public ResponseEntity<List<Drivetrain>> getDrivetrains() {
        return new ResponseEntity<>(drivetrainRepository.findAll(), HttpStatus.OK);
    }
}
