package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**

The Edge class represents a relationship between two coordinates in a graph.

It has information about the origin, destiny, relative altitude and if

the relationship between the two coordinates is diagonal or not.
*/
@Node
public class Edge {

    // Node attributes
    @Id @GeneratedValue
    private Coordinate origin;
    private Coordinate destiny;
    private Double relativeAltitude;
    private Boolean isDiagonal;

    /**

    Constructs an edge with a given origin and destination coordinate.
    @param origin The origin coordinate.
    @param destiny The destination coordinate.
    */
    public Edge(Coordinate origin, Coordinate destiny) {
        this.origin = origin;
        this.destiny = destiny;
        this.relativeAltitude = destiny.getAlt() - origin.getAlt();
        this.isDiagonal = null;
    }

    /**

    Sets the origin coordinate of the edge.
    @param origin The new origin coordinate.
    */
    public void setOrigin(Coordinate origin) {
    this.origin = origin;
    }

    /**

    Returns the origin coordinate of the edge.
    @return The origin coordinate of the edge.
    */
    public Coordinate getOrigin() {
    return this.origin;
    }

    /**

    Sets the destination coordinate of the edge.
    @param destiny The new destination coordinate.
    */
    public void setDestiny(Coordinate destiny) {
    this.destiny = destiny;
    }

    /**

    Returns the destination coordinate of the edge.
    @return The destination coordinate of the edge.
    */
    public Coordinate getDestiny() {
    return this.destiny;
    }

    /**

    Returns the relative altitude between the origin and destination coordinates of the edge.
    @return The relative altitude between the origin and destination coordinates of the edge.
    */
    public Double getRelativeAltitude() {
    return this.relativeAltitude;
    }

    /**

    Returns whether the relationship between the origin and destination coordinates of the edge is diagonal or not.
    @return True if the relationship is diagonal, false otherwise.
    */
    public Boolean getIsDiagonal() {
    return this.isDiagonal;
    }

    /**

    Sets whether the relationship between the origin and destination coordinates of the edge is diagonal or not.
    @param isDiagonal True if the relationship is diagonal, false otherwise.
    */
    public void setIsDiagonal(Boolean isDiagonal) {
    this.isDiagonal = isDiagonal;
    }

    /**

    @return A string representation of the edge.
    */
    public String toString() {
    return this.origin + " - " + relativeAltitude + " > " + destiny;
    }

}