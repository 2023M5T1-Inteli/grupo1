/**
Class responsible for controlling requests related to graphs.
*/
package br.edu.inteli.cc.m5.grupo.backend.controllers;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Grid;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.repositories.VertexRepository;
import br.edu.inteli.cc.m5.grupo.backend.services.GraphConstructor;
import br.edu.inteli.cc.m5.grupo.backend.services.Star;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping("/graph")
public class GraphController {
    
    /**
    * Neo4jTemplate instance to interact with Neo4j database.
    */
    @Autowired
    private Neo4jTemplate neo4jTemplate;
    /**
     * Repository of vertices in Neo4j database.
     */
    @Autowired
    private VertexRepository vertexRepository;

    /**
     * Inner class that defines the data needed to construct a graph.
     */
    public static class GraphRequestData {
        public double latZero; // Latitude of the position (0, 0) in the coordinate grid.
        public double longZero; // Longitude of the position (0, 0) in the coordinate grid.
        public double finalLat; // Number of rows in the coordinate grid.
        public double finalLong; // Number of columns in the coordinate grid.
        public double pathLatX;
        public double pathLongX;
        public double pathLatY;
        public double pathLongY;
    }

    /**
     * Endpoint responsible for receiving the data needed to construct a graph and returning a path between vertices.
     * 
     * @param graphRequestData Data needed to construct the graph.
     * @return Path between two vertices.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public ResponseEntity<List<Vertex>> storeGraph(@RequestBody GraphRequestData graphRequestData) {
        GraphConstructor graphConstructor = new GraphConstructor(vertexRepository, neo4jTemplate);

        double finalLat = graphRequestData.finalLat;
        double finalLong = graphRequestData.finalLong;
        double latZero = graphRequestData.latZero;
        double longZero = graphRequestData.longZero;
        double pathLatX = graphRequestData.pathLatX;
        double pathLatY = graphRequestData.pathLatY;
        double pathLongX = graphRequestData.pathLongX;
        double pathLongY = graphRequestData.pathLongY;

        DtedDatabaseHandler dbRio = GraphConstructor.openDtedDB("dted/Rio");

        //-22.2862,-43.2550 -22.3647,-43.2433
        //-22.3647,-43.2433


        System.out.println("Vai criar a grid");
        Grid grid = new Grid(dbRio, longZero, latZero, finalLong, finalLat);
        System.out.println("CRIOU A GRID");

        //grid.findVertex(pathLongX, pathLongY);

        System.out.println("MANDANDO");
        Vertex vertexX = grid.findVertex(-43.2550, -22.2862);
        System.out.println("vertex x : " + vertexX);
        Vertex vertexY = grid.findVertex(-43.2433, -22.3647);
        System.out.println("vertex y : " + vertexY);

        // List<Vertex> vertexes = Arrays.asList(graphConstructor.getCoordData(dbRio, rows, cols, latZero, longZero));

        List<Vertex> path = Star.findPath(vertexX, vertexY);

        return ResponseEntity.ok(path);

    }

}