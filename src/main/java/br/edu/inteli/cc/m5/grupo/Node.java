package br.edu.inteli.cc.m5.grupo;

public class Node {

  private Vertex current;
  private Node ancestor;
  private double gCost;

  public Node(Vertex current, Node ancestor, boolean firstStep) {
    this.current = current;
    this.ancestor = ancestor;

    // this.gCost = ancestor.gCost +
  }

  public double getgCost() {
    return gCost;
  }

}
