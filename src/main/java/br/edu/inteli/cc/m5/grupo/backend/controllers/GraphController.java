package br.edu.inteli.cc.m5.grupo.backend.controllers;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Graph;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.repositories.GraphRepository;

import org.springframework.data.neo4j.core.Neo4jTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

import br.edu.inteli.cc.m5.grupo.backend.services.GraphConstructor;

@RestController
@RequestMapping("/graph")
public class GraphController { 
    
    @Autowired
    private GraphRepository graphRepository;
    @Autowired
    private Neo4jTemplate neo4jTemplate;

    public static class GraphRequestData {
        public int rows;
        public int cols;
        public double latZero;
        public double longZero;
        public double altitude;
    }

    @PostMapping("/")
    public Graph storeGraph(@RequestBody GraphRequestData graphRequestData) {

        int rows = graphRequestData.rows;
        int cols = graphRequestData.cols;
        double latZero = graphRequestData.latZero;
        double longZero = graphRequestData.longZero;
        

        DtedDatabaseHandler dbRio = GraphConstructor.openDtedDB("dted/Rio");
        System.out.println("FODASE - ANTES DE CRIAR OS VERTICES");
        List<Vertex> vertexes = Arrays.asList(GraphConstructor.getCoordData(dbRio, rows, cols, latZero, longZero));
        System.out.println("FODASE - DEPOIS DE CRIAR OS VERTICES");
        
        Graph graph = new Graph(vertexes);
        System.out.println("FODASE - DEPOIS DE INSTANCIAR O GRAFO");
        return graphRepository.save(graph);
        
    }

    @GetMapping("/{id}")
    public Graph listById(Long id) {
        
        Graph graph = graphRepository.findById(id).orElseThrow();
        
        return graph;

    }

        

}