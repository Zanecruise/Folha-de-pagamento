package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BancoDeHorasRepository {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public BancoDeHorasRepository(JdbcTemplate jdbcTemplate) {
        BancoDeHorasRepository.jdbcTemplate = jdbcTemplate;
    }

    public static Map<String, Object> imprimirBancoHoras(int id) {
        String sqlF = "SELECT b.* " +
                        "FROM beneficios_fixos bf " +
                        "JOIN banco_de_horas b ON bf.id_banco_de_horas = b.id " +
                        "WHERE bf.id = ? ";

        Map<String, Object> banco_de_horasMap = jdbcTemplate.queryForMap(sqlF, id);

        return(banco_de_horasMap);
        
    }
}
