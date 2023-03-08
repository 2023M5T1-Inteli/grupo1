package br.edu.inteli.cc.m5.grupo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.inteli.cc.m5.grupo.entities.Graph;
import br.edu.inteli.cc.m5.grupo.repositories.GraphRepository;
import org.springframework.data.neo4j.core.Neo4jTemplate;

import java.util.List;

@RestController
@RequestMapping("/graph")
public class GraphController { 
    
    @Autowired
    private GraphRepository graphRepository;
    
    /**
     * This method handles a GET request for retrieving all graphs.
     * @return a List of all graphs stored in the database.
     */
    @GetMapping("/")
    public List<Graph> listGraph() {
        return graphRepository.findAll();
    }
    
    /**
     * This method handles a GET request for retrieving a graph by its ID.
     * @param id the ID of the graph to retrieve.
     * @return the Graph object corresponding to the specified ID, or null if it does not exist.
     */
    @GetMapping("/{id}")
    public Graph getGraphById(@PathVariable Long id) {
        return graphRepository.findById(id).orElse(null);
    }
    
    /**
     * This method handles a POST request for creating a new graph.
     * @param Graph the Graph object to create.
     * @return the newly created Graph object.
     */
    @PostMapping("/")
    public Graph createGraph(@RequestBody Graph graph) {
        return graphRepository.save(graph);
    }
    
    /**
     * This method handles a DELETE request for deleting a graph.
     * @param id the ID of the graph to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteGraph(@PathVariable Long id) {
        graphRepository.deleteById(id);
    }

}