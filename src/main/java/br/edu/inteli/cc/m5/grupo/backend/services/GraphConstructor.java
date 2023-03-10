package br.edu.inteli.cc.m5.grupo.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Coordinate;
import br.edu.inteli.cc.m5.grupo.backend.entities.Graph;
import br.edu.inteli.cc.m5.grupo.backend.entities.LinkedCoordinatesList;


public class GraphConstructor {
    
    private List<LinkedCoordinatesList> rows = new ArrayList<LinkedCoordinatesList>();

    public Graph CreateGraph(Integer rows, Integer cols, Coordinate coordZero) {
    
        DtedDatabaseHandler dbRio = DatabaseHandler.openDtedDB("dted/Rio");
        
        Optional<Integer> coordZeroAlt = dbRio.QueryLatLonElevation(coordZero.getLongi(), coordZero.getLat());

        if (!coordZeroAlt.isPresent()) {
            throw new IllegalArgumentException("Invalid coordinate values.");
        }

        coordZero.setAlt(coordZeroAlt.get());

        System.out.println(coordZero.getLat() + ", " + coordZero.getLongi() + ", " + coordZero.getAlt());

        Double lat = coordZero.getLat();

        System.out.println("Entrou no gerador");

        for (int i = 0; i < rows; i++) {

            System.out.println(i);
            Double lon = coordZero.getLongi();
            LinkedCoordinatesList row = new LinkedCoordinatesList();

            for (int j = 0; j < cols; j++) {

                Optional<Integer> alt = dbRio.QueryLatLonElevation(lon, lat);
                if (alt.isEmpty()) {
                    throw new IllegalArgumentException("Coordinate does not exist.");
                } else {
                    Coordinate newCoordinate = new Coordinate(lon, lat, alt.get());
                    row.addLast(newCoordinate);
                    row.toString();
                    lon += 0.12;
                }
                
            }
            
            this.rows.add(row);
            lat -= 0.0011;

        }

        Graph graph = new Graph(this.rows);
        return graph;

    }

}
