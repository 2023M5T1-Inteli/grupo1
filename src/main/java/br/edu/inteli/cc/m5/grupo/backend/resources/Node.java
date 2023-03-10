package br.edu.inteli.cc.m5.grupo.backend.resources;

import br.edu.inteli.cc.m5.grupo.backend.entities.Edge;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.services.Calculator;

public class Node implements Comparable<Node> {

  private Vertex current;
  private Node parent;
  private double gCost;
  private double fCost;

  public Node(Vertex current, Node parent, Edge connection, Vertex target) {
    this.current = current;
    this.parent = parent;

    this.gCost = this.parent.getgCost() + connection.getWeight();

    this.fCost = this.gCost + Calculator.calcDist(current, target) + Calculator.altVar(current, target);
  }

  public Node(Vertex current) {
    this.current = current;
    this.parent = null;
    this.gCost = 0;
  }

  public Node getParent() {
    return this.parent;
  }

  public double getgCost() {
    return gCost;
  }

  public double getfCost() {
    return fCost;
  }

  public Vertex getVertex() {
    return this.current;
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
