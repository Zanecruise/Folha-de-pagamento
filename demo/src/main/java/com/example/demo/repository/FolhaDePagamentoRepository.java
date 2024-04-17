package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FolhaDePagamentoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FolhaDePagamentoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /*
     * Pega o id do funcionario e verifica qual é a ULTIMA folha emitida no nome dele, e retorna esse id especifico
     */
    public int selectFolhaDoFuncionario(int id_funcionario) {
        String sql = "SELECT id FROM folha_de_pagamento WHERE id_funcionario = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id_funcionario);

        Map<String, Object> lastRow = rows.get(rows.size() - 1); 
        Object idObject = lastRow.get("id");


        return (int) idObject;
    }
}
