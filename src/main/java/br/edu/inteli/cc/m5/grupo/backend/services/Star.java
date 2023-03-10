package br.edu.inteli.cc.m5.grupo.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import br.edu.inteli.cc.m5.grupo.backend.entities.Edge;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.resources.Node;

public class Star {

    public static List<Vertex> findPath(Vertex inicialVertex, Vertex finalVertex) {

        PriorityQueue<Node> openList = new PriorityQueue<Node>();

        List<Node> closedList = new ArrayList<Node>();

        Node initialNode = new Node(inicialVertex);

        openList.add(initialNode);

        while (!openList.isEmpty()) {

            Node node = openList.peek();

            if (node.getVertex() == finalVertex) {
                openList.remove(node);
                closedList.add(node);

                break;

            }

            for (Edge edge : node.getVertex().getAdj()) {
                Node nextNode = new Node(edge.getEnd(), node, edge, finalVertex);

                if (!closedList.contains(nextNode)) {
                    openList.add(nextNode);
                }

            }

            openList.remove(node);

            closedList.add(node);

        }

        List<Vertex> pathVertices = new ArrayList<Vertex>();

        Node explored = closedList.get(closedList.size() - 1);

        while (explored.getParent() != null) {
            pathVertices.add(explored.getVertex());
            explored = explored.getParent();
        }

        return pathVertices;

    }

}