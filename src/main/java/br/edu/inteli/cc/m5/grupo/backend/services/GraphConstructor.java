package br.edu.inteli.cc.m5.grupo.backend.services;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;

public class GraphConstructor {
  /**
   * Essa função abre um determinado Banco de Dados DTED
   * 
   * @param path caminho do banco de dados
   * @return retorna o banco de dados inicializado
   */
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
  public static Vertex[] getCoordData(DtedDatabaseHandler dbDTED, Integer row, Integer col, Double latZero, Double longZero) {

    Vertex[] vertices = new Vertex[row * col]; // array que contém as informações de todos os Nós da malha

    int count = 0; // variável auxiliar que armazena a quantidade de nós criados
    double lon;
    double lat = latZero;
    for (int i = 0; i < row; i++) { // loop que obtém os dados linha por linha
      lon = longZero;
      for (int j = 0; j < col; j++) { // loop que obtém os dados de todos os nós de uma determinada linha da malha
        double alt = (double) dbDTED.QueryLatLonElevation(lon, lat).get(); // altitude de uma coordenada

        Vertex newVert = new Vertex(count, lon, lat, alt); // criação de um novo Vértice

        vertices[count] = newVert; // armazena o vértice criado no array

        lon += 0.0016; // constante (em graus) que viaja 120m no sentido Oeste - Leste em uma mesma
        // latitude (próxima de 43°S) com base na Fórmula de Harversine (WIP!!!)
        count++;
      }
      lat -= 0.00018; // constante (em graus) que viaja 120m no sentido Norte - Sul em uma mesma
                      // logitude com base na Fórmula de Harversine (WIP!!!)
    }

    for (Vertex vertex : vertices) {
      int id = (int) vertex.getId();
      int[] toConnect = { id - col - 1, id - col, id - col + 1,
          id - 1, id + 1,
          id + col - 1, id + col, id + col + 1 };

      for (int adj : toConnect) {

        if (adj >= 0 && adj < vertices.length && Calculator.calcDist(vertex, vertices[adj]) < 20000.0) {

            vertex.addEdge(vertices[adj]);

        }
      }
    }

    return vertices;
  }

  // public static void main(String[] args) {

  //   // TESTES

  //   DtedDatabaseHandler dbRio = openDtedDB("dted/rio");

  //   int rows = 4, cols = 3;

  //   Vertex[] coordData = getCoordData(dbRio, -43.4076, -22.1510, rows, cols);

  // }
}