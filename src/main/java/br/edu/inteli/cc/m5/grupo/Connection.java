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

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;

public class Connection {
    private final Driver driver;

    private final String uri = "NEO4J_URI"; // endereço do banco de dados Neo4j
    private final String user = "NEO4J_USER"; // usuário de acesso do DB
    private final String password = "NEO4J_PSW"; // senha de acesso do DB
    private final Config config = Config.defaultConfig(); // configura a conexão com o DB

    public Connection() {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password), config);
    }

    // ---------- NODES -----------

    /**
     * Função que cria (CREATE) um Vértice novo no Neo4j
     * 
     * @param id        id do nó
     * @param latitude  latitude do Nó
     * @param longitude logitude do Nó
     * @param altitude  altitude do Nó
     */
    public void createNode(int id, double latitude, double longitude, double altitude) {
        var query = new Query(
                """
                            CREATE (n:Node { id: $id, lat: $latitude, long: $longitude, alt: $altitude })
                            RETURN n
                        """,
                Map.of("latitude", latitude, "longitude", longitude, "altitude", altitude, "id", id)); // query de
                                                                                                       // criação de Nó
                                                                                                       // no
                                                                                                       // banco de dados

        try (var session = driver.session(SessionConfig.forDatabase("neo4j"))) {
            var record = session.executeWrite(tx -> tx.run(query).single());
            System.out.printf(
                    "Created node id:%d, lat:%.2f , long:%.2f , alt:%.2f",
                    record.get("n").get("id").asInt(),
                    record.get("n").get("lat").asDouble(),
                    record.get("n").get("long").asDouble(),
                    record.get("n").get("alt").asDouble());
        } catch (Neo4jException ex) {
            throw ex;

        }
    }

    /**
     * Função que lê (READ) as informações de um Vértice existente no Neo4j com base
     * n o id
     * 
     * @param id id do Nó
     * @return
     */
    public Record readNode(int id) {
        var query = new Query(
                """
                        MATCH (n:Node)
                        WHERE n.id = $id
                        RETURN n
                        """,
                Map.of("id", id)); // query de busca no banco de dados

        try (var session = driver.session(SessionConfig.forDatabase("neo4j"))) {
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

    /**
     * Função que atualiza (UPDATE) as informações de um Vértice no banco de dados
     * 
     * @param id         id do Nó cujos dados serão modificados
     * @param alt        nova altitude do Nó
     * @param lat        nova latitude do Nó
     * @param longParams nova logitude do Nó
     */
    public void updateNode(int id, Double alt, Double lat, Double longParams) {
        try (var session = driver.session()) {
            try (var tx = session.beginTransaction()) {
                tx.run("MATCH (n: Node {id: " + id + " }) SET n.alt = " + alt + ", n.lat = " + lat + ", n.long = "
                        + longParams); // query que busca um Nó com base no id no banco de dados e muda suas
                                       // informações

                tx.commit();
            }
        } catch (Neo4jException ex) {
            throw ex;
        }
    }

    /**
     * Função que apaga (DELETE) um Vértice no banco de dados com base no id
     * 
     * @param id id do Nó a ser deletado
     */
    public void deleteNode(int id) {
        Session session = driver.session();

        String query = "MATCH (n:Person {name: 'Carrie-Anne Moss'}) DETACH DELETE n"; // query que apaga um nó com base
                                                                                      // no id

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("id", id);

        session.run(query, parameters);

        session.close();

        driver.close();
    }

    // ---------- RELATIONSHIPS -----------

    /**
     * Função que cria (CREATE) uma Aresta nova entre dois Vértices existentes no
     * Neo4j
     * 
     * @param id1    id do Nó de origem
     * @param id2    id do Nó de destino
     * @param dist   distância entre os Nós
     * @param altVar variação da altitude entre os Nós
     */
    public void createRelationshipTwoNodes(int id1, int id2, double dist, double altVar) {
        Session session = driver.session();

        String cypherQuery = "MATCH (a:Node {id: $nodeAId}), (b:Node {id: $nodeBId}) CREATE (a)-[:GO_TO {dist: $distance, alt_var: $altVar}]->(b)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nodeAId", id1);
        parameters.put("nodeBId", id2);
        parameters.put("distance", dist);
        parameters.put("altVar", altVar);

        session.run(cypherQuery, parameters);

        session.close();
    }

    public void createRelationship(int n) {

        for (int i = 0; i < n * n; i++) {

            Record record = readNode(i);

            double lat1 = record.get("n").get("lat").asDouble();
            double lon1 = record.get("n").get("long").asDouble();
            double alt1 = record.get("n").get("alt").asDouble();

            int[] idsToConnect = { i + 1, i + n, i + n + 1, i + n + -1 };

            for (int j = 0; j < idsToConnect.length; j++) {
                int id2 = idsToConnect[j];

                Record record2 = readNode(id2);

                double lat2 = record2.get("n").get("lat").asDouble();
                double lon2 = record2.get("n").get("long").asDouble();
                double alt2 = record2.get("n").get("alt").asDouble();

                double lat_diff = lat2 - lat1;
                double lon_diff = lon2 - lon1;
                double dist = Math.sqrt(Math.pow(lat_diff, 2) + Math.pow(lon_diff, 2)) * 111.1;

                if (dist <= 120 * 1.41) {
                    createRelationshipTwoNodes(i, id2, dist, alt2 - alt1);
                }
            }
        }
    }

    public void readRelationship() {

    }

    public void updateRelationship() {

    }

    /**
     * Função que apaga (DELETE) todas as Arestas de um determinado Vétice
     * 
     * @param id // id do Nó cujas Relações serão excluídas
     */
    public void deleteRelationship(int id) {
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

        // TESTES

        // for (int i = 0; i < 4; i++) {
        // for (int j = 0; j < 4; j++) {
        // int id = i * 4 + j;
        // int latitude = i;
        // int longitude = j;
        // int altitude = 0;
        // app.createNode(id, latitude, longitude, altitude);
        // }
        // }

        // app.createRelationship(4);
        // DtedDatabaseHandler dbRio = Coordinates.openDtedDB("dted/rio");
        // double[][] coordData = Coordinates.getCoordData(dbRio, -43.4076, -22.1510, 5,
        // 5);
        // for(int i = 0; i < coordData.length; i++) {
        // app.createNode(i, coordData[i][0], coordData[i][1], coordData[i][2]);
        // }
        app.createRelationship(5);
    }
}