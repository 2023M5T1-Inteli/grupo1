/**

This package contains classes and interfaces related to managing graph entities in Neo4j.
*/
package br.edu.inteli.cc.m5.grupo.repositories;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.edu.inteli.cc.m5.grupo.entities.Graph;

/**
The GraphRepository interface is responsible for managing {@link Graph} entities in Neo4j.
It extends the {@link Neo4jRepository} interface, which provides basic CRUD operations for the entity.
@see Graph
@see Neo4jRepository
*/

public interface GraphRepository extends Neo4jRepository<Graph, Long> {}