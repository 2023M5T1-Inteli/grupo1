package br.edu.inteli.cc.m5.grupo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.inteli.cc.m5.grupo.backend.entities.Coordinate;
import br.edu.inteli.cc.m5.grupo.backend.entities.Path;
import br.edu.inteli.cc.m5.grupo.backend.repositories.PathRepository;

import org.springframework.data.neo4j.core.Neo4jTemplate;


import java.util.List;

@RestController
@RequestMapping("/path")   
public class PathController {
    
    @Autowired
    private PathRepository pathRepository;

    @GetMapping("/{id}")
    public Path getById(Long id) {
        return pathRepository.findById(id).orElseThrow();
    }

}