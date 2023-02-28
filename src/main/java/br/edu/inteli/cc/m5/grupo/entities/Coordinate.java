package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Coordinate {

    // Atributos para a entidade Nó
    @Id @GeneratedValue
    private Long id;
    private Double lat;
    private Double longi;
    private Double alt;

    public Coordinate(Double lat, Double longi, Double alt) {
        this.lat = lat;
        this.longi = longi;
        this.alt = alt;
    }

    // getters e setters

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

    public String toString() {
        return ("(" + lat + ", " + longi + ", " + alt + ")");
    }

}
