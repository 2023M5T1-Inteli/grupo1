package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
public class Coordinate {
    
    // Node attributes
    @Id @GeneratedValue
    private Long id;
    private Double lat;
    private Double longi;
    private Double alt;
    private List<Coordinate> adjacents;

    /**
     * Constructor for a Coordinate object.
     * 
     * @param lat the latitude coordinate
     * @param longi the longitude coordinate
     * @param alt the altitude coordinate
     */
    public Coordinate(Double lat, Double longi, Double alt) {
        this.lat = lat;
        this.longi = longi;
        this.alt = alt;
    }

    // Getters and setters

    /**
     * Returns the ID of this node.
     * 
     * @return the ID of this node
     */
    public Long getId() {
        return id;
    }   

    /**
     * Sets the latitude coordinate of this node.
     * 
     * @param lat the latitude coordinate to set
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * Returns the latitude coordinate of this node.
     * 
     * @return the latitude coordinate of this node
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Sets the longitude coordinate of this node.
     * 
     * @param longi the longitude coordinate to set
     */
    public void setLongi(Double longi) {
        this.longi = longi;
    }

    /**
     * Returns the longitude coordinate of this node.
     * 
     * @return the longitude coordinate of this node
     */
    public Double getLongi() {
        return longi;
    }

    /**
     * Sets the altitude coordinate of this node.
     * 
     * @param alt the altitude coordinate to set
     */
    public void setAlt(Double alt) {
        this.alt = alt;
    }

    /**
     * Returns the altitude coordinate of this node.
     * 
     * @return the altitude coordinate of this node
     */
    public Double getAlt() {
        return alt;
    }

    /**
     * Sets the adjacent nodes of this node.
     * 
     * @param nodes the adjacent nodes to set
     */
    public void setAdjacents(List<Coordinate> nodes) {
        adjacents = nodes;
    }

    /**
     * Returns the adjacent nodes of this node.
     * 
     * @return the adjacent nodes of this node
     */
    public List<Coordinate> getAdjacents() {
        return adjacents;
    }

    /**
     * Returns a string representation of this node.
     * 
     * @return a string representation of this node
     */
    public String toString() {
        String latStr = lat.toString();
        String longiStr = longi.toString();
        String altStr = alt.toString();
        return String.format("(%1$-3s, %2$-3s, %3$-3s)", latStr, longiStr, altStr);
    }

}