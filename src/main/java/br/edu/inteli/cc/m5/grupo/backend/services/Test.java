package br.edu.inteli.cc.m5.grupo.backend.services;

import java.util.ArrayList;
import java.util.List;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;
import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;

public class Test {

  public static void main(String[] args) {

    int tests = 1;

    int square = 30;

    double[] pathTime = new double[tests];
    double[] graphTime = new double[tests];
    int[] size = new int[tests];

    DtedDatabaseHandler dbRio = GraphConstructor.openDtedDB("dted/Rio");

    for (int i = 0, l = square; i < tests; i++, l += 50) {

      size[i] = l;

      System.out.println("Test " + i + ": size " + l + "x" + l);

      long time1 = System.nanoTime();

      Vertex[] graph = GraphConstructor.getCoordData(dbRio, l, l, -22.0564, -43.9379);

      long time2 = System.nanoTime();

      graphTime[i] = ((time2 - time1) / 1000000);

      System.out.println("Elapsed time to build graph: " + ((time2 - time1) / 1000000) + " ms\n\n");

      time1 = System.nanoTime();

      List<Vertex> shortPath = Star.findPath(graph[0], graph[graph.length - 1]);

      time2 = System.nanoTime();

      pathTime[i] = ((time2 - time1) / 1000000);

      System.out.println(
          "Elapsed time to find path: " + ((time2 - time1) / 1000000) + " ms // " + ((time2 - time1) / 60000000000.0) +
              " min\n\n\n\n");

      List<Long> ids = new ArrayList<Long>();

      for (int j = 0; j < shortPath.size(); j++) {
        ids.add(shortPath.get(j).getId());
      }

      for (int j = 0; j < square; j++) {
        for (int k = 0; k < square; k++) {
          if (ids.contains((long) (j * square + k)))
            System.out.print(" x ");
          else
            System.out.print(" - ");
        }
        System.out.print("\n");
      }

    }

    System.out.println("[");
    for (int i = 0; i < size.length; i++) {
      System.out.print(size[i] + ", ");
    }
    System.out.println("]");

    System.out.print("==================");

    System.out.println("[");
    for (int i = 0; i < graphTime.length; i++) {
      System.out.print(graphTime[i] + ", ");
    }
    System.out.println("]");

    System.out.print("==================");

    System.out.println("[");
    for (int i = 0; i < pathTime.length; i++) {
      System.out.print(pathTime[i] + ", ");
    }
    System.out.println("]");

  }
}
