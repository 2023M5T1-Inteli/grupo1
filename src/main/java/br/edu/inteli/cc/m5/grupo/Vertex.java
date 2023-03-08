package br.edu.inteli.cc.m5.grupo;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

  private int id;

  private double longitude;
  private double latitude;
  private double altitude;

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

  public void addEgde(Vertex end) {
    Edge edge = new Edge(this, end);

    this.adj.add(edge);
  }

  public int getId() {
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
