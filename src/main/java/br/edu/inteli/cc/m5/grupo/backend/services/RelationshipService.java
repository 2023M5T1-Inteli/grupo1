package br.edu.inteli.cc.m5.grupo.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;

import java.util.ArrayList;
import java.util.List;

import br.edu.inteli.cc.m5.grupo.backend.entities.Coordinate;
import br.edu.inteli.cc.m5.grupo.backend.entities.Graph;

import br.edu.inteli.cc.m5.grupo.backend.repositories.CoordinateRepository;

public class RelationshipService {

    @Autowired
    private Neo4jTemplate neo4jTemplate;
    @Autowired
    private CoordinateRepository coordinateRepository;

        public void SetRelationshipService(Graph graph) {

            Long sizeLine = (long) graph.getSize();
            Long sizeColumn = (long) graph.getRows().get(0).size();
            Long totalNodes = (long) sizeLine * sizeColumn;

            for (Long i = (long) 1; i <= sizeLine; i++) {
                for (Long j = (long) 1; j <= sizeColumn; j++) {

                    Long idAtual = i * j;
                    List<Coordinate> auxiliar = new ArrayList<Coordinate>();
                    Coordinate node = coordinateRepository.findById(i * j).orElseThrow();
                    
                        // Canto superior esquerdo
                        if (i == 1 && j == 1) {
                            auxiliar.add(coordinateRepository.findById(idAtual + 1).orElseThrow()); // direita
                            auxiliar.add(coordinateRepository.findById((i + 1) * j).orElseThrow()); // pra baixo
                            auxiliar.add(coordinateRepository.findById((i + 1) * (j + 1)).orElseThrow()); // diagonal inferior direita
                        } 
                        // Canto superior direito
                        else if (i == 1 && j == sizeColumn) {
                            auxiliar.add(coordinateRepository.findById(idAtual - 1).orElseThrow()); // esquerda
                            auxiliar.add(coordinateRepository.findById((i + 1) * j).orElseThrow()); // pra baixo
                            auxiliar.add(coordinateRepository.findById((i + 1) * (j - 1)).orElseThrow()); // diagonal inferior esquerda
                        } 
                        // Canto inferior direito
                        else if (i == sizeLine && j == sizeColumn) {
                            auxiliar.add(coordinateRepository.findById(idAtual - 1).orElseThrow()); // esquerda
                            auxiliar.add(coordinateRepository.findById((i - 1) * j).orElseThrow()); // pra cima
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j - 1)).orElseThrow()); // diagonal superior esquerda
                        } 
                        // Canto inferior esquerdo
                        else if (i == sizeLine && j == 1) {
                            auxiliar.add(coordinateRepository.findById((i - 1) * j).orElseThrow()); // pra cima
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j + 1)).orElseThrow()); // diagonal superior direita
                            auxiliar.add(coordinateRepository.findById(idAtual + 1).orElseThrow()); // direita
                        } 
                        // Borda superior
                        else if (i == 1) {
                            auxiliar.add(coordinateRepository.findById(idAtual + 1).orElseThrow()); // direita
                            auxiliar.add(coordinateRepository.findById((i + 1) * j).orElseThrow()); // pra baixo
                            auxiliar.add(coordinateRepository.findById((i + 1) * (j + 1)).orElseThrow()); // diagonal inferior direita
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j + 1)).orElseThrow()); // diagonal superior direita
                            auxiliar.add(coordinateRepository.findById((i - 1) * j).orElseThrow()); // pra cima
                        } 
                        // Borda inferior
                        else if (i == sizeLine) {
                            auxiliar.add(coordinateRepository.findById(idAtual + 1).orElseThrow()); // direita
                            auxiliar.add(coordinateRepository.findById(idAtual - 1).orElseThrow()); // esquerda
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j - 1)).orElseThrow()); // diagonal superior esquerda
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j + 1)).orElseThrow()); // diagonal superior direita
                            auxiliar.add(coordinateRepository.findById((i - 1) * j).orElseThrow()); // pra cima
                        } 
                        // Borda direita
                        else if (j == sizeColumn) {
                            auxiliar.add(coordinateRepository.findById((i - 1) * j).orElseThrow()); // pra cima
                            auxiliar.add(coordinateRepository.findById(idAtual - 1).orElseThrow()); // esquerda
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j - 1)).orElseThrow()); // diagonal superior esquerda
                            auxiliar.add(coordinateRepository.findById((i + 1) * j).orElseThrow()); // pra baixo
                            auxiliar.add(coordinateRepository.findById((i + 1) * (j - 1)).orElseThrow()); // diagonal inferior esquerda
                        } 
                        // Borda esquerda
                        else if (j == 1) {
                            auxiliar.add(coordinateRepository.findById((i - 1) * j).orElseThrow()); // pra cima
                            auxiliar.add(coordinateRepository.findById((i + 1) * j).orElseThrow()); // pra baixo
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j + 1)).orElseThrow()); // diagonal superior direita
                            auxiliar.add(coordinateRepository.findById(i * (j + 1)).orElseThrow()); // direita
                            auxiliar.add(coordinateRepository.findById((i + 1) * (j + 1)).orElseThrow()); // diagonal inferior direita
                        }
                        // Centro
                        else {
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j - 1)).orElseThrow()); // diagonal superior esquerda
                            auxiliar.add(coordinateRepository.findById((i - 1) * j).orElseThrow()); // pra cima
                            auxiliar.add(coordinateRepository.findById((i - 1) * (j + 1)).orElseThrow()); // diagonal superior direita
                            auxiliar.add(coordinateRepository.findById(i * (j - 1)).orElseThrow()); // esquerda
                            auxiliar.add(coordinateRepository.findById(i * (j + 1)).orElseThrow()); // direita
                            auxiliar.add(coordinateRepository.findById((i + 1) * (j - 1)).orElseThrow()); // diagonal inferior esquerda
                            auxiliar.add(coordinateRepository.findById((i + 1) * j).orElseThrow()); // pra baixo
                            auxiliar.add(coordinateRepository.findById((i + 1) * (j + 1)).orElseThrow()); // diagonal inferior direita
                        }

                        node.setAdjacents(auxiliar);
                        neo4jTemplate.save(node);

                    }
                }
    }
    
}