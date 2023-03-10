package br.edu.inteli.cc.m5.grupo.backend.resources;

import javax.lang.model.util.Elements.Origin;

import br.edu.inteli.cc.m5.grupo.backend.entities.Coordinate;

public class PathData {
    private Coordinate origin;
    private Coordinate destiny;

    public PathData(Coordinate origin, Coordinate destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    public Coordinate getOrigin() {
        return this.origin;
    }

    public Coordinate getDestiny() {
        return this.destiny;
    }

    public void setOrigin(Coordinate origin) {
        this.origin = origin;
    }

    public void setDestiny(Coordinate destiny) {
        this.destiny = destiny;
    }

}
