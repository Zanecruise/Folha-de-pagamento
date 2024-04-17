package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BeneficiosRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BeneficiosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> imprimirBeneficiosPorId(int id) {
        String sqlF = "SELECT bf.* " +
                        "FROM beneficios_fixos bf " + 
                        "JOIN funcionario f ON f.id = bf.id " + 
                        "WHERE f.id = ? ";

        Map<String, Object> beneficios_fixos = jdbcTemplate.queryForMap(sqlF, id);

        return(beneficios_fixos);
        
    }
}
