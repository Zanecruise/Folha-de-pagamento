package com.example.demo.insert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdicionaisInsert {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdicionaisInsert(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void inserirAdiantamento(String descricao, double referencia, double provento, double desconto, int id_funcionario, int id_folha_pagamento) {
        
        String sql = "INSERT INTO adicionais (descricao, referencia, provento, desconto, id_funcionario, id_folha_pagamento) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, descricao, referencia, provento, desconto, id_funcionario, id_folha_pagamento);
    }

}
