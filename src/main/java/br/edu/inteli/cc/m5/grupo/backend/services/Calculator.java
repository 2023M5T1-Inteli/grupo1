package br.edu.inteli.cc.m5.grupo.backend.services;

import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;

/**
 * class that contains methods to calculate recurrent formulas in the process
 * 
 */
public class Calculator {

  /**
   * method that use the Haversine formula to find the distance between an
   * coordinate A and a coordinate B
   * 
   * @param start origin vertex (coordinate A)
   * @param end   final vertex (coordinate B)
   * @return distance
   */
  public static double calcDist(Vertex start, Vertex end) {

    // coordinate A data
    double lat1 = start.getLatitude();
    double lon1 = start.getLongitude();
    // coordinate B data
    double lat2 = end.getLatitude();
    double lon2 = end.getLongitude();

    double r = 6371.0; // Earth radius

    double distance = 2 * r * Math.asin(Math.sqrt(
        Math.pow(Math.sin((lat1 - lat2) / 2), 2) + Math.cos(lat1) * Math.cos(lat2) *
            Math.pow(Math.sin((lon1 - lon2) / 2), 2))); // Haversine formula

    return distance * 1000.0;
  }

  /**
   * method that calculates the altitude variation between a coordinate A and a
   * coordinate B
   * 
   * @param start origin vertex (coordinate A)
   * @param end   final vertex (coordinate B)
   * @return the altitude difference between the two points
   */
  public static double altVar(Vertex start, Vertex end) {
    double alt1 = start.getAltitude(); // coordinate A data
    double alt2 = end.getAltitude(); // coordinate B data

    return Math.abs(alt2 - alt1); // altitude variation
  }

}
