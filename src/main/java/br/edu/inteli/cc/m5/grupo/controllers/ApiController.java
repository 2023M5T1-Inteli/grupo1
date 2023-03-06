package br.edu.inteli.cc.m5.grupo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.inteli.cc.m5.grupo.resources.SuccessResponse;

@RestController
@RequestMapping("/")
public class ApiController { 

    @GetMapping("/")
    public ResponseEntity<SuccessResponse> helloWorld() {
        SuccessResponse successResponse = new SuccessResponse(200, "Sucesso na requisição", "Dados do servidor obtidos com sucesso", null);
        return ResponseEntity.ok(successResponse); 
    }    
    
}