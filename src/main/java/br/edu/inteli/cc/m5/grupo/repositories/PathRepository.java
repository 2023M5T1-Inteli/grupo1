/**

This package contains classes and interfaces related to managing graph entities in Neo4j.
*/
package br.edu.inteli.cc.m5.grupo.repositories;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.edu.inteli.cc.m5.grupo.entities.Path;

public interface PathRepository extends Neo4jRepository<Path, Long> {}