package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

/**

The Path class represents a group of Coordinates.

It holds information about it's weight, distance and which

Coordinates it owns
*/
@Node
public class Path {

    // Node attributes
    @Id @GeneratedValue
    private Integer id;
    private Integer weight;
    private Integer distance; 
    private List<Coordinate> nodes;

    /**
     * Path class constructor, sets a new Path object with given Coordinates, weight and distance.
     *
     * @param nodes List of coordinates that make up the path.
     * @param weight Path's weight.
     * @param distance Path's total distance.
     */
    public Path(List<Coordinate> nodes, Integer weight, Integer distance) {
        this.nodes = nodes;
        this.weight = weight;
        this.distance = distance;
    }

    /**
     * Returns the ID of this node.
     *
     * @return the ID of this node.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets this Path's weight.
     *
     * @param weight the Path's weight.
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * Gets this Path's weight.
     *
     * @return this Path's weight.
     */
    public Integer getWeight() {
        return weight;
    }        

    /**
     * Sets the Path's total distance.
     *
     * @param distance the Path's total distance.
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * Get's the Path's total distance.
     *
     * @return the Path's total distance.
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Sets the list of coordinates that make up the path.
     *
     * @param nodes The new list of coordinates that make up the path.
     */
    public void setNodes(List<Coordinate> nodes) {
        this.nodes = nodes;
    }

    /**
     * Gets the list of coordinates that make up the path.
     *
     * @return The list of coordinates that make up the path.
     */
    public List<Coordinate> getNodes() {
        return this.nodes;
    }

    /**
     * Gets a string representation of path.
     *
     * @return A string representation of path.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Path [");
        for (Coordinate coord : nodes) {
            sb.append(coord.toString());
            sb.append(", ");
        }
        sb.append("weight=").append(weight);
        sb.append(", distance=").append(distance);
        sb.append("]");
        return sb.toString();
    }

}