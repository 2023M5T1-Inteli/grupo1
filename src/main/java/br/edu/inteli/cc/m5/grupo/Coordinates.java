package br.edu.inteli.cc.m5.grupo;

import java.util.Optional;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;

public class Coordinates {

  public static DtedDatabaseHandler openDtedDB(String path) {
    DtedDatabaseHandler dtedDB = new DtedDatabaseHandler();
    dtedDB.InitializeFromResources(path);
    // if (dtedDBok)
    return dtedDB;
  }

  public static double[] getAltitude(DtedDatabaseHandler dbDTED, double longitude, double latitude) {

    Optional<Integer> altitude = dbDTED.QueryLatLonElevation(longitude, latitude);
    System.out.println("lon: " + longitude + ", lat: " + latitude + ", altitude: " + altitude.get());

    double[] coordData = { longitude, latitude, (double) altitude.get() };

    return coordData;
  }

  public static double[][] getCoordData(DtedDatabaseHandler dbDTED, double longZero, double latZero, int row, int col) {
    double[][] coordData = new double[row * col][3];

    int count = 0;
    double lon;
    double lat = latZero;
    for (int i = 0; i < row; i++) {
      lon = longZero;
      for (int j = 0; j < col; j++) {
        coordData[count] = getAltitude(dbDTED, lon, lat);
        lon += 0.12; // rever constante
        count++;
      }
      lat -= 0.12; // rever constante
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

    System.out.println(coordData.toString());

  }
}