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
import org.neo4j.driver.Record;


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

    public void createNode(int id, double latitude, double longitude, double altitude) {
        var query = new Query(
            """
                CREATE (n:Node { id: $id, lat: $latitude, long: $longitude, alt: $altitude })
                RETURN n
            """,
                Map.of("latitude", latitude, "longitude", longitude, "altitude", altitude, "id", id));


        try (var session = driver.session(SessionConfig.forDatabase("neo4j"))) {
            // Write transactions allow the driver to handle retries and transient errors
            var record = session.executeWrite(tx -> tx.run(query).single());
            System.out.printf(
                    "Created node id:%d, lat:%.2f , long:%.2f , alt:%.2f",
                    record.get("n").get("id").asInt(),
                    record.get("n").get("lat").asDouble(),
                    record.get("n").get("long").asDouble(),
                    record.get("n").get("alt").asDouble());
            // You should capture any errors along with the query and data for traceability
        } catch (Neo4jException ex) {
            throw ex;
        }
    }

    public Record readNode(int id) {
        var query = new Query(
            """  
            MATCH (n:Node)
            WHERE n.id = $id
            RETURN n
            """,
            Map.of("id", id));

        try (var session = driver.session(SessionConfig.forDatabase("neo4j"))) {
            // Write transactions allow the driver to handle retries and transient errors
            Record record = session.executeWrite(tx -> tx.run(query).single());
            System.out.printf(
                    "Read node id:%d, lat:%.2f , long:%.2f , alt:%.2f",
                    record.get("n").get("id").asInt(),
                    record.get("n").get("lat").asDouble(),
                    record.get("n").get("long").asDouble(),
                    record.get("n").get("alt").asDouble());

            return record;
        } catch (Neo4jException ex) {
            throw ex;
        }
    }

    public void updateNode() {
        
    }

    public void deleteNode() {
        
    }

    // ---------- RELATIONSHIPS -----------

    public void createRelationship(int id) {
        //create relationship
    }

    public void readRelationship() {
        
    }

    public void updateRelationship() {
        
    }

    public void deleteRelationship() {
        
    }

    public static void main(String[] args) {
        var app = new Connection();
        app.createRelationship(0);
    }
}
