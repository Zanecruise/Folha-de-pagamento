package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.output.FolhaDePagamento;

/*
 * tentei fazer um texto de confirmação mas n funcionou aparentemente
 */
@RestController
public class ConfirmController {
    @Autowired
    private FolhaDePagamento folhaDePagamento;

    @GetMapping("/confirm")
    public boolean confirmarEmissao() {
        return folhaDePagamento != null && folhaDePagamento.isFolhaEmitida();

    }

}
