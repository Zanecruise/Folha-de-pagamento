package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 * faz um select dos atributos que serão inseridos na parte INFERIOR da folha
 */
@Repository
public class AtributosFolhaRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AtributosFolhaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> selectAtributosFolha(int id) {
        String sql = "SELECT *, CONCAT('R$', total_vencimento) AS total_vencimento, " +
                "CONCAT('R$', total_desconto) AS total_desconto, " +
                "CONCAT('R$', total_liquido) AS total_liquido " +
                "FROM folha_de_pagamento WHERE id = ?";

        Map<String, Object> atributosFolha = jdbcTemplate.queryForMap(sql, id);

        return (atributosFolha);
    }
}
