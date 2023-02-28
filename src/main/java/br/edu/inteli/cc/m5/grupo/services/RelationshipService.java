package br.edu.inteli.cc.m5.grupo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.inteli.cc.m5.grupo.repositories.CoordinateRepository;
import br.edu.inteli.cc.m5.grupo.entities.Coordinate;

@Service
public class RelationshipService {
    
    @Autowired
    private CoordinateRepository CoordinateRepository;
    
    public void LinkTwoNodes(Coordinate node1, Coordinate node2) {
        
    }
    
}
