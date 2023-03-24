package br.edu.inteli.cc.m5.grupo.backend.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**

This class represents a vertex node in a graph.
A vertex has an id, longitude, latitude, altitude and a list of adjacent edges.
The class is annotated with Spring Data Neo4j annotations.
*/
@Node
public class Vertex {

    /**

    The id of the vertex.
    */
    @Id
    private long id;

    /**

    The longitude of the vertex.
    */
    private double longitude;

    /**

    The latitude of the vertex.
    */
    private double latitude;

    /**

    The altitude of the vertex.
    */
    private double altitude;

    /**

    The list of adjacent edges to the vertex.
    The annotation @Relationship indicates a relationship between the vertex and the Edge entity.
    The attribute type specifies the relationship type, while direction specifies the direction of the relationship.
    */
    @JsonIgnore
    @Relationship(type = "ADJ", direction = Relationship.Direction.OUTGOING)
    private List<Edge> adj = new ArrayList<>();

    /**

    Constructs a new vertex with the given id, longitude, latitude and altitude.
    @param id the id of the vertex.
    @param longitude the longitude of the vertex.
    @param latitude the latitude of the vertex.
    @param altitude the altitude of the vertex.
    */
    public Vertex(long id, double longitude, double latitude, double altitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    /**

    Constructs a new vertex with the given longitude, latitude and altitude.
    @param longitude the longitude of the vertex.
    @param latitude the latitude of the vertex.
    @param altitude the altitude of the vertex.
    */
    public Vertex(double longitude, double latitude, double altitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    /**

    Constructs a new vertex with the given longitude, latitude, altitude and adjacent edges.
    @param longitude the longitude of the vertex.
    @param latitude the latitude of the vertex.
    @param altitude the altitude of the vertex.
    @param adjs the list of adjacent edges to the vertex.
    */
    public Vertex(double longitude, double latitude, double altitude, List<Edge> adjs) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.adj = adjs;
    }

    /**

    Adds a new edge to the list of adjacent edges to the vertex.

    @param end the vertex at the end of the edge.
    */
    public void addEdge(Vertex end) {
    Edge edge = new Edge(this, end);
        this.adj.add(edge);
    }

    /**

    Returns the id of the vertex.
    @return the id of the vertex.
    */
    public long getId() {
        return id;
    }

    /**

    Returns the longitude of the vertex.
    @return the longitude of the vertex.
    */
    public double getLongitude() {
        return longitude;
    }

    /**

    Returns the latitude of the vertex.
    @return the latitude of the vertex.
    */
    public double getLatitude() {
        return latitude;
    }

    /**

    Returns the altitude of the vertex.
    @return the altitude of the vertex.
    */
    public double getAltitude() {
        return altitude;
    }

    /**

    Returns the list of adjacent edges to the vertex.
    @return the list of adjacent edges to the vertex.
    */
    public List<Edge> getAdj() {
        return adj;
    }

    @Override
    public String toString() {
    return "Vertex (id: " + this.id + ", lat: " + this.latitude + ", lon: " + this.longitude + ", alt: " + this.altitude
        + ")";

    }

}
