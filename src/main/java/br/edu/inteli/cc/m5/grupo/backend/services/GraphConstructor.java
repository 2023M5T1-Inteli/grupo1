package br.edu.inteli.cc.m5.grupo.backend.services;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;
import br.edu.inteli.cc.m5.grupo.backend.services.VertexService;
import br.edu.inteli.cc.m5.grupo.backend.repositories.VertexRepository;

public class GraphConstructor {

    private VertexRepository vertexRepository;
  /**
   * Essa função abre um determinado Banco de Dados DTED
   * 
   * @param path caminho do banco de dados
   * @return retorna o banco de dados inicializado
   */

   public GraphConstructor(VertexRepository vertexRepository) {
        this.vertexRepository = vertexRepository;
   }
  public static DtedDatabaseHandler openDtedDB(String path) {
    DtedDatabaseHandler dtedDB = new DtedDatabaseHandler(); // variável do tipo DtedDatabaseHandler que armazena o DB
    dtedDB.InitializeFromResources(path); // inicialização do DB através do caminho fornecido
    // if (dtedDBok) --> verifica se o DB foi inicializado corretamnete (WIP!!!)
    return dtedDB;
  }

  /**
   * Função que retorna os Vértices para montar uma malha (Grafo) com base
   * na coordenada de um ponto inicial e
   * no número de Vértices dentro da malha
   * Todos os pontos dentro dessa estrutura precisam estar dentro do DB DTED
   * 
   * @param dbDTED   banco de dados DTED inicializado
   * @param longZero longitude do ponto inicial
   * @param latZero  latitude do ponto inicial
   * @param row      número de linhas da malha de nós
   * @param col      número de colunas da malha de nós
   * @return array de Vértices que compõem o Grafo
   */
  public Vertex[] getCoordData(DtedDatabaseHandler dbDTED, Integer row, Integer col, Double latZero, Double longZero) {

    Vertex[] vertices = new Vertex[row * col]; // array that contains all Nodes information of the mesh

    int count = 0; // auxiliary variable that stores the number of nodes created
    double lon;
    double lat = latZero;
    for (int i = 0; i < row; i++) { // loop that gets the data line by line
        lon = longZero;
        for (int j = 0; j < col; j++) { // loop that gets the data of all the nodes of a certain line of the mesh
            double alt = (double) dbDTED.QueryLatLonElevation(lon, lat).get(); // altitude of a coordinate

            Vertex newVert = new Vertex(count, lon, lat, alt); // creation of a new Vertex
            
            vertices[count] = newVert; // stores the created vertex in the array

            lon += 0.0016; // constant (in degrees) that travels 120m in the West-East direction on the same
            // latitude (close to 43°S) based on the Harversine Formula (WIP!!!)
            count++;
        }
        lat -= 0.00018; // constant (in degrees) that travels 120m in the North-South direction on the same
        // longitude based on the Harversine Formula (WIP!!!)
    }

    addEdges(vertices, row, col); // add edges between vertices based on their positions and distances

    return vertices;
}

/**
 * This method adds edges between vertices based on their positions and distances
 * 
 * @param vertices array of vertices that need to be connected
 * @param row      number of rows of the mesh
 * @param col      number of columns of the mesh
 */
private static void addEdges(Vertex[] vertices, int row, int col) {
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            int index = i * col + j;
            Vertex vertex = vertices[index];

            // indices of the vertices that need to be connected to the current vertex
            int[] toConnect = {index - col - 1, index - col, index - col + 1, index - 1, index + 1, index + col - 1,
                    index + col, index + col + 1};

            for (int adj : toConnect) {
                if (adj >= 0 && adj < vertices.length && Calculator.calcDist(vertex, vertices[adj]) < 20000.0) {
                    // add an edge between the current vertex and its neighbor
                    VertexService.addEdge(vertex, vertices[adj]);
                }
            }
        }
    }
}
}