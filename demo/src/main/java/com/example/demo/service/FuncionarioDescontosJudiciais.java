package com.example.demo.service;

import java.util.Map;

public class FuncionarioDescontosJudiciais implements InterfaceService{

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Descontos_Judiciais"))) {

            double desconto = 100;

            this.descricao = "DESCONTO JUDICIAL";
            this.referencia = 0.0;
            this.provento = 0.0;
            this.desconto = desconto;

            return desconto;

        }
    
        return 0.0;
    }

    public FuncionarioDescontosJudiciais(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioDescontosJudiciais() {

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

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        
        throw new UnsupportedOperationException("Unimplemented method 'arredondarParaDuasCasasDecimais'");
    }

}
