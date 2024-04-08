package com.example.demo.joins;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BeneficiariosLEFT {

    private static JdbcTemplate jdbcTemplate;

    public BeneficiariosLEFT(JdbcTemplate jdbcTemplate) {
        BeneficiariosLEFT.jdbcTemplate = jdbcTemplate;
    }

    public static int imprimirBeneficiariosPorId(int id) {
        // Consulta para obter a quantidade de filhos menores de 14 anos do funcionário com o ID fornecido
        
        String sql = "SELECT " +
                     "COUNT(CASE WHEN DATEDIFF(CURRENT_DATE(), c.dataNascimento) / 365 < 14 THEN 1 ELSE NULL END) " +
                     "FROM funcionario f " +
                     "LEFT JOIN beneficiario c ON f.id = c.id_funcionario " +
                     "WHERE f.id = ? ";
    
        // Executa a consulta SQL e obtém o resultado
        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }
}
