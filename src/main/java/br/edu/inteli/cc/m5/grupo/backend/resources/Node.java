package br.edu.inteli.cc.m5.grupo.backend.resources;

import br.edu.inteli.cc.m5.grupo.backend.entities.Edge;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.services.Calculator;

/**
 * class that is used in A* to find vertices that are in the shortest way from a
 * vertex A to an B in a determined graph
 */

public class Node implements Comparable<Node> {

  private Vertex current; // vertex of the node
  private Node parent; // node that came previously from the current in the algorithm analysis
  private double gCost; // cost to get in the current node from the start node
  private double fCost; // final cost of the node

  /**
   * constructor
   * 
   * @param current    vertex
   * @param parent     parent node
   * @param connection edge between parent and current
   * @param target     final vertex of the path
   */
  public Node(Vertex current, Node parent, Edge connection, Vertex target) {
    this.current = current;
    this.parent = parent;

    // how g cost is calculated: the node gets its parent g cost and add the weight
    // of the edge that connects them
    this.gCost = this.parent.getgCost() + connection.getWeight();

    // final cost = g cost + heuristic
    // how heuristic is calculated: distance + the altitude variation between the
    // current vertex and the final vertex
    // the algortithm uses this heuristic to "predict" which adjacent vertex will
    // have the lowest cost impact on the final páth
    this.fCost = this.gCost + Calculator.calcDist(current, target) + Calculator.altVar(current, target);
  }

  /**
   * constructor used only by the start node in a path
   * 
   * @param current vertex
   */
  public Node(Vertex current) {
    this.current = current;
    this.parent = null;
    this.gCost = 0;
  }

  // getters

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

  // implementing comparable (by f cost)

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
