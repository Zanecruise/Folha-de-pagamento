package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DescontosFolhaRepository {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public DescontosFolhaRepository(JdbcTemplate jdbcTemplate) {
        DescontosFolhaRepository.jdbcTemplate = jdbcTemplate;
    }

    public static double somarDescontosPorFolhaPagamento(int idFolhaPagamento) {
        String sql = "SELECT SUM(a.desconto) AS total_desconto " +
                    "FROM adicionais a " +
                    "WHERE a.id_folha_pagamento = ?; ";
        
        Double resultado = jdbcTemplate.queryForObject(sql, Double.class, idFolhaPagamento);
        return resultado != null ? resultado : 0.0; // Retorna 0.0 se o resultado for nulo
    }

}
