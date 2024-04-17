package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FuncionarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> imprimirFuncionarioPorId(int id) {
        String sqlF = "SELECT * FROM funcionario WHERE id = ?";
                   
        Map<String, Object> funcionario = jdbcTemplate.queryForMap(sqlF, id);

        return(funcionario);
        
    }
}
