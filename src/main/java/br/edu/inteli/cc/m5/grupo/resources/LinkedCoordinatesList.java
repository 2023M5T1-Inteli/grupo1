package br.edu.inteli.cc.m5.grupo.resources;

import br.edu.inteli.cc.m5.grupo.entities.Coordinate;

public class LinkedCoordinatesList {

    private Node head;
    private Node tail;

    public LinkedCoordinatesList() {
        this.head = null;
        this.tail = null;
    }

    private class Node {
        
        private Coordinate data;
        private Node next;
        private Node prev;

        public Node(Coordinate data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Coordinate data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    public void addLast(Coordinate data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public void displayForward() {
        Node current = head;
        while (current != null) {

            if (current.next == null) {
                System.out.print(current.data);
                current = current.next;
            } else {
                System.out.print(current.data + " <-> ");
                current = current.next;
            }
            
        }
        System.out.println();
    }

}