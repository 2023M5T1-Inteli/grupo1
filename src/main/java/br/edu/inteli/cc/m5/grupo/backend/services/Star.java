package br.edu.inteli.cc.m5.grupo.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import br.edu.inteli.cc.m5.grupo.backend.entities.Edge;
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

        // long time0, time1, time2, time3;

        // time3 = System.nanoTime();

        // System.out.println("A Star started\n\n");

        PriorityQueue<Node> openList = new PriorityQueue<Node>(); // priority queue that is storing nodes that are going
                                                                  // to be explored

        List<Node> closedList = new ArrayList<Node>(); // list of already explored nodes

        Node initialNode = new Node(inicialVertex); // first node of the list: the start vertex of the path

        openList.add(initialNode);

        // int count = 0;

        // time0 = System.nanoTime();

        while (!openList.isEmpty()) { // while there are nodes to be explored, the search is not ended

            // System.out.println("Iteration " + count);

            // time1 = System.nanoTime();

            Node node = openList.peek(); // getting the top node of the queue (lowest final cost = highest priority)

            // time2 = System.nanoTime();

            // System.out.println("open list peeking // " + (time2 - time1) / 1000000 + "
            // ms");

            // System.out.println("analyzing vertex " + node.getVertex().getId());

            // time1 = System.nanoTime();

            if (node.getVertex() == finalVertex) { // if the current node is the end vertex, the shortest path is found
                openList.remove(node);
                closedList.add(node);

                // time2 = System.nanoTime();

                // System.out.println("checking and finding final vertex // " + (time2 - time1)
                // / 1000000 + " ms");

                break;

            }

            // time2 = System.nanoTime();

            // System.out.println("checking vertex // " + (time2 - time1) / 1000000 + "
            // ms");

            // time1 = System.nanoTime();

            for (Edge edge : node.getVertex().getAdj()) { // analizing each adjacent vertex of the current node

                boolean test = true;

                Node nextNode = new Node(edge.getEnd(), node, edge, finalVertex); // creating new nodes to be explored

                for (Node node2 : closedList) {
                    if (node2.getVertex().getId() == nextNode.getVertex().getId() && node2.getParent() != null
                            && node2.getParent().getVertex().getId() == node.getVertex().getId()) {
                        test = false;
                    }
                }

                if (test) { // the node will only be explored if its not in the already
                    // explored nodes list
                    openList.add(nextNode);
                }

            }

            // time2 = System.nanoTime();

            // System.out.println("added all adj nodes // " + (time2 - time1) / 1000000 + "
            // ms");

            // time1 = System.nanoTime();

            // remove the current node from the priority queue and add it to the explored
            // nodes list
            openList.remove(node);

            closedList.add(node);

            // time2 = System.nanoTime();

            // System.out.println("exchanged node between lists // " + (time2 - time1) /
            // 1000000 + " ms\n\n");

        }

        // time2 = System.nanoTime();

        // System.out.println("exploration finished // " + (time2 - time0) / 1000000 + "
        // ms");

        // time1 = System.nanoTime();

        List<Vertex> pathVertices = new ArrayList<Vertex>(); // create a list to store the vertices that are in the path

        Node explored = closedList.get(closedList.size() - 1); // last element in the explored nodes list

        while (explored.getParent() != null) { // exploring each node and its parent to find all vertices that are in
                                               // the path from end to start
            pathVertices.add(explored.getVertex()); // add the current vertex to the path list
            explored = explored.getParent(); // set the next element as the parent of the current node
        }

        // time2 = System.nanoTime();

        // System.out.println("final path processed // " + (time2 - time1) / 1000000 + "
        // ms\n\n");

        // System.out.println("total algorithm time // " + (time2 - time3) / 1000000 + "
        // ms\n\n\n");

        int count = 0;

        for (Vertex vert : pathVertices) {
            System.out.println(count + ": " + vert.getId() + " -> ");
            count++;
        }

        return pathVertices;

    }

}