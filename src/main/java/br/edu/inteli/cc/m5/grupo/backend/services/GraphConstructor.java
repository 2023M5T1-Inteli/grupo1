package br.edu.inteli.cc.m5.grupo.backend.services;

import java.util.Collections;

import org.springframework.data.neo4j.core.Neo4jTemplate;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.repositories.VertexRepository;

/**
 * class that contains all necessary methods to create an entire mesh graph,
 * getting vertices data from a Dted DB
 */

public class GraphConstructor {

    private Neo4jTemplate neo4jTemplate;
    private VertexRepository vertexRepository;

    public GraphConstructor(VertexRepository vertexRepository, Neo4jTemplate neo4jTemplate) {
        this.vertexRepository = vertexRepository;
        this.neo4jTemplate = neo4jTemplate;
    }

    /**
     * function that opens a Dted DB
     * 
     * @param path path where the DB is stored
     * @return the inicialized Dted DB
     */

    public static DtedDatabaseHandler openDtedDB(String path) {
        DtedDatabaseHandler dtedDB = new DtedDatabaseHandler(); // DtedDatabaseHandler variable that stores the DB
        dtedDB.InitializeFromResources(path); // inicializing the DB through its path
        return dtedDB;
    }

    /**
     * function that gets the necessary data to create a mesh graph and creates all
     * vertices
     * 
     * @param dbDTED   inicialized Dted DB
     * @param longZero initial vertex longitude
     * @param latZero  initicial vertex latitude
     * @param row      number of rows in each column
     * @param col      number of columns in each row
     * @return array of vertex which contains all vertices of the graph thats beeing
     *         created
     */
    public Vertex[] getCoordData(DtedDatabaseHandler dbDTED, Integer row, Integer col, Double latZero,
            Double longZero) {

        Vertex[] vertices = new Vertex[row * col]; // array that contains all vertex information of the mesh

        int count = 0; // auxiliary variable that stores the number of vertices created
        double lon;
        double lat = latZero;
        for (int i = 0; i < row; i++) { // loop that gets the data row by row
            lon = longZero;
            for (int j = 0; j < col; j++) { // loop that creates all vertices in a row
                double alt = (double) dbDTED.QueryLatLonElevation(lon, lat).get();

                Vertex newVert = new Vertex(count, lon, lat, alt);
                newVert = vertexRepository.save(newVert); // storing the created vertex in Neo4j updating ID
                vertices[(int) newVert.getId()] = newVert;

                lon += 0.0016;
                count++;
            }
        }

        addEdges(vertices, row, col); // add edges between vertices based on their positions and distances
        return vertices;
    }

    /**
     * This method adds edges between vertices based on their positions and
     * distances
     * 
     * @param vertices array of vertices that need to be connected
     * @param row      number of rows of the mesh
     * @param col      number of columns of the mesh
     */
    private void addEdges(Vertex[] vertices, int row, int col) {
        for (Vertex v : vertices) {
            System.out.print(v + ", ");
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = i * col + j;
                Vertex vertex = vertices[index];

                // indices of the vertices that need to be connected to the current vertex
                int[] toConnect = { index - col - 1, index - col, index - col + 1, index - 1, index + 1,
                        index + col - 1,
                        index + col, index + col + 1 };

                for (int adj : toConnect) {
                    if (adj >= 0 && adj < vertices.length && Calculator.calcDist(vertex, vertices[adj]) < 20000.0) {
                        // add an edge between the current vertex and its neighbor
                        VertexService.addEdge(vertex, vertices[adj]);
                        neo4jTemplate.save(vertex);
                    }
                }
            }
        }
    }
}