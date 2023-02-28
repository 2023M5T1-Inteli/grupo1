package br.edu.inteli.cc.m5.grupo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.inteli.cc.m5.grupo.entities.GraphNode;
import br.edu.inteli.cc.m5.grupo.repositories.GraphNodeRepository;

import java.util.List;

@RestController
@RequestMapping("/node")
public class GraphNodeController { 

    @Autowired
    private GraphNodeRepository nodeRepository;
    
    @GetMapping("/")
    public List<GraphNode> getAllNodes() {
        return nodeRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public GraphNode getNodeById(@PathVariable Long id) {
        return nodeRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public GraphNode createNode(@RequestBody GraphNode Node) {
        return nodeRepository.save(Node);
    }

    @PutMapping("/{id}")
    public GraphNode updateNode(@PathVariable Long id, @RequestBody GraphNode node) {
        GraphNode existingNode = nodeRepository.findById(id).orElse(null);
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