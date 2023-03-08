package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import java.util.ArrayList;
import java.util.List;

@Node
public class Coordinate {
    
    // Node attributes
    @Id @GeneratedValue
    private Long id;
    private Double lat;
    private Double longi;
    private Double alt;
    
    @Relationship(type = "ADJACENT", direction = Relationship.Direction.OUTGOING)
    private List<Coordinate> adjacents = new ArrayList<>();

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

    public Coordinate() {}

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

    public void addAdjacents(Coordinate adjacentCoordinate) {
        adjacents.add(adjacentCoordinate);
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

    public void addAdjacent(Coordinate adjacent) {
        if (adjacents.isEmpty()) {
            adjacents.add(adjacent);
        } 
        // } else {
        //     throw new IllegalStateException("A relação de adjacência já existe entre as coordenadas.");
        // }
    }
    
    public void removeAdjacent(Coordinate adjacent) {
        if (!adjacents.remove(adjacent)) {
            throw new IllegalArgumentException("A coordenada especificada não é adjacente a esta coordenada.");
        }
    }
    
    public void removeAllAdjacents() {
        adjacents.clear();
    }
    
    public boolean hasAdjacent(Coordinate adjacent) {
        return adjacents.contains(adjacent);
    }
    
    public boolean hasAdjacents() {
        return !adjacents.isEmpty();
    }
     
    public int countAdjacents() {
        return adjacents.size();
    }    

    @RelationshipProperties
        public class Adjacent {
            private Long id;

            @Property
            private Double weight;

            private Double getWeight() {
                return weight;
            }

            private void setWeight(Double weight) {
                this.weight = weight;
            }

            public Adjacent(Double relativeAltitude, Double distance) {
                final double ALTITUDE_COEFFICIENT = 2.0;
                final double NEGATIVE_ALTITUDE_FACTOR = 0.5;
                
                double weight = distance + ALTITUDE_COEFFICIENT * Math.max(0, relativeAltitude);
                if (relativeAltitude < 0) {
                    weight += ALTITUDE_COEFFICIENT * Math.abs(relativeAltitude) * NEGATIVE_ALTITUDE_FACTOR;
                }
                this.setWeight(weight);
            }            

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