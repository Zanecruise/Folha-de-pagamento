package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.FolhaDePagamentoRepository;

@Component
public class PuxaIdFolha {

    private final FolhaDePagamentoRepository folhaDePagamentoRepository;

    @Autowired
    public PuxaIdFolha(FolhaDePagamentoRepository folhaDePagamentoRepository) {
        this.folhaDePagamentoRepository = folhaDePagamentoRepository;
    }

    public int getIdDaFolha(int id_funcionario) {
        System.out.println("ID do funcionario AA " + id_funcionario);
        int idDaFolha = folhaDePagamentoRepository.selectFolhaDoFuncionario(id_funcionario);
        System.out.println("ID DA FOLHA 222: " + idDaFolha);
        return idDaFolha;
    }
}