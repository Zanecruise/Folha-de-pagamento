package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Map; 

@Repository
public class EnderecoToString {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EnderecoToString(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /*
     * faz um Select de todos os atributos do endereço e junta tudo em uma string
     */
    public String ederecoToString(Integer id) {
        String sql = "SELECT * FROM endereço WHERE id = ?;";
        Map<String, Object> enderecoSelect = jdbcTemplate.queryForMap(sql, id);
        String ederecoString = (String) enderecoSelect.get("rua")+", "+ enderecoSelect.get("numero")+", "+enderecoSelect.get("cidade")+ " | "+enderecoSelect.get("estado");
        return (ederecoString);
    }
}
