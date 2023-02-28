package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
public class Path {

    // Atributos para a entidade Nó
    @Id @GeneratedValue
    private Long id;
    private Long weight;
    private Long distance; 
    private List<Coordinate> nodes;

    public Path(List<Coordinate> nodes, Long weight, Long distance) {
        this.nodes = nodes;
        this.weight = weight;
        this.distance = distance;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }
    
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWeight() {
        return weight;
    }        

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Long getDistance() {
        return distance;
    }

    public void setNodes(List<Coordinate> nodes) {
        this.nodes = nodes;
    }
    
    public List<Coordinate> getNodes() {
        return this.nodes;
    }

}