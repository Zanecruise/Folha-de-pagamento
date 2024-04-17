package com.example.demo.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import org.springframework.dao.EmptyResultDataAccessException;


@Component
public class DescontosIRRFRepository {

    private static JdbcTemplate jdbcTemplate;

    public DescontosIRRFRepository(JdbcTemplate jdbcTemplate) {
        DescontosIRRFRepository.jdbcTemplate = jdbcTemplate;
    }

    public static double descontoTotal(int id) {

        try {
            // Consulta para desconto judicial
            String sqlDescontoJudicial = "SELECT a.desconto " +
                    "FROM adicionais a " +
                    "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                    "JOIN funcionario f ON f.id = a.id_funcionario " +
                    "WHERE a.descricao = 'DESCONTO JUDICIAL' AND a.id_folha_pagamento = ?";
            
            Double descontoJudicial = jdbcTemplate.queryForObject(sqlDescontoJudicial, Double.class, id);
    
            // Consulta para desconto INSS
            String sqlDescontoINSS = "SELECT a.desconto " +
                    "FROM adicionais a " +
                    "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                    "JOIN funcionario f ON f.id = a.id_funcionario " +
                    "WHERE a.descricao = 'I.N.S.S' AND a.id_folha_pagamento = ?";
            
            Double descontoINSS = jdbcTemplate.queryForObject(sqlDescontoINSS, Double.class, id);
    
            // Consulta para desconto de vale transporte
            String sqlDescontoValeTransporte = "SELECT a.desconto " +
                    "FROM adicionais a " +
                    "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                    "JOIN funcionario f ON f.id = a.id_funcionario " +
                    "WHERE a.descricao = 'VALE TRANSPORTE' AND a.id_folha_pagamento = ?";
            
            Double descontoValeTransporte = jdbcTemplate.queryForObject(sqlDescontoValeTransporte, Double.class, id);
    
            // Tratar o caso em que nenhuma linha é retornada por alguma consulta
            double resultado = (descontoJudicial != null ? descontoJudicial : 0.0) +
                               (descontoINSS != null ? descontoINSS : 0.0) +
                               (descontoValeTransporte != null ? descontoValeTransporte : 0.0);
    
            return resultado;
        } catch (EmptyResultDataAccessException e) {
            // Tratar o caso em que nenhuma linha é retornada por alguma consulta
            return 0.0;
        }

        String sqlDesconto = "SELECT a.desconto " +
                        "FROM adicionais a " +
                        "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                        "JOIN funcionario f ON f.id = a.id_funcionario " +
                        "WHERE a.descricao = 'DESCONTO JUDICIAL' AND a.id_folha_pagamento = ?";
        
        
                        Double descontoJudicial = jdbcTemplate.queryForObject(sqlDesconto, Double.class, id);
                        if (descontoJudicial == null) {
                            descontoJudicial = 0.0; // Defina um valor padrão se nenhum resultado for retornado
                        }
                        

    
        
        String sqlINSS = "SELECT a.desconto " +
                            "FROM adicionais a " +
                            "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                            "JOIN funcionario f ON f.id = a.id_funcionario " +
                            "WHERE a.descricao = 'INSS' AND a.id_folha_pagamento = ?";

                            Double descontoINSS = jdbcTemplate.queryForObject(sqlINSS, Double.class, id);
                            if (descontoINSS == null) {
                                descontoINSS = 0.0; // Defina um valor padrão se nenhum resultado for retornado
                            }

        
        
        String sqlValeTransporte = "SELECT a.desconto " +
                            "FROM adicionais a " +
                            "JOIN folha_de_pagamento fp ON fp.id = a.id_folha_pagamento " +
                            "JOIN funcionario f ON f.id = a.id_funcionario " +
                            "WHERE a.descricao = 'VALE TRANSPORTE' AND a.id_folha_pagamento = ?";

                            Double descontoValeTransporte = jdbcTemplate.queryForObject(sqlValeTransporte, Double.class, id);
                            if (descontoValeTransporte == null) {
                                descontoValeTransporte = 0.0; // Defina um valor padrão se nenhum resultado for retornado
                            }
                            

        double resultado = descontoJudicial + descontoINSS + descontoValeTransporte;

        return resultado;

    }
    
}
