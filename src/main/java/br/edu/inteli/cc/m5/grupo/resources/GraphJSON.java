package br.edu.inteli.cc.m5.grupo.resources;

import com.google.gson.Gson;
import br.edu.inteli.cc.m5.grupo.entities.Graph;

public class GraphJSON {

    private String parsedJSON;

    public GraphJSON(Graph graph) {
        Gson gson = new Gson();
        parsedJSON = gson.toJson(graph);        
    }

}
