/**

This class is responsible for providing services related to vertices in the application.
*/
package br.edu.inteli.cc.m5.grupo.backend.services;

import org.springframework.stereotype.Service;

import br.edu.inteli.cc.m5.grupo.backend.repositories.VertexRepository;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;

@Service
public class VertexService {

    private final VertexRepository vertexRepository;

    /**
     * Constructs a new VertexService instance, initializing the vertex repository.
     * 
     * @param vertexRepository the repository used to manage vertices.
     */
    public VertexService(VertexRepository vertexRepository) {
        this.vertexRepository = vertexRepository;
    }

    /**
     * Adds an edge between two vertices.
     * 
     * @param v1 the first vertex.
     * @param v2 the second vertex.
     */
    public static void addEdge(Vertex v1, Vertex v2) {
        v1.addEdge(v2);
    }

    /**
     * Adds a new vertex to the repository.
     * 
     * @param vertex the vertex to be added.
     * @return the added vertex.
     */
    public Vertex addVertex(Vertex vertex) {
        return vertexRepository.save(vertex);
    }

    /**
     * Retrieves all vertices from the repository.
     * 
     * @return an iterable containing all vertices.
     */
    public Iterable<Vertex> getAllVertices() {
        return vertexRepository.findAll();
    }

    /**
     * Retrieves a vertex by its id from the repository.
     * 
     * @param id the id of the vertex.
     * @return the vertex with the given id, or null if it is not found.
     */
    public Vertex getVertexById(Long id) {
        return vertexRepository.findById(id).orElse(null);
    }

}