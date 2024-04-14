package org.example.automarket24backend.generation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenerationRepository extends JpaRepository<Generation, Integer> {
    List<Generation> findAllByModelNameContaining(String name);
}
