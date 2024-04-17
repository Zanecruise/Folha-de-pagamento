package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * faz um select de todos os empregadores e manda pro front
 * faz um select de todos os funcionarios relacionados ao id do empregador selecionado e manda pro front
 */
@Repository
public class FrontEndRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FrontEndRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> selectEmpregadores() {
        String sql = "SELECT id, nome FROM empregador";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> selectFuncionarios(int id_empregador) {
        String sql = "SELECT id, nome FROM funcionario WHERE id_empregador = ?";
        return jdbcTemplate.queryForList(sql, id_empregador);
    }
}
