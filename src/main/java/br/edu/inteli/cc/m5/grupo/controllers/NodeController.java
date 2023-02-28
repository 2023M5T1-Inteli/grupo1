package br.edu.inteli.cc.m5.grupo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.inteli.cc.m5.grupo.entities.Node;
import br.edu.inteli.cc.m5.grupo.repositories.NodeRepository;

import java.util.List;

@RestController
@RequestMapping("/node")

public class NodeController {

    @AutoWired
    private NodeRepository nodeRepository;

    @GetMapping("/")
    public List<Node> listAll() {
        return nodeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Node getNodeById(@PathVariable Long id) {
        return nodeRepository.findById(id).orElse(null);
    }

}