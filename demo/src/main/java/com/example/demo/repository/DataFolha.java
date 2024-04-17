package com.example.demo.repository;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// classe para converter a data da volha no modelo: MES 0000 -> ex: JANEIRO 2024
@Repository
public class DataFolha {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataFolha(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
     * Faz um select da DATA na folha de pagamento e converte no formato MÊS 0000, Ex: JANEIRO 2024
     */
    public String dataFormat(Integer id) {
        try {
            FolhaDePagamentoRepository folhaDePagamentoRepository = new FolhaDePagamentoRepository(jdbcTemplate);
            int id_folha_pagamento = folhaDePagamentoRepository.selectFolhaDoFuncionario(id);
            String sql = "SELECT Data_folha FROM folha_de_pagamento WHERE id = ?;";
            Map<String, Object> dataFolha = jdbcTemplate.queryForMap(sql, id_folha_pagamento);

            java.sql.Date date = (java.sql.Date) dataFolha.get("Data_folha");
            String dataString = date.toString();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date utilDate = dateFormat.parse(dataString);

            Calendar cal = Calendar.getInstance();
            cal.setTime(utilDate);

            int numeroMes = cal.get(Calendar.MONTH) + 1;

            Map<Integer, String> meses = new HashMap<>();
            meses.put(1, "JANEIRO");
            meses.put(2, "FEVEREIRO");
            meses.put(3, "MARÇO");
            meses.put(4, "ABRIL");
            meses.put(5, "MAIO");
            meses.put(6, "JUNHO");
            meses.put(7, "JULHO");
            meses.put(8, "AGOSTO");
            meses.put(9, "SETEMBRO");
            meses.put(10, "OUTUBRO");
            meses.put(11, "NOVEMBRO");
            meses.put(12, "DEZEMBRO");

            String mesPorExtenso = meses.get(numeroMes); 

            int ano = cal.get(Calendar.YEAR);

            String mesAnoPorExtenso = mesPorExtenso + " " + ano;

            return mesAnoPorExtenso;
        } catch (java.text.ParseException e) {        
            e.printStackTrace(); 
            return null; 
        }
    }

}
