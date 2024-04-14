package org.example.automarket24backend.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    List<Model> findAllByMakeNameContaining(String name);
    Model findModelByNameContaining(String name);
}
