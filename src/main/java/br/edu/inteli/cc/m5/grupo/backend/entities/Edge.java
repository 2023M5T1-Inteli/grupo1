// package br.edu.inteli.cc.m5.grupo.backend.entities;

// import org.springframework.data.neo4j.core.schema.GeneratedValue;
// import org.springframework.data.neo4j.core.schema.Id;
// import org.springframework.data.neo4j.core.schema.Node;

// /**

// The Edge class represents a relationship between two coordinates in a graph.

// It has information about the origins, destiny, relative altitude and if

// the relationship between the two coordinates is diagonal or not.
// */
// @Node
// public class Edge {

//     // Node attributes
//     @Id @GeneratedValue
//     private Coordinate origins;
//     private Coordinate destiny;
//     private Double relativeAltitude;
//     private Boolean isDiagonal;

//     /**

//     Constructs an edge with a given origins and destination coordinate.
//     @param origins The origins coordinate.
//     @param destiny The destination coordinate.
//     */
//     public Edge(Coordinate origins, Coordinate destiny) {
//         this.origins = origins;
//         this.destiny = destiny;
//         this.relativeAltitude = destiny.getAlt() - origins.getAlt();
//         this.isDiagonal = null;
//     }

//     /**

//     Sets the origins coordinate of the edge.
//     @param origins The new origins coordinate.
//     */
//     public void setOrigins(Coordinate origins) {
//     this.origins = origins;
//     }

//     /**

//     Returns the origins coordinate of the edge.
//     @return The origins coordinate of the edge.
//     */
//     public Coordinate getOrigins() {
//     return this.origins;
//     }

//     /**

//     Sets the destination coordinate of the edge.
//     @param destiny The new destination coordinate.
//     */
//     public void setDestiny(Coordinate destiny) {
//     this.destiny = destiny;
//     }

//     /**

//     Returns the destination coordinate of the edge.
//     @return The destination coordinate of the edge.
//     */
//     public Coordinate getDestiny() {
//     return this.destiny;
//     }

//     /**

//     Returns the relative altitude between the origins and destination coordinates of the edge.
//     @return The relative altitude between the origins and destination coordinates of the edge.
//     */
//     public Double getRelativeAltitude() {
//     return this.relativeAltitude;
//     }

//     /**

//     Returns whether the relationship between the origins and destination coordinates of the edge is diagonal or not.
//     @return True if the relationship is diagonal, false otherwise.
//     */
//     public Boolean getIsDiagonal() {
//     return this.isDiagonal;
//     }

//     /**

//     Sets whether the relationship between the origins and destination coordinates of the edge is diagonal or not.
//     @param isDiagonal True if the relationship is diagonal, false otherwise.
//     */
//     public void setIsDiagonal(Boolean isDiagonal) {
//     this.isDiagonal = isDiagonal;
//     }

//     /**

//     @return A string representation of the edge.
//     */
//     public String toString() {
//     return this.origins + " - " + relativeAltitude + " > " + destiny;
//     }

// }