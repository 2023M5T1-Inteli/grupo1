package br.edu.inteli.cc.m5.grupo.controllers;

import br.edu.inteli.cc.m5.grupo.entities.Coordinate;
import br.edu.inteli.cc.m5.grupo.repositories.CoordinateRepository;

import org.springframework.data.neo4j.core.Neo4jTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@RestController
@RequestMapping("/coordinate")
public class CoordinateController { 
    
    @Autowired
    private CoordinateRepository coordinateRepository;
    @Autowired
    private Neo4jTemplate neo4jTemplate;


    /**
     * This method handles a GET request for retrieving all coordinates.
     * @return a List of all coordinates stored in the database.
     */
    @GetMapping("/")
    public List<Coordinate> listAllCoordinates() {
        return coordinateRepository.findAll();
    }

    @GetMapping("/adjacent/{id}")
    public List<Coordinate> listAllAdjacentCoordinates(@PathVariable Long id) {
        Coordinate coordinate = listCoordinateById(id);
        return coordinate.getAdjacents();
    }
    
    /**
     * This method handles a GET request for retrieving a coordinate by its ID.
     * @param id the ID of the coordinate to retrieve.
     * @return the Coordinate object corresponding to the specified ID, or null if it does not exist.
     */
    @GetMapping("/{id}")
    public Coordinate listCoordinateById(@PathVariable Long id) {
        return coordinateRepository.findById(id).orElse(null);
    }
    
    /**
     * This method handles a POST request for creating a new coordinate.
     * @param Coordinate the Coordinate object to store.
     * @return the newly stored Coordinate object.
     */
    @PostMapping("/")
    public Coordinate storeCoordinate(@RequestBody Coordinate coordinate) {
        return coordinateRepository.save(coordinate);
    }

    // @PostMapping("/adjacent/{id}")
    // public Coordinate createAdjacentCoordinate(@PathVariable Long id, @RequestBody Coordinate adjacentCoordinate) {
    //     // Encontra a coordenada pelo ID
    //     Coordinate coordinate = listCoordinateById(id);
        
    //     // Adiciona a coordenada adjacente à lista de adjacências
    //     List<Coordinate> adjacents = coordinate.getAdjacents();
        
    //     coordinate.addAdjacent(adjacentCoordinate);
        
    //     adjacents.add(adjacentCoordinate);
    //     coordinate.setAdjacents(adjacents);
        
    //     // Salva a relação no Neo4j
    //     neo4jTemplate.save(coordinate);
        
    //     // Retorna a coordenada com o adjacente atualizado
    //     return coordinate;
    // }    

    @PostMapping("adjacent/set/{id}")
    public Coordinate setAllAdjacentCoordinates(@PathVariable Long id, @RequestBody Map<String, List<Integer>> adjacents) {
        // Encontra a coordenada pelo ID
        Coordinate coordinate = listCoordinateById(id);
    
        List<Integer> ids = adjacents.get("adjacentCoordinatesIds");
    
        List<Coordinate> adjacentCoordinates = new ArrayList<>();
        
        ids.forEach(adjacentId -> {
            Coordinate adjacentCoordinate = listCoordinateById(adjacentId.longValue());
            adjacentCoordinates.add(adjacentCoordinate);
        });
        
        coordinate.setAdjacents(adjacentCoordinates);
    
        // Salva a relação no Neo4j
        neo4jTemplate.save(coordinate);
            
        // Retorna a coordenada com os adjacentes atualizados
        return coordinate;
    }

    @PostMapping("/adjacent/{id}")
    public Coordinate storeAdjacentCoordinate(@PathVariable Long id, @RequestBody Map<String, Long> requestBody) {
        // Encontra a coordenada pelo ID
        Coordinate coordinate = listCoordinateById(id);
        Coordinate adjacentCoordinate = listCoordinateById(requestBody.get("adjacentCoordinateId"));

        // Adiciona a coordenada adjacente à lista de adjacências
        List<Coordinate> adjacents = coordinate.getAdjacents();
        
        adjacents.add(adjacentCoordinate);
        coordinate.setAdjacents(adjacents);
        
        // Salva a relação no Neo4j
        neo4jTemplate.save(coordinate);
        
        // Retorna a coordenada com o adjacente atualizado
        return coordinate;
    }    

    /**
     * This method handles a PUT request for updating an existing coordinate.
     * @param id the ID of the coordinate to update.
     * @param coordinate the updated Coordinate object.
     * @return the updated Coordinate object, or null if the specified ID does not exist.
     */
    @PutMapping("/{id}")
    public Coordinate updateCoordinate(@PathVariable Long id, @RequestBody Coordinate coordinate) {
        Coordinate existingCoordinate = coordinateRepository.findById(id).orElse(null);
        if (existingCoordinate != null) {
            existingCoordinate.setAlt(coordinate.getAlt());;
            existingCoordinate.setLat(coordinate.getLat());
            existingCoordinate.setLongi(coordinate.getLongi());
            return coordinateRepository.save(existingCoordinate);
        }
        return null;    
    }
    
    /**
     * This method handles a DELETE request for deleting a coordinate.
     * @param id the ID of the coordinate to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteCoordinate(@PathVariable Long id) {
        Coordinate coordinate = coordinateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordenada com o id: " + id + " não encontrada "));
        coordinateRepository.delete(coordinate);
    }    

}