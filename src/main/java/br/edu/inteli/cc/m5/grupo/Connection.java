package br.edu.inteli.cc.m5.grupo;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Config;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Query;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.exceptions.Neo4jException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connection {
    private final Driver driver;
    
    private final String uri = "neo4j+s://6c96b965.databases.neo4j.io:7687";
    private final String user = "neo4j";
    private final String password = "Gk54tBkc3WXygiR9X9U6GMWoaB9GbvbogYFyq7YpsqA";
    private final Config config = Config.defaultConfig();


    public Connection() {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password), config);
    }

    // ---------- NODES -----------

    public void createNode() {

    }

    public void readNode() {
        
    }

    public void updateNode() {
        
    }

    public void deleteNode() {
        
    }

    // ---------- RELATIONSHIPS -----------

    public void createRelationship() {
        
    }

    public void readRelationship() {
        
    }

    public void updateRelationship() {
        
    }

    public void deleteRelationship() {
        
    }

    public static void main(String[] args) {
        var app = new Connection();
        
    }
}
