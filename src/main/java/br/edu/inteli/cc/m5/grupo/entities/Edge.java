package br.edu.inteli.cc.m5.grupo.entities;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import br.edu.inteli.cc.m5.grupo.entities.Coordinate;

@Node
public class Edge {
    
    @Id @GeneratedValue
    private Coordinate origin;
    private Coordinate destiny;
    private Double relativeAltitude;

    // Constructor of origin and destiny
    public Edge(Coordinate coordinate, Coordinate adjacentCoordinate) {
        this.origin = coordinate;
        this.destiny = adjacentCoordinate;
        this.relativeAltitude = destiny.getAlt() - origin.getAlt();
    }

    // Setar a propriedade origem
    public void setOrigin(Coordinate origin) {
        this.origin = origin;
    }

    // Propriedades da coordenada de origem
    public Coordinate getOrigin() {
        return this.origin;
    }

    // Setar a propriedade destino
    public void setDestiny(Coordinate destiny) {
        this.destiny = destiny;
    }

    // Propriedades da coordenada de destino
    public Coordinate getDestiny() {
        return this.destiny;
    }

    // Pega a altitude relativa
    public Double getRelativeAltitude() {
        return this.relativeAltitude;
    }

    // Retorno de String para debug
    public String toString() {
        return this.origin + " -> " + destiny;
    }
}
