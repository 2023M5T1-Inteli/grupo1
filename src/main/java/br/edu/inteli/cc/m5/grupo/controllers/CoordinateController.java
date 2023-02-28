package br.edu.inteli.cc.m5.grupo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.inteli.cc.m5.grupo.entities.Coordinate;
import br.edu.inteli.cc.m5.grupo.repositories.CoordinateRepository;

import java.util.List;

@RestController
@RequestMapping("/node")
public class CoordinateController { 

    @Autowired
    private CoordinateRepository nodeRepository;
    
    @GetMapping("/")
    public List<Coordinate> getAllNodes() {
        return nodeRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Coordinate getNodeById(@PathVariable Long id) {
        return nodeRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Coordinate createNode(@RequestBody Coordinate Node) {
        return nodeRepository.save(Node);
    }

    @PutMapping("/{id}")
    public Coordinate updateNode(@PathVariable Long id, @RequestBody Coordinate node) {
        Coordinate existingNode = nodeRepository.findById(id).orElse(null);
        if (existingNode != null) {
            existingNode.setAlt(node.getAlt());;
            existingNode.setLat(node.getLat());
            existingNode.setLongi(node.getLongi());
            return nodeRepository.save(existingNode);
        }
        return null;    
    }

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable Long id) {
        nodeRepository.deleteById(id);
    }

}