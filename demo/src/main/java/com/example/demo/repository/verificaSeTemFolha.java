package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class verificaSeTemFolha {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public verificaSeTemFolha(JdbcTemplate jdbcTemplate) {
        verificaSeTemFolha.jdbcTemplate = jdbcTemplate;
    }

    public static int quantidadeFolha(int id) {
        
        String sql = "SELECT f.FGTS_do_mes " +
                        "FROM folha_de_pagamento f " +
                        "WHERE f.id = ?; ";
        
                        Double resultado = jdbcTemplate.queryForObject(sql, Double.class, id);
                        System.out.println(resultado);

                        if (resultado == 0.0) {
                            // Faça algo se o resultado não for nulo, por exemplo, retornar 1
                            return 1;
                        } else {
                            // Faça algo se o resultado for nulo, por exemplo, retornar 0
                            return 0;
                        }
        

      

    }
}
