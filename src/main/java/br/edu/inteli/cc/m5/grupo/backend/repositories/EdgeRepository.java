package br.edu.inteli.cc.m5.grupo.backend.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.edu.inteli.cc.m5.grupo.backend.entities.Edge;

public interface EdgeRepository extends Neo4jRepository<Edge, Long> {}