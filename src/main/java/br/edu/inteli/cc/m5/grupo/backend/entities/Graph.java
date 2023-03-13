/**

Class that represents a Neo4j graph.
A graph is composed of vertices.
*/
package br.edu.inteli.cc.m5.grupo.backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

/**

Represents a node in Neo4j.
*/
@Node
public class Graph {
    
    /**

    Unique identifier of the node.
    */
    @Id @GeneratedValue
    private Long id;

    /**

    List of vertices that compose the graph.
    */
    private List<Vertex> vertexes;
    /**

    Constructor for the Graph class.
    @param vertexes list of vertices in the graph.
    */
    public Graph(List<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    /**

    Returns the unique identifier of the node.
    @return the unique identifier of the node.
    */
    public Long getId() {
        return id;
    }

    /**

    Adds a vertex to the graph.
    @param vertex vertex to be added.
    */
    public void addVertex(Vertex vertex) {
        this.vertexes.add(vertex);
    }

    /**

    Returns a string representation of the graph.

    @return a string representing the graph.
    */
    public String toString() {
        String initial = "";
        for (Vertex vertex : vertexes) {
        initial += vertex.getAdj() + ", ";
    }
        return initial;
    }

}