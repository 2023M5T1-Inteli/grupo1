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
    private static final Logger LOGGER = Logger.getLogger(DriverIntroductionExample.class.getName());
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

    public void deleteNode(final String personName) {
        var query = new Query(
            """
                MATCH (n:Person {name: $person_name})
                ETACH DELETE n
            """,

            Map.of("person_name", personName));
        try (var session = driver.session(SessionConfig.forDatabase("neo4j"))) {
            // Write transactions allow the driver to handle retries and transient errors
            var record = session.executeWrite(tx -> tx.run(query).single());
            // You should capture any errors along with the query and data for traceability
        } catch (Neo4jException ex) {
            LOGGER.log(Level.SEVERE, query + " raised an exception", ex);
            throw ex;
        }
    }

    // ---------- RELATIONSHIPS -----------

    public void createRelationship() {
        
    }

    public void readRelationship() {
        
    }

    public void updateRelationship() {
        
    }

    public void deleteRelationship(final String personName, final String relationship) {
        var query = new Query(
            """
                MATCH (n:Person {name: $personName})-[r:$relationship]->()
                DELETE r
            """,

            Map.of("person_name", personName));
        try (var session = driver.session(SessionConfig.forDatabase("neo4j"))) {
            // Write transactions allow the driver to handle retries and transient errors
            var record = session.executeWrite(tx -> tx.run(query).single());
            // You should capture any errors along with the query and data for traceability
        } catch (Neo4jException ex) {
            LOGGER.log(Level.SEVERE, query + " raised an exception", ex);
            throw ex;
        }
    }

    public static void main(String[] args) {
        var app = new Connection();
        
    }
}
