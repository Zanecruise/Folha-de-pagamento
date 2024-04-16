package com.example.demo.joins;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BeneficiariosAuxilioCreche {

    private static JdbcTemplate jdbcTemplate;

    public BeneficiariosAuxilioCreche(JdbcTemplate jdbcTemplate) {
        BeneficiariosAuxilioCreche.jdbcTemplate = jdbcTemplate;
    }

    public static int imprimirBeneficiariosPorId(int id) {
        
        String sql = "SELECT " +
                     "COUNT(CASE WHEN DATEDIFF(CURRENT_DATE(), c.dataNascimento) < 6 * 30 THEN 1 ELSE NULL END) " +
                     "FROM funcionario f " +
                     "LEFT JOIN beneficiario c ON f.id = c.id_funcionario " +
                     "WHERE f.id = ? ";
    
        
        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }
}
