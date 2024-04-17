package com.example.demo.repository;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioMAPRepository {

    private static JdbcTemplate jdbcTemplate;

    public FuncionarioMAPRepository(JdbcTemplate jdbcTemplate) {
        FuncionarioMAPRepository.jdbcTemplate = jdbcTemplate;
    }

    public static Map<String, Object> imprimirFuncionarioPorId(int id) {
        String sqlF = "SELECT f.categoria " +
                        "FROM funcionario f " +
                        "WHERE f.id = ?; ";
        
        
                   
        Map<String, Object> funcionario = jdbcTemplate.queryForMap(sqlF, id);

        return(funcionario);
        
    }
}
