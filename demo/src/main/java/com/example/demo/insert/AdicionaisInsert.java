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

    public void inserirFuncionario(String descricao, double referencia, double provento, double desconto) {
        // Defina sua consulta de inserção SQL com parâmetros
        String sql = "INSERT INTO adicionais (descricao, referencia, provento, desconto) VALUES (?, ?, ?, ?)";

        // Execute a consulta de inserção passando os valores dos parâmetros
        jdbcTemplate.update(sql, descricao, referencia, provento, desconto);
    }

}
