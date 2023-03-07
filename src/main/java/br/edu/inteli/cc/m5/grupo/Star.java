package br.edu.inteli.cc.m5.grupo;

public class Star {

    private final double alfa = 0.5;
    private Vertex inicialVertex;
    private Vertex finalVertex;

    public double heuristic(Vertex currentVertex) {

        double distToFinal = Calculator.calcDist(currentVertex, finalVertex);
        double altVarToFinal = Calculator.altVar(currentVertex, finalVertex);

        double heuristic = alfa * altVarToFinal + (1.0 - alfa) * distToFinal;

        return heuristic;

    }

    public double setInicialCost() {

    }

    public void findPath() {

    }

}