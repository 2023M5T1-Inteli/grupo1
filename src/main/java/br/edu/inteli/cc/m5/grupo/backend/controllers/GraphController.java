package br.edu.inteli.cc.m5.grupo.backend.controllers;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Graph;
import br.edu.inteli.cc.m5.grupo.backend.services.Star;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.repositories.VertexRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

import br.edu.inteli.cc.m5.grupo.backend.services.GraphConstructor;

@RestController
@RequestMapping("/graph")
public class GraphController { 
    
    @Autowired
    private Neo4jTemplate neo4jTemplate;
    @Autowired
    private VertexRepository vertexRepository; 

    public static class GraphRequestData {
        public int rows;
        public int cols;
        public double latZero;
        public double longZero;
    }

    @PostMapping("/")
    public String storeGraph(@RequestBody GraphRequestData graphRequestData) {
    
        GraphConstructor graphConstructor = new GraphConstructor(vertexRepository, neo4jTemplate);

        int rows = graphRequestData.rows;
        int cols = graphRequestData.cols;
        double latZero = graphRequestData.latZero;
        double longZero = graphRequestData.longZero;
    
        DtedDatabaseHandler dbRio = GraphConstructor.openDtedDB("dted/Rio");

        List<Vertex> vertexes = Arrays.asList(graphConstructor.getCoordData(dbRio, rows, cols, latZero, longZero));
    
        System.out.println("Size:");
        System.out.println(vertexes.size());
        // Salva os vértices no vertexRepository
    
        List<Vertex> path = Star.findPath(vertexes.get(4), vertexes.get(61));
    
        path.add(vertexes.get(4));
    
        Collections.reverse(path);
    
        System.out.print("\n\n\n\n\n");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < path.size(); i++) {
            Vertex vertex = path.get(i);
            sb.append("{ id: ").append(vertex.getId()).append(", lat: ").append(vertex.getLatitude())
                .append(", longi: ").append(vertex.getLongitude()).append("}");
            if (i < path.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    
    }
    
}