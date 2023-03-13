/**

Classe que representa um grafo em Neo4j.
Um grafo é composto por vértices.
*/
package br.edu.inteli.cc.m5.grupo.backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

/**

Representa um nó em Neo4j.
*/
@Node
public class Graph {

    /**

    Identificador único do nó.
    */
    @Id @GeneratedValue
    private Long id;
    
    /**

    Lista de vértices que compõem o grafo.
    */
    private List<Vertex> vertexes;
    /**

    Construtor da classe Graph.
    @param vertexes lista de vértices do grafo.
    */
    public Graph(List<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    /**

    Retorna o identificador único do nó.
    @return o identificador único do nó.
    */
    public Long getId() {
        return id;
    }

    /**

    Adiciona um vértice ao grafo.
    @param vertex vértice a ser adicionado.
    */
    public void addVertex(Vertex vertex) {
        this.vertexes.add(vertex);
    }

    /**

    Retorna uma representação em string do grafo.

    @return uma string representando o grafo.
    */
    public String toString() {
        String initial = "";
        for (Vertex vertex : vertexes) {
        initial += vertex.getAdj() + ", ";
    }
        return initial;
    }

}