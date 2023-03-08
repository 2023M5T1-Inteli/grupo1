package br.edu.inteli.cc.m5.grupo;

public class Node {

  private Vertex current;
  private Node parent;
  private double gCost;
  private double fCost;

  public Node(Vertex current, Node parent, boolean firstStep, Edge connection, Vertex target) {
    this.current = current;
    this.parent = parent;

    this.gCost = parent.getgCost() + connection.getWeight();

    this.fCost = this.gCost + Calculator.calcDist(current, target) + Calculator.altVar(current, target);

  }

  public double getgCost() {
    return gCost;
  }

  public double getfCost() {
    return fCost;
  }

  public int compareTo(Node node) {
    if (this.getfCost() > node.getfCost()) {
      return 1;
    } else if (this.getfCost() == node.getfCost()) {
      return 0;
    } else {
      return -1;
    }
  }

}
