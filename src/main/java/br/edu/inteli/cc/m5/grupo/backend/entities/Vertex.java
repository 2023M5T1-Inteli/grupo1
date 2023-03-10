package br.edu.inteli.cc.m5.grupo.backend.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import java.util.ArrayList;
import java.util.List;

import br.edu.inteli.cc.m5.grupo.backend.repositories.EdgeRepository;

@Node
public class Vertex {

  @Id @GeneratedValue
  private long id;

  private double longitude;
  private double latitude;
  private double altitude;

  @Autowired
  private Neo4jTemplate neo4jTemplate;

  @Relationship
  private List<Edge> adj;

  public Vertex(double longitude, double latitude, double altitude) {
    this.longitude = longitude;
    this.latitude = latitude;
    this.altitude = altitude;
  }

  public Vertex(int id, double longitude, double latitude, double altitude) {
    this.id = id;
    this.longitude = longitude;
    this.latitude = latitude;
    this.altitude = altitude;
    this.adj = new ArrayList<Edge>();
  }
  
  public void addEdge(Vertex end) {
      Edge edge = new Edge(this, end);

      this.adj.add(edge);
  
      edgeRepository.save(edge);
  }
  
  

  public long getId() {
    return id;
  }

  public double getLongitude() {
    return longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getAltitude() {
    return altitude;
  }

  public List<Edge> getAdj() {
    return adj;
  }

  @Override
  public String toString() {
    return "Vertex (id: " + this.id + ", lat: " + this.latitude + ", lon: " + this.longitude + ", alt: " + this.altitude
        + ")";
  }

}
