package com.example.demo.joins;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class QuantidadeFaltas {

    private static JdbcTemplate jdbcTemplate;

    public QuantidadeFaltas(JdbcTemplate jdbcTemplate) {
        QuantidadeFaltas.jdbcTemplate = jdbcTemplate;
    }

    public static int quantidadeFaltas(int id) {
        
        String sql = "SELECT COUNT(*) AS total_registros " +
                        "FROM dias_faltados df " + 
                        "JOIN beneficios_fixos bf ON df.id_beneficios_fixos = bf.id " +
                        "WHERE bf.id = ? ";

        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }
}
