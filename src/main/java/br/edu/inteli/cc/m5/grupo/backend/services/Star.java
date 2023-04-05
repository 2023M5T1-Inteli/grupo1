package br.edu.inteli.cc.m5.grupo.backend.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Edge;
import br.edu.inteli.cc.m5.grupo.backend.entities.Grid;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.resources.Node;

/**
 * class of the A* search algorithm, with the necessary method to find the
 * shortest path from an A point to a B point in a created graph
 */

public class Star {

    /**
     * method that implements A*
     * 
     * @param inicialVertex start vertex of the path
     * @param finalVertex   rnd vertex of the path
     * @return a list of vertices that are in the path
     */
    public static List<Vertex> findPath(Vertex inicialVertex, Vertex finalVertex) {

        PriorityQueue<Node> openList = new PriorityQueue<Node>(); // priority queue that is storing nodes that are going
                                                                  // to be explored

        List<Node> closedList = new ArrayList<Node>(); // list of already explored nodes

        Node initialNode = new Node(inicialVertex); // first node of the list: the start vertex of the path

        openList.add(initialNode);

        while (!openList.isEmpty()) { // while there are nodes to be explored, the search is not ended

            Node node = openList.peek(); // getting the top node of the queue (lowest final cost = highest priority)

            System.out.println(node.getVertex() + " // custo:" + node.getfCost());

            if (node.getVertex() == finalVertex) { // if the current node is the end vertex, the shortest path is found
                openList.remove(node);
                closedList.add(node);

                break;

            }

            for (Edge edge : node.getVertex().getAdj()) { // analizing each adjacent vertex of the current node

                if (node.getParent() == null || edge.getEnd().getId() != node.getParent().getVertex().getId()) {

                    boolean unexplored = true;

                    Node nextNode = new Node(edge.getEnd(), node, edge, finalVertex); // creating new nodes to be
                                                                                      // explored

                    for (Node explored : closedList) {
                        if (explored.getVertex().getId() == nextNode.getVertex().getId() && explored.getParent() != null
                                && explored.getParent().getVertex().getId() == node.getVertex().getId()) {
                            unexplored = false;
                        }
                    }

                    if (unexplored) { // the node will only be explored if its not in the already
                        // explored nodes list
                        openList.add(nextNode);
                    }

                }

            }

            // remove the current node from the priority queue and add it to the explored
            // nodes list
            openList.remove(node);

            closedList.add(node);

        }

        List<Vertex> pathVertices = new ArrayList<Vertex>(); // create a list to store the vertices that are in the path

        Node explored = closedList.get(closedList.size() - 1); // last element in the explored nodes list

        boolean path = true;

        while (explored.getParent() != null) { // exploring each node and its parent to find all vertices that are in
                                               // the path from end to start
            pathVertices.add(explored.getVertex()); // add the current vertex to the path list
            explored = explored.getParent(); // set the next element as the parent of the current node

        }

        Collections.reverse(pathVertices);

        int count = 0;

        for (Vertex vert : pathVertices) {
            System.out.println(count + ": " + vert.getId() + " -> ");
            count++;
        }

        return pathVertices;

    }

    public static void main(String[] args) {

        DtedDatabaseHandler dbRio = GraphConstructor.openDtedDB("dted/Rio");

        // int l = 5;

        double latZero = -22.110;
        double longZero = -43.893;

        for (int i = 1; i <= 1; i++) {

            double finalLat = -22.4274;
            double finalLong = -42.9076;

            Grid grid = new Grid(dbRio, longZero, latZero, finalLong, finalLat);

            //

            Vertex start = grid.findVertex(longZero, latZero);

            System.out.println("start vertex: " + start);

            System.out.println("last vertex: " + grid.getVertices()[grid.getVertices().length - 1]);

            Vertex end = grid.findVertex(grid.getVertices()[grid.getVertices().length - 1].getLongitude(),
                    grid.getVertices()[grid.getVertices().length - 1].getLatitude());

            System.out.println("end vertex: " + end);

            // List<Vertex> path = findPath(grid.getVertices()[0],
            // grid.getVertices()[grid.getVertices().length - 1]);

            // System.out.println("path found:");

            // for (Vertex v : path) {
            // System.out.println(v);
            // }

            // List<Integer> index = new ArrayList<Integer>();

            // for (Vertex v : path) {
            // index.add((int) v.getId());
            // }

            // for (int j = 0; i < grid.getRows(); i++) {
            // for (int k = 0; k < grid.getCols(); k++) {
            // if (index.contains(j * grid.getCols() + k)) {
            // System.out.print(" x ");
            // } else {
            // System.out.print(" - ");
            // }

            // }
            // System.out.println(" ");
            // }

        }

    }

}
