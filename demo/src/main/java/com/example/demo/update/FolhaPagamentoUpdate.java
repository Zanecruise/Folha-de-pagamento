package com.example.demo.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FolhaPagamentoUpdate {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FolhaPagamentoUpdate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void atualizarFolhaDePagamento(double FGTSDoMes, double salarioBase, double baseCalculoINSS, 
                                           double baseCalculoFGTS, double baseCalculoIRRF, int faixaIRRF, 
                                           String dataFolha, double totalVencimento, double totalDesconto, 
                                           double totalLiquido, int idFolhaPagamento) {
        String sql = "UPDATE folha_de_pagamento f " +
                     "SET FGTS_do_mes = ?, " +
                     "    Salario_base = ?, " +
                     "    Base_calculo_INSS = ?, " +
                     "    Base_calculo_FGTS = ?, " +
                     "    Base_calculo_IRRF = ?, " +
                     "    Faixa_IRRF = ?, " +
                     "    Data_folha = ?, " +
                     "    Total_vencimento = ?, " +
                     "    Total_desconto = ?, " +
                     "    Total_liquido = ? " +
                     "WHERE f.id = ?";
        
        jdbcTemplate.update(sql, FGTSDoMes, salarioBase, baseCalculoINSS, baseCalculoFGTS, baseCalculoIRRF, 
                            faixaIRRF, dataFolha, totalVencimento, totalDesconto, totalLiquido, idFolhaPagamento);
    }

}
