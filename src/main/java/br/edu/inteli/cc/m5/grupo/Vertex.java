package br.edu.inteli.cc.m5.grupo;

public class Vertex {

  private double longitude;
  private double latitude;
  private double altitude;

  private Edge[] adj;

  public Vertex(double longitude, double latitude, double altitude) {
    this.longitude = longitude;
    this.latitude = latitude;
    this.altitude = altitude;
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

  @Override
  public String toString() {
    return "Vertex (lat: " + latitude + ", lon: " + longitude + ", alt: " + altitude + ")";
  }

}
