/**

This class represents an edge in a graph, connecting two vertices.
An Edge is defined by a start and end Vertex, and has a weight determined by the distance between the vertices and their altitude variation.
*/
package br.edu.inteli.cc.m5.grupo.backend.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.*;

import br.edu.inteli.cc.m5.grupo.backend.services.Calculator;

/**

This class represents an edge in a graph, connecting two vertices.
An Edge is defined by a start and end Vertex, and has a weight determined by the distance between the vertices and their altitude variation.
*/
@RelationshipProperties
public class Edge {
    
    /** The unique identifier of the Edge. */
    @Id @GeneratedValue
    private Long id;

    /** The constant alfa used to calculate the weight of the Edge. */
    private final double alfa = 0.5;

    /** The start Vertex of the Edge. */
    private Vertex start;

    /** The end Vertex of the Edge. */
    @TargetNode
    private Vertex end;

    /** The weight of the Edge. */
    private double weight;

    /**

    Creates a new Edge with the given start and end Vertices.
    The weight of the Edge is determined by the distance between the vertices and their altitude variation.
    @param start The start Vertex of the Edge.
    @param end The end Vertex of the Edge.
    */
    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        double distance = Calculator.calcDist(start, end);
        double altVar = Calculator.altVar(start, end);

        this.weight = alfa * altVar + (1.0 - alfa) * distance;
    }

    /**

    Creates an empty Edge.
    */
    public Edge() {}
    /**

    Returns the start Vertex of the Edge.
    @    return The start Vertex of the Edge.
    */
    public Vertex getStart() {
        return start;
    }
    /**

    Returns the end Vertex of the Edge.
    @    return The end Vertex of the Edge.
    */
    public Vertex getEnd() {
        return end;
    }
    /**

    Returns the weight of the Edge.
    @    return The weight of the Edge.
    */
    public double getWeight() {
        return weight;
    }
    /**

    Returns a string representation of the Edge.
    @    return A string representation of the Edge.
    */
    public String toString() {
        return "Edge (start: " + this.start.toString() + ", end: " + this.end.toString() + ", weight: " + this.weight + ")";
    }

}