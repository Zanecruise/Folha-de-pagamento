package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdicionaisRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdicionaisRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /* 
     * aqui faz um select da coluna DESCRIÇÃO da tabela ADICIONAIS, coloca em um vetor e manda pra preencher
     */
    public List<String> selectDescricao(int id) {
        FolhaDePagamentoRepository folhaDePagamentoRepository = new FolhaDePagamentoRepository(jdbcTemplate);
        int id_folha_pagamento = folhaDePagamentoRepository.selectFolhaDoFuncionario(id);
        // DESCRICAO
        String sql = "SELECT descricao FROM adicionais WHERE id_folha_pagamento = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id_folha_pagamento);
        List<String> descricaoAdicionais = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            descricaoAdicionais.add((String) row.get("descricao"));
        }

        return descricaoAdicionais;
    }

    /* 
     * aqui faz um select das colunas REFERENCIA, DESCONTOS E PROVENTOS, genericamente da tabela ADICIONAIS, coloca em um vetor e manda pra preencher
     */
    public double[] selectValoresAdicionais(int id, String coluna) {//
        FolhaDePagamentoRepository folhaDePagamentoRepository = new FolhaDePagamentoRepository(jdbcTemplate);
        int id_folha_pagamento = folhaDePagamentoRepository.selectFolhaDoFuncionario(id);
        String sql = "SELECT " + coluna + " FROM adicionais WHERE id_folha_pagamento = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id_folha_pagamento);
        double[] valores = new double[rows.size()];//
    
        for (int i = 0; i < rows.size(); i++) {
            Map<String, Object> row = rows.get(i);
            valores[i] = ((Number) row.get(coluna)).doubleValue(); //
        }
    
        return valores;
    }
    
    
}