package br.edu.inteli.cc.m5.grupo.repositories;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.edu.inteli.cc.m5.grupo.Node;

public interface NodeRepository extends Neo4jRepository<Node, Long> {}