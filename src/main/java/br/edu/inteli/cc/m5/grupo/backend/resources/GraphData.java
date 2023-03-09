package br.edu.inteli.cc.m5.grupo.backend.resources;

import br.edu.inteli.cc.m5.grupo.backend.entities.Coordinate;

public class GraphData {
    
    private int rows;
    private int cols;
    private Coordinate coordZero;

    public GraphData() {}

    public GraphData(int rows, int cols, Coordinate coordZero) {
        this.rows = rows;
        this.cols = cols;
        this.coordZero = coordZero;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Coordinate getcoordZero() {
        return coordZero;
    }

    public void setcoordZero(Coordinate coordZero) {
        this.coordZero = coordZero;
    }
    
}