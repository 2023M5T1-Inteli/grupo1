package br.edu.inteli.cc.m5.grupo;

public class Edge {

  private final double alfa = 0.5;

  private Vertex start;
  private Vertex end;
  private double weight;

  public Edge(Vertex start, Vertex end) {
    this.start = start;
    this.end = end;

    double distance = Calculator.calcDist(start, end);

    double altVar = Calculator.altVar(start, end);

    this.weight = alfa * altVar + (1.0 - alfa) * distance;
  }

  public Vertex getStart() {
    return start;
  }

  public Vertex getEnd() {
    return end;
  }

  public double getWeight() {
    return weight;
  }

  public String toString() {
    return "Edge (start: " + this.start.toString() + ", end: " + this.end.toString() + ", weight: " + this.weight + ")";
  }

}
