package br.edu.inteli.cc.m5.grupo.backend.entities;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.services.GraphConstructor;

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

  public Grid(DtedDatabaseHandler dbDTED, double longZero, double latZero, double finalLong, double finalLat) {
    double maxLat, maxLong, minLat, minLong;

    if (latZero > finalLat) {
      maxLat = latZero;
      minLat = finalLat;
    } else {
      maxLat = finalLat;
      minLat = latZero;
    }

    this.maxLat = maxLat;
    this.minLat = minLat;

    if (longZero > finalLong) {
      maxLong = longZero;
      minLong = finalLong;
    } else {
      maxLong = finalLong;
      minLong = longZero;
    }

    this.maxLong = maxLong;
    this.minLong = minLong;

    System.out.println("max lat: " + maxLat);

    System.out.println("min lat: " + minLat);

    System.out.println("max long: " + maxLong);

    System.out.println("min long: " + minLong);

    int row = (int) Math.ceil((Math.abs((Math.abs(maxLat) - Math.abs(minLat)))) / 0.001111) + 1;
    System.out.println("grid rows: " + row);

    this.rows = row;

    int col = (int) Math.ceil(Math.abs((Math.abs(maxLong) - Math.abs(minLong))) / 0.0016) + 1;
    System.out.println("grid cols: " + col);

    this.cols = col;

    Vertex[] vertices = new Vertex[row * col]; // array that contains all vertex information of the mesh

    int count = 0; // auxiliary variable that stores the number of vertices created
    double lon;
    double lat = maxLat;
    for (int i = 0; i < row; i++) { // loop that gets the data row by row
      lon = minLong;
      for (int j = 0; j < col; j++) { // loop that creates all vertices in a row
        //System.out.println(lat + ", " + lon);
        double alt = (double) dbDTED.QueryLatLonElevation(lon, lat).get();

        Vertex newVert = new Vertex(count, lon, lat, alt);
        vertices[(int) newVert.getId()] = newVert;

        // System.out.println("Vertex " + count + " created: " + vertices[count]);

        lon += 0.0016;
        count++;
      }

      lat -= 0.001111;
    }
    
    GraphConstructor.addEdges(vertices, row, col); // add edges between vertices based on their positions and distances
    
    this.vertices = vertices;
    System.out.println(vertices.length);
  }

  public Vertex findVertex(double longitude, double latitude) {
    if (latitude > this.maxLat || latitude < this.minLat || longitude > this.maxLong || longitude < this.minLong) {
      // throw
    }

    System.out.println("latitude: " + latitude);
    System.out.println("max lat: " + maxLat);

    System.out.println("longitude: " + longitude);
    System.out.println("min long: " + maxLong);

    int row = (int) Math.floor(Math.abs(Math.abs(maxLat) - Math.abs(latitude)) / 0.001111);
    System.out.println("vertex row: " + row);
    int col = (int) Math.floor(Math.abs(Math.abs(longitude) - Math.abs(minLong)) / 0.0016);
    System.out.println("vertex col: " + col);

    int index = this.cols * row + col;
    System.out.println("vertex index: " + index);

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
