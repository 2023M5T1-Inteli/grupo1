/**

This package contains classes and interfaces related to managing coordinate entities in Neo4j.
*/
package br.edu.inteli.cc.m5.grupo.backend.repositories;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.edu.inteli.cc.m5.grupo.backend.entities.Coordinate;

/**
The CoordinateRepository interface is responsible for managing {@link Coordinate} entities in Neo4j.
It extends the {@link Neo4jRepository} interface, which provides basic CRUD operations for the entity.
@see Coordinate
@see Neo4jRepository
*/

public interface CoordinateRepository extends Neo4jRepository<Coordinate, Long> {}