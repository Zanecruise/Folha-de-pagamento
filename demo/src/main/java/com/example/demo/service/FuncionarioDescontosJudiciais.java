package com.example.demo.service;

import java.util.Map;

public class FuncionarioDescontosJudiciais {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    public static FuncionarioDescontosJudiciais calcularDescontosJudiciais(Map<String, Object> beneficios) {
        if (Boolean.TRUE.equals(beneficios.get("Adiantamento"))) {

            double desconto = 100;


            return new FuncionarioDescontosJudiciais("DESCONTO JUDICIAL", 0, 0, desconto);


        }
    
        return null;
    }

    public FuncionarioDescontosJudiciais(String descricao, double referencia, double provento, double desconto) {
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
