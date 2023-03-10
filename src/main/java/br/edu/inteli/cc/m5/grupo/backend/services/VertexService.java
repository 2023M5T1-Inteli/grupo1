package br.edu.inteli.cc.m5.grupo.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.inteli.cc.m5.grupo.backend.repositories.VertexRepository;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;

@Service
public class VertexService {
    
    private final VertexRepository vertexRepository;
    
    @Autowired
    public VertexService(VertexRepository vertexRepository) {
        this.vertexRepository = vertexRepository;
    }

    public static void addEdge(Vertex v1, Vertex v2) {
        v1.addEdge(v2);
    }
    
    public Vertex addVertex(Vertex vertex) {
        return vertexRepository.save(vertex);
    }

    public Iterable<Vertex> getAllVertices() {
        return vertexRepository.findAll();
    }
    
    public Vertex getVertexById(Long id) {
        return vertexRepository.findById(id).orElse(null);
    }
}