package br.edu.inteli.cc.m5.grupo;

public class Calculator {

  public static double calcDist(Vertex start, Vertex end) {

    double lat1 = start.getLatitude();
    double lon1 = start.getLongitude();
    double lat2 = end.getLatitude();
    double lon2 = end.getLongitude();

    double r = 6371.0;

    double distance = 2 * r * Math.asin(Math.sqrt(
        Math.pow(Math.sin((lat1 - lat2) / 2), 2) + Math.cos(lat1) * Math.cos(lat2) *
            Math.pow(Math.sin((lon1 - lon2) / 2), 2)));

    return distance * 1000.0;
  }

  public static double altVar(Vertex start, Vertex end) {
    double alt1 = start.getAltitude();
    double alt2 = end.getAltitude();

    return Math.abs(alt2 - alt1);
  }

}
