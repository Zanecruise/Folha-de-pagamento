package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.output.FolhaDePagamento;

/*
 * Essa classe pega o id do funcionario do html
 */
@RestController
public class IntermedioController {

    @Autowired
    private FolhaDePagamento folhaDePagamento;

    @PostMapping("/final/emitir-folha/{id_funcionario}")
    public void intermedEmitirFolha(@PathVariable int id_funcionario) {
        //pega o id o funcionario e faz aqui os chamados dos metodos
        // bla bla bla
        // bla bla lba
        folhaDePagamento.emitirFolha(id_funcionario); //Classe principal para preencher o excel apos o banco estar todo preenchido
    }

}
