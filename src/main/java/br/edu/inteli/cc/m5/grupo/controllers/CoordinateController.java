package br.edu.inteli.cc.m5.grupo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.inteli.cc.m5.grupo.entities.Coordinate;
import br.edu.inteli.cc.m5.grupo.repositories.CoordinateRepository;

import java.util.List;

@RestController
@RequestMapping("/coordinate")
public class CoordinateController { 
    
    @Autowired
    private CoordinateRepository coordinateRepository;
    
    /**
     * This method handles a GET request for retrieving all coordinates.
     * @return a List of all coordinates stored in the database.
     */
    @GetMapping("/")
    public List<Coordinate> getAllNodes() {
        return coordinateRepository.findAll();
    }
    
    /**
     * This method handles a GET request for retrieving a coordinate by its ID.
     * @param id the ID of the coordinate to retrieve.
     * @return the Coordinate object corresponding to the specified ID, or null if it does not exist.
     */
    @GetMapping("/{id}")
    public Coordinate getNodeById(@PathVariable Long id) {
        return coordinateRepository.findById(id).orElse(null);
    }
    
    // /**
    //  * This method handles a POST request for creating a new coordinate.
    //  * @param Node the Coordinate object to create.
    //  * @return the newly created Coordinate object.
    //  */
    // @PostMapping("/")
    // public Coordinate createNode(@RequestBody Coordinate Node) {
    //     return coordinateRepository.save(Node);
    // }
    
    // /**
    //  * This method handles a PUT request for updating an existing coordinate.
    //  * @param id the ID of the coordinate to update.
    //  * @param node the updated Coordinate object.
    //  * @return the updated Coordinate object, or null if the specified ID does not exist.
    //  */
    // @PutMapping("/{id}")
    // public Coordinate updateNode(@PathVariable Long id, @RequestBody Coordinate node) {
    //     Coordinate existingNode = coordinateRepository.findById(id).orElse(null);
    //     if (existingNode != null) {
    //         existingNode.setAlt(node.getAlt());;
    //         existingNode.setLat(node.getLat());
    //         existingNode.setLongi(node.getLongi());
    //         return coordinateRepository.save(existingNode);
    //     }
    //     return null;    
    // }
    
    /**
     * This method handles a DELETE request for deleting a coordinate.
     * @param id the ID of the coordinate to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable Long id) {
        coordinateRepository.deleteById(id);
    }

}