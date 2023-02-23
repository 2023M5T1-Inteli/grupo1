package br.edu.inteli.cc.m5.grupo;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Config;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Query;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.exceptions.Neo4jException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;


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
            System.out.println(" ");
            System.out.println(" ");
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
    public void createRelationshipTwoNodes(int id1, int id2, double dist, double altVar) {
        Session session = driver.session();

        String cypherQuery = "MATCH (a:Node {id: $nodeAId}), (b:Node {id: $nodeBId}) CREATE (a)-[:GO_TO {dist: $distance, alt_var: $altVar}]->(b)";

        // Define the parameters for the query
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nodeAId", id1);
        parameters.put("nodeBId", id2);
        parameters.put("distance", dist);
        parameters.put("altVar", altVar);


        session.run(cypherQuery, parameters);

        session.close();
    }


    public void createRelationship(int n) {


        for (int i = 0; i < n*n; i++) {

            Record record = readNode(i);

            double lat1 = record.get("n").get("lat").asDouble();
            double lon1 = record.get("n").get("long").asDouble();
            double alt1 = record.get("n").get("alt").asDouble();
            
            int[] idsToConnect = {i + 1, i + n, i + n + 1, i + n + - 1};

            for (int j = 0; j < idsToConnect.length; j++) {
                int id2 = idsToConnect[j];

                Record record2 = readNode(id2);

                double lat2 = record2.get("n").get("lat").asDouble();
                double lon2 = record2.get("n").get("long").asDouble();
                double alt2 = record2.get("n").get("alt").asDouble();

                double lat_diff = lat2 - lat1;
                double lon_diff = lon2 - lon1;
                double dist = Math.sqrt(Math.pow(lat_diff, 2) + Math.pow(lon_diff, 2)) * 111.1;

                if (dist <= 120*1.41) {
                    createRelationshipTwoNodes(i, id2, dist, alt2-alt1);
                }
            }
            }
        }

        /*
            . . . .
            . . . .
            . . . .
            . . . .

            i + 1 -> direita
            i + n -> baixo
            i + n + 1 -> direita inferior
            i + n - 1 -> esquerda inferior

            para os nós [5, 9] --> ligar apenas ao da direita, ao de baixo e ao direita inferior
            para os nós [2, 3] --> ligar apenas ao da direita, baixo, direita inferior e esquerda inferior
            para os nós [8, 12] --> ligar ao de baixo, esquerda inferior
            para o nó 1 --> ligar direita, baixo, direita inferior
            para o nó 4 --> ligar baixo, esquerda inferior
            para o nó 13 --> ligar direita
            para o nó 16 --> não ligar nada
         
         */
        
        
    

    public void readRelationship() {
        
    }

    public void updateRelationship() {
        
    }

    public void deleteRelationship() {
        Session session = driver.session();

        String query = "MATCH (n:Node {id: $id})-[r:GO_TO]->() DELETE r";

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("id", id);

        session.run(query, parameters);

        session.close();

        driver.close();
    }

    public static void main(String[] args) {
        var app = new Connection();
        

        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 4; j++) {
        //         int id = i * 4 + j;
        //         int latitude = i;
        //         int longitude = j;
        //         int altitude = 0;
        //         app.createNode(id, latitude, longitude, altitude);
        //     }
        // }

        app.createRelationship(4);
    }
}
