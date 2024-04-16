package com.example.demo.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DescontosIRRFRepository {

    private static JdbcTemplate jdbcTemplate;

    public DescontosIRRFRepository(JdbcTemplate jdbcTemplate) {
        DescontosIRRFRepository.jdbcTemplate = jdbcTemplate;
    }

    public static double descontoTotal(int id) {
        String sqlDesconto = "SELECT a.desconto " +
                        "FROM adicionais a " +
                        "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                        "JOIN funcionario f ON f.id = a.id_funcionario " +
                        "WHERE a.descricao = 'DESCONTO JUDICIAL' AND a.id_folha_pagamento = ?";
        
        
        double descontoJudicial = jdbcTemplate.queryForObject(sqlDesconto, Double.class, id);
    
        
        String sqlINSS = "SELECT a.desconto " +
                            "FROM adicionais a " +
                            "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                            "JOIN funcionario f ON f.id = a.id_funcionario " +
                            "WHERE a.descricao = 'INSS' AND a.id_folha_pagamento = ?";

                            double descontoINSS = jdbcTemplate.queryForObject(sqlINSS, Double.class, id);
        
        
        String sqlValeTransporte = "SELECT a.desconto " +
                            "FROM adicionais a " +
                            "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                            "JOIN funcionario f ON f.id = a.id_funcionario " +
                            "WHERE a.descricao = 'VALE TRANSPORTE' AND a.id_folha_pagamento = ?";

        double descontoValeTransporte = jdbcTemplate.queryForObject(sqlValeTransporte, Double.class, id);

        double resultado = descontoJudicial + descontoINSS + descontoValeTransporte;

        return resultado;

    }
    
}
