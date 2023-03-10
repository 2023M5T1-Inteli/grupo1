package br.edu.inteli.cc.m5.grupo.backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Arrays;
import java.util.List;

@Node
public class Graph {
    
    @Id @GeneratedValue
    private Long id;

    private List<Vertex> vertexes;

    public Graph(List<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public Long getId() {
        return id;
    }

    public void addVertex(Vertex vertex) {
        this.vertexes.add(vertex);
    }

    public String toString() {

        String initial = "";
        for (Vertex vertex : vertexes) {
            initial += vertex + ", ";
        }

        return initial;

    }

}
