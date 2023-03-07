package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Arrays;
import java.util.List;

import br.edu.inteli.cc.m5.grupo.resources.LinkedCoordinatesList;

/**

Graph class, consisting of doubly linked lists of coordinates
*/
@Node
public class Graph {

    // Node attributes
    @Id
    @GeneratedValue
    private Long id;
    
    private List<LinkedCoordinatesList> rows;
    
    /**
     * Constructs a Graph object with the given rows.
     * 
     * @param rows The list of connected coordinates forming the graph.
     */
    public Graph(List<LinkedCoordinatesList> rows) {
        this.rows = rows;
    }

    public int getSize() {
        return rows.size();
    }

    public List<LinkedCoordinatesList> getRows() {
        return rows;
    }
    
    /**
     * Sets the rows of the graph to the given list of connected coordinates.
     * 
     * @param rows The list of connected coordinates forming the graph.
     */
    public void setRows(List<LinkedCoordinatesList> rows) {
        this.rows = rows;
    }
    
    /**
     * Displays the graph on the screen by iterating over all coordinates.
     */
    public void displayGraph() {
        rows.forEach(item -> {
            item.toString();
            System.out.print("\n");
        });
    }
    
    /**
     * The main method that instances the graph and displays it on the screen (for debugging purposes).
     * 
     * @param args The main function's arguments.
     */
    public static void main(String[] args) {

        LinkedCoordinatesList row1 = new LinkedCoordinatesList();
        LinkedCoordinatesList row2 = new LinkedCoordinatesList();
        LinkedCoordinatesList row3 = new LinkedCoordinatesList();
    
        row1.addLast(new Coordinate(1.0, 1.0, 1.0));
        row1.addLast(new Coordinate(2.0, 2.0, 2.0));
        row1.addLast(new Coordinate(3.0, 3.0, 3.0));
    
        row2.addLast(new Coordinate(4.0, 4.0, 4.0));
        row2.addLast(new Coordinate(5.0, 5.0, 5.0));
        row2.addLast(new Coordinate(6.0, 6.0, 6.0));
    
        row3.addLast(new Coordinate(7.0, 7.0, 7.0));
        row3.addLast(new Coordinate(8.0, 8.0, 8.0));
        row3.addLast(new Coordinate(9.0, 9.0, 9.0));
    
        Graph graph = new Graph(Arrays.asList(row1, row2, row3));
    
        graph.displayGraph();
        
    }

}    