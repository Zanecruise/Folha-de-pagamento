package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AtrasosRepository {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public AtrasosRepository(JdbcTemplate jdbcTemplate) {
        AtrasosRepository.jdbcTemplate = jdbcTemplate;
    }

    public static int quantidadeAtrasos(int id) {
        
        String sql = "SELECT SUM(a.atraso) AS soma_total " + 
                        "FROM atrasos a " +
                        "JOIN beneficios_fixos bf ON a.id_beneficios_fixos = bf.id " +
                        "WHERE bf.id = ? ";
        

        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }
}
