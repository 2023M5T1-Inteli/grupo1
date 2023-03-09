package br.edu.inteli.cc.m5.grupo.backend.services;

import br.edu.inteli.cc.m5.dted.DtedDatabaseHandler;

public class DatabaseHandler {

    public static DtedDatabaseHandler openDtedDB(String path) {
        DtedDatabaseHandler dtedDB = new DtedDatabaseHandler(); // variável do tipo DtedDatabaseHandler que armazena o DB
        dtedDB.InitializeFromResources(path); // inicialização do DB através do caminho fornecido
        // if (dtedDBok) --> verifica se o DB foi inicializado corretamnete (WIP!!!)
        return dtedDB;
    }
    
}
