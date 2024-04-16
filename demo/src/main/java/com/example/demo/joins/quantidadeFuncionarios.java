package com.example.demo.joins;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class quantidadeFuncionarios {

    private static JdbcTemplate jdbcTemplate;

    public quantidadeFuncionarios(JdbcTemplate jdbcTemplate) {
        quantidadeFuncionarios.jdbcTemplate = jdbcTemplate;
    }

    public static int quantidadeFuncionariosEmpresa(int id) {
        String sql = "SELECT *, e.id AS empregador_id " +
                     "FROM funcionario f " +
                     "JOIN empregador e ON e.id = f.id_empregador " +
                     "WHERE e.id = ?";
        
        
        List<Map<String, Object>> registros = jdbcTemplate.queryForList(sql, id);
    
        
        String sqlContagem = "SELECT COUNT(*) AS total_registros " +
                             "FROM funcionario f " +
                             "JOIN empregador e ON e.id = f.id_empregador " +
                             "WHERE e.id = ?";
        int totalRegistros = jdbcTemplate.queryForObject(sqlContagem, Integer.class, id);
        
        
        return totalRegistros;
    }
    
}
