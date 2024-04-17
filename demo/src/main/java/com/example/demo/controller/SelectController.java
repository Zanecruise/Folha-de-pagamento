package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.FrontEndRepository;

import java.util.List;
import java.util.Map;

/*
 * Essa controller insere nas tags html <selct> os nomes dos empregaores e dos funcionarios 
 */
@RestController
@RequestMapping("/edit")
public class SelectController {

    @Autowired
    private FrontEndRepository frontEndRepository;

    @GetMapping("/empregador/list")
    public List<Map<String, Object>> getEmpregadores() {
        return frontEndRepository.selectEmpregadores();
    }

    @GetMapping("/funcionario/list/{id_empregador}")
    public List<Map<String, Object>> getFuncionarios(@PathVariable int id_empregador) {
        return frontEndRepository.selectFuncionarios(id_empregador);
    }

}
