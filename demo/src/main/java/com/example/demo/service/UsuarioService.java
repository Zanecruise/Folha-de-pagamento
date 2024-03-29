package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void imprimirFuncionarioPorId(long id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        Map<String, Object> funcionario = jdbcTemplate.queryForMap(sql, id);
        System.out.println("Funcionario encontrado: " + funcionario);
    }
    

}
