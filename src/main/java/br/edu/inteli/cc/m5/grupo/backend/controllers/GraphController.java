/**

Classe responsável por controlar as requisições referentes aos grafos.
*/
package br.edu.inteli.cc.m5.grupo.backend.controllers;
import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.services.Star;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.repositories.VertexRepository;
import br.edu.inteli.cc.m5.grupo.backend.services.GraphConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;

@RestController
@RequestMapping("/graph")
public class GraphController {
    /**
     * Instância do Neo4jTemplate para interagir com o banco de dados Neo4j.
     */
    @Autowired
    private Neo4jTemplate neo4jTemplate;

    /**
     * Repositório de vértices do banco de dados Neo4j.
     */
    @Autowired
    private VertexRepository vertexRepository;

    /**
     * Classe interna que define os dados necessários para construir um grafo.
     */
    public static class GraphRequestData {
        public int rows; // Quantidade de linhas da grade de coordenadas.
        public int cols; // Quantidade de colunas da grade de coordenadas.
        public double latZero; // Latitude da posição (0, 0) da grade de coordenadas.
        public double longZero; // Longitude da posição (0, 0) da grade de coordenadas.
    }

    /**
     * Endpoint responsável por receber os dados necessários para construir um grafo e retornar um caminho entre vértices.
     * 
     * @param graphRequestData Dados necessários para construir o grafo.
     * @return Caminho entre dois vértices.
     */
    @PostMapping("/")
    public String storeGraph(@RequestBody GraphRequestData graphRequestData) {
        GraphConstructor graphConstructor = new GraphConstructor(vertexRepository, neo4jTemplate);

        int rows = graphRequestData.rows;
        int cols = graphRequestData.cols;
        double latZero = graphRequestData.latZero;
        double longZero = graphRequestData.longZero;

        DtedDatabaseHandler dbRio = GraphConstructor.openDtedDB("dted/Rio");
        List<Vertex> vertexes = Arrays.asList(graphConstructor.getCoordData(dbRio, rows, cols, latZero, longZero));

        // Salva os vértices no vertexRepository
        List<Vertex> path = Star.findPath(vertexes.get(1), vertexes.get(3));
        path.add(vertexes.get(1));
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < path.size(); i++) {
            Vertex vertex = path.get(i);
            sb.append("{ id: ").append(vertex.getId())
                    .append(", lat: ").append(vertex.getLatitude())
                    .append(", longi: ").append(vertex.getLongitude()).append("}");
            if (i < path.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}