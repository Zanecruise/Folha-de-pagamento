package com.example.demo.service;

import java.util.Map;

public class FuncionarioAdiantamento {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    public static FuncionarioAdiantamento calcularFGTS(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Adiantamento"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            double referencia = 0.1; // = 10%

            // 10% de adiantamento no MAX
            double Adiantamento = salarioBase * referencia;


            return new FuncionarioAdiantamento("ADIANTAMENTO", 10, Adiantamento, 0.0);


        }
    
        return null;
    }

    public FuncionarioAdiantamento(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getReferencia() {
        return referencia;
    }

    public double getProvento() {
        return provento;
    }

    public double getDesconto() {
        return desconto;
    }

}
