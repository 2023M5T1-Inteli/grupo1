package br.edu.inteli.cc.m5.grupo.services;

import org.springframework.data.neo4j.core.Neo4jTemplate;
import br.edu.inteli.cc.m5.grupo.repositories.CoordinateRepository;

import java.util.ArrayList;
import java.util.List;

import br.edu.inteli.cc.m5.grupo.entities.Coordinate;

import br.edu.inteli.cc.m5.grupo.entities.Graph;

public class RelationshipService {

    private Neo4jTemplate neo4jTemplate;
    private CoordinateRepository coordinateRepository;

    private Graph graph;

        public void SetRelationshipsService() {
            Integer sizeLine = graph.getSize();
            Integer sizeColumn = graph.getRows().get(0).size();
            Integer totalNodes = sizeLine * sizeColumn;

            for (Integer i = 1; i <= sizeLine; i++) {
                for (Integer j = 1; j <= sizeColumn; j++) {

                    Integer idAtual = i * j;
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

                    }
                }
    }
    
}
