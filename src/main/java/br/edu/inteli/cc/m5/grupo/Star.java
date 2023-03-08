package br.edu.inteli.cc.m5.grupo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Star {

    public static void findPath(Vertex inicialVertex, Vertex finalVertex) {

        PriorityQueue<Node> openList = new PriorityQueue<Node>();

        Set<Node> closedList = new HashSet<Node>();

        Node initialNode = new Node(inicialVertex);

        openList.add(initialNode);

        for (Node node : openList) {

            System.out.println(node.getVertex().toString());

            if (node.getVertex() == finalVertex) {
                openList.remove(node);
                closedList.add(node);

            }

            for (Edge edge : node.getVertex().getEdges()) {
                Node nextNode = new Node(edge.getEnd(), node, edge, finalVertex);

                if (!closedList.contains(nextNode)) {
                    openList.add(nextNode);
                }

            }

            openList.remove(node);

            closedList.add(node);

        }

        System.out.println("Open List:");

        for (Node node : openList) {
            System.out.println(node.getVertex().toString());
        }

        System.out.println("Closed List:");

        for (Node node : closedList) {
            System.out.println(node.getVertex().toString());
        }

    }

}