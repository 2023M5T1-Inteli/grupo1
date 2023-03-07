package br.edu.inteli.cc.m5.grupo.services;


import br.edu.inteli.cc.m5.grupo.repositories.CoordinateRepository;

import java.util.ArrayList;
import java.util.List;

import br.edu.inteli.cc.m5.grupo.entities.Coordinate;

import br.edu.inteli.cc.m5.grupo.entities.Graph;

public class RelationshipService {

    private CoordinateRepository coordinateRepository;

    private Graph graph;

        public List<Integer> RelationshipService(Coordinate node) {
            List<Integer> auxiliar = new ArrayList<Integer>();
            Integer sizeLine = graph.getSize();
            Integer sizeColumn = graph.getRows().get(0).size();
            Integer totalNodes = sizeLine * sizeColumn;

            for (int i = 1; i <= sizeLine; i++) {
                for (int j = 1; j <= sizeColumn; j++) {
                    int noAtual = i * j;
                    if (noAtual == node.getId()) {
                        if (i == 1 && j == 1) {
                                auxiliar.add(noAtual + 1); // direita
                                auxiliar.add((i + 1) * j); // pra baixo
                                auxiliar.add((i + 1) * (j + 1)); // diagonal inferior direita
                        }
                        else if (i == 1) {
                                auxiliar.add(noAtual + 1); // direita
                                auxiliar.add((i + 1) * j); // pra baixo
                                auxiliar.add((i + 1) * (j + 1)); // diagonal inferior direita
                                auxiliar.add((i - 1) * (j + 1)); // diagonal superior direita
                                auxiliar.add((i - 1) * j); // pra cima
                        }
                        else if (i == sizeLine && j == sizeColumn) {
                                auxiliar.add(noAtual - 1); // esquerda
                                auxiliar.add((i - 1) * j); // pra cima
                                auxiliar.add((i - 1) * (j - 1)); // diagonal superior esquerda
                        }
                        else if (i == sizeLine) {
                                auxiliar.add(noAtual + 1); // direita
                                auxiliar.add(noAtual - 1); // esquerda
                                auxiliar.add((i - 1) * (j - 1)); // diagonal superior esquerda
                                auxiliar.add((i - 1) * (j + 1)); // diagonal superior direita
                                auxiliar.add((i - 1) * j); // pra cima
                        } 
                        else if (j == sizeColumn) {
                            auxiliar.add((i - 1) * j); // pra cima
                            auxiliar.add(noAtual - 1); // esquerda
                            auxiliar.add((i - 1) * (j - 1)); // diagonal superior esquerda
                            auxiliar.add((i + 1) * j); // pra baixo
                            auxiliar.add((i + 1) * (j - 1)); // diagonal inferior esquerda
                        } 
                        else if (i == sizeColumn && j == 1) {
                            auxiliar.add((i - 1) * j); // pra cima
                            auxiliar.add((i - 1) * (j + 1)); // diagonal superior direita
                            auxiliar.add(noAtual + 1); // direita
                        } 
                        else if (i == 1 && j == sizeColumn) {
                            auxiliar.add(noAtual - 1); // esquerda
                            auxiliar.add((i + 1) * j); // pra baixo
                            auxiliar.add((i + 1) * (j - 1)); // diagonal inferior esquerda
                        }
                        else if (j == 1) {
                            auxiliar.add((i - 1) * j); // pra cima
                            auxiliar.add(noAtual + 1); // direita
                            auxiliar.add((i - 1) * (j + 1)); // diagonal superior direita
                            auxiliar.add((i + 1) * (j + 1)); // diagonal inferior direita
                            auxiliar.add((i + 1) * j); // pra baixo
                        }
                        else {
                            auxiliar.add((i - 1) * j); // pra cima
                            auxiliar.add(noAtual + 1); // direita
                            auxiliar.add((i - 1) * (j + 1)); // diagonal superior direita
                            auxiliar.add((i + 1) * (j + 1)); // diagonal inferior direita
                            auxiliar.add((i + 1) * j); // pra baixo
                            auxiliar.add(noAtual - 1); // esquerda
                            auxiliar.add((i + 1) * (j - 1)); // diagonal inferior esquerda
                            auxiliar.add((i - 1) * (j - 1)); // diagonal superior esquerda
                        }
                    }
                }
            }
            return auxiliar;
    }
    
}
