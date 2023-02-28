package br.edu.inteli.cc.m5.grupo.constants; 

public class Errors {
    
    public static final class Server {
    
        public static final Error INTERNAL_SERVER_ERROR = new Error(500, "Internal Server Error", "The server encountered an internal error that prevented it from processing the request.");
        
    }

    public static final class Node {

        public static final Error NODE_NOT_FOUND = new Error(404, "Node not found", "The requested node was not found in the system.");
        public static final Error INVALID_NODE_DATA = new Error(400, "Invalid node data", "The data sent to create the node is invalid.");
        
    }
    
    public static final class Edge {
        
        public static final Error EDGE_NOT_FOUND = new Error(404, "Edge not found", "The requested edge was not found in the system.");
        public static final Error INVALID_EDGE_DATA = new Error(400, "Invalid edge data", "The data sent to create the edge is invalid.");

    }

}