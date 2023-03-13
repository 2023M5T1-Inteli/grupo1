package br.edu.inteli.cc.m5.grupo.backend.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.edu.inteli.cc.m5.grupo.backend.entities.Vertex;

/**
 * This interface represents a repository for managing {@link Vertex} entities in a Neo4j graph database.
 * It extends the {@link org.springframework.data.neo4j.repository.Neo4jRepository} interface.
 */
public interface VertexRepository extends Neo4jRepository<Vertex, Long> {}