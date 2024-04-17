package com.example.demo.joins;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioEmpregadorJoin implements InterfaceJoin {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FuncionarioEmpregadorJoin(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
     * Essa classe faz um join de toda a parte superior da tabela
     */
    @Override
    public Map<String, Object> join(int id_funcionario) {
        ///// TRANSFORMAR ENDEREÇO EMPRESA PARA TOSTRING
        // FORMATAR O ATRIBUTO DATAFOLHA ABRIL 2024
        String sql = "SELECT " +
                "f.id_empregador AS id_empregador, " +
                "    e.nome AS nome_empregador, " +
                "    e.cnpj, " +
                "    f.id AS id_funcionario, " +
                "    f.nome AS nome_funcionario, " +
                "    f.cbo, " +
                "    CONCAT('R$ ', f.salario_base) AS salario_base, " +
                "    f.genero, " +
                "    f.cargo, " +
                "    f.admissao, " +
                "    f.funcao, " +
                "    b.Salario_Familia " +
                "FROM " +
                "    empregador AS e " +
                "INNER JOIN " +
                "    funcionario AS f ON f.id_empregador = e.id " +
                "INNER JOIN " +
                "    beneficios_fixos AS b ON b.id = f.id " +
                "WHERE " +
                "    f.id = ?;";

        Map<String, Object> joinFuncionarioEmpregador = jdbcTemplate.queryForMap(sql, id_funcionario);

        return joinFuncionarioEmpregador;
    }
}
