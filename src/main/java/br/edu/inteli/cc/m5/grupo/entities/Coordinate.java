package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
public class Coordinate {

    // Atributos para a entidade Nó
    @Id @GeneratedValue
    private Long id;
    private Double lat;
    private Double longi;
    private Double alt;
    private List<Coordinate> adjacents;

    public Coordinate(Double lat, Double longi, Double alt) {
        this.lat = lat;
        this.longi = longi;
        this.alt = alt;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }   

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLat() {
        return lat;
    }

    public void setLongi(Double longi) {
        this.longi = longi;
    }

    public Double getLongi() {
        return longi;
    }

    public void setAlt(Double alt) {
        this.alt = alt;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAdjacents(List<Coordinate> nodes) {
        adjacents = nodes;
    }

    public List<Coordinate> getAdjacents() {
        return adjacents;
    }

    public String toString() {
        String latStr = lat.toString();
        String longiStr = longi.toString();
        String altStr = alt.toString();
        return String.format("(%1$-3s, %2$-3s, %3$-3s)", latStr, longiStr, altStr);
    }

}