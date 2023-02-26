package br.edu.inteli.cc.m5.grupo;

import java.util.Optional;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;

public class Coordinates {
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
   * Função que retorna os dados necessários para montar um nó em forma de array
   * 
   * @param dbDTED    banco de dados DTED inicializado
   * @param longitude longitude da coordenada
   * @param latitude  latitude da coordenada
   * @return array que contém longitude, latitude e altitude de um determinado
   *         ponto
   */
  public static double[] getAltitude(DtedDatabaseHandler dbDTED, double longitude, double latitude) {

    Optional<Integer> altitude = dbDTED.QueryLatLonElevation(longitude, latitude); // query que busca a altitude de um
                                                                                   // ponto com base na longitude e na
                                                                                   // latitude da coordenada
    // System.out.println("lon: " + longitude + ", lat: " + latitude + ", altitude:
    // " + altitude.get());

    double[] coordData = { longitude, latitude, (double) altitude.get() }; // array contendo os dados de um Nó
                                                                           // (longitude, latitude e altitude)

    return coordData;
  }

  /**
   * Função que retorna todas as informações para montar uma malha de nós com base
   * na coordenada de um ponto inicial e
   * no número de vértices dentro da malha
   * Todos os pontos dentro dessa estrutura precisam estar dentro do DB DTED
   * 
   * @param dbDTED   banco de dados DTED inicializado
   * @param longZero longitude do ponto inicial
   * @param latZero  latitude do ponto inicial
   * @param row      número de linhas da malha de nós
   * @param col      número de colunas da malha de nós
   * @return array que contém vários arrays com os dados necessários para a
   *         construção de nós
   */
  public static double[][] getCoordData(DtedDatabaseHandler dbDTED, double longZero, double latZero, int row, int col) {
    double[][] coordData = new double[row * col][3]; // array multidimensional que contém as informações de todos os Nós
                                                     // da malha

    int count = 0; // variável auxiliar que armazena a quantidade de nós criados
    double lon;
    double lat = latZero;
    for (int i = 0; i < row; i++) { // loop que obtém os dados linha por linha
      lon = longZero;
      for (int j = 0; j < col; j++) { // loop que obtém os dados de todos os nós de uma determinada linha da malha
        coordData[count] = getAltitude(dbDTED, lon, lat);
        lon += 0.12; // constante (em graus) que viaja 120m no sentido Oeste - Leste em uma mesma
                     // latitude com base na Fórmula de Harversine (WIP!!!)
        count++;
      }
      lat -= 0.0011; // constante (em graus) que viaja 120m no sentido Norte - Sul em uma mesma
                     // logitude com base na Fórmula de Harversine (WIP!!!)
    }

    return coordData;

  }

  public static void main(String[] args) {

    // TESTES

    DtedDatabaseHandler dbRio = openDtedDB("dted/rio");

    int rows = 5, cols = 4;

    double[][] coordData = getCoordData(dbRio, -43.4076, -22.1510, rows, cols);

    for (int i = 0; i < rows * cols; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.println(coordData[i][j]);
      }
    }

    // System.out.println(coordData);

  }
}