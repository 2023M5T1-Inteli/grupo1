package br.edu.inteli.cc.m5.grupo.backend.resources;

import br.edu.inteli.cc.m5.grupo.backend.entities.Coordinate;

/**
 * This class represents a linked list of coordinates.
 */
public class LinkedCoordinatesList {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs an empty LinkedCoordinatesList.
     */
    public LinkedCoordinatesList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class Node {
        private Coordinate coordinate;
        private Node next;
        private Node prev;

        /**
         * Constructs a Node with the specified coordinate.
         * @param coordinate the coordinate to be stored in this Node.
         */
        public Node(Coordinate coordinate) {
            this.coordinate = coordinate;
            this.next = null;
            this.prev = null;
        }
    }

    public LinkedCoordinatesList.Node getFirst() {
        return this.head;
    }

    /**
     * Adds a coordinate to the beginning of the list.
     * @param coordinate the coordinate to be added.
     * @return true if the coordinate was successfully added to the list, false otherwise.
     */
    public boolean addFirst(Coordinate coordinate) {
        Node newNode = new Node(coordinate);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        size++;
        return true;
    }

    /**
     * Adds a coordinate to the end of the list.
     * @param coordinate the coordinate to be added.
     * @return true if the coordinate was successfully added to the list, false otherwise.
     */
    public boolean addLast(Coordinate coordinate) {
        Node newNode = new Node(coordinate);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    /**
     * Returns the number of coordinates in the list.
     * @return the number of coordinates in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Removes all coordinates from the list.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns a string representation of the list.
     * @return a string representation of the list.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.coordinate);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        return sb.toString();
    }

}