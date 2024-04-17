package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProventosFolhaRepository {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public ProventosFolhaRepository(JdbcTemplate jdbcTemplate) {
        ProventosFolhaRepository.jdbcTemplate = jdbcTemplate;
    }

    public static double somarProventoPorFolhaPagamento(int idFolhaPagamento) {
        String sql = "SELECT SUM(a.provento) FROM adicionais a WHERE a.id_folha_pagamento = ?";
        Double resultado = jdbcTemplate.queryForObject(sql, Double.class, idFolhaPagamento);
        return resultado != null ? resultado : 0.0; // Retorna 0.0 se o resultado for nulo
    }

}
