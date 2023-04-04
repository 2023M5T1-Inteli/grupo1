package br.edu.inteli.cc.m5.grupo.backend.entities;

public class Grid {
  private Vertex[] vertices;

  private double minLat;
  private double minLong;
  private double maxLat;
  private double maxLong;

  private int rows;
  private int cols;

  public Grid(Vertex[] vertices, double minLat, double minLong, double maxLat, double maxLong, int rows, int cols) {
    this.vertices = vertices;
    this.minLat = minLat;
    this.minLong = minLong;
    this.maxLat = maxLat;
    this.maxLong = maxLong;
    this.rows = rows;
    this.cols = cols;
  }

  public Vertex findVertex(double longitude, double latitude) {
    if (latitude > this.maxLat || latitude < this.minLat || longitude > this.maxLong || longitude < this.minLong) {
      // throw
    }

    int row = (int) Math.ceil(Math.abs(maxLat - latitude) / 0.001111);
    int col = (int) Math.ceil(Math.abs(longitude - minLong) / 0.0016);

    int index = this.cols * row + col;

    return this.vertices[index];

  }

  public Vertex[] getVertices() {
    return vertices;
  }

  public double getMinLat() {
    return minLat;
  }

  public double getMinLong() {
    return minLong;
  }

  public double getMaxLat() {
    return maxLat;
  }

  public double getMaxLong() {
    return maxLong;
  }

  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }

}
