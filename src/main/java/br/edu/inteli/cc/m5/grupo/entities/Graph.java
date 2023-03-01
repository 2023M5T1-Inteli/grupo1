package br.edu.inteli.cc.m5.grupo.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Arrays;
import java.util.List;

import br.edu.inteli.cc.m5.grupo.resources.LinkedCoordinatesList;

@Node
public class Graph {

    // Atributos para a entidade Nó
    @Id @GeneratedValue
    private Long id;
    private List<LinkedCoordinatesList> rows;

    public Graph(List<LinkedCoordinatesList> rows) {
        this.rows = rows;
    }

    public void setRows(List<LinkedCoordinatesList> rows) {
        this.rows = rows;
    }

    public void displayGraph() {
        rows.forEach(item -> {
            item.displayForward();
            System.out.print("\n");
        });
    }

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

        Graph grafo = new Graph(Arrays.asList(row1, row2, row3));

        grafo.displayGraph();

    }

}