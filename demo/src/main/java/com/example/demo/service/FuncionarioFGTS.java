package com.example.demo.service;

import java.util.Map;

public class FuncionarioFGTS {

    private String descricao;
    private double desconto;

    public static FuncionarioFGTS calcularFGTS(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("FGTS"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            double FGTS = salarioBase * 0.08;

            return new FuncionarioFGTS("F.G.T.S", FGTS);


        }
    
        return null;
    }

    public FuncionarioFGTS(String descricao, double desconto) {
        this.descricao = descricao;
        this.desconto = desconto;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getDesconto() {
        return desconto;
    }

}
