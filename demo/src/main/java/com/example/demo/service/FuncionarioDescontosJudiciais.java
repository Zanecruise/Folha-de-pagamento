package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;

public class FuncionarioDescontosJudiciais implements InterfaceService{

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Descontos_Judiciais"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            double maximo = salarioBase * 0.3;

            double desconto = gerarNumeroAleatorio(50, maximo);

            desconto = arredondarParaDuasCasasDecimais(desconto);


            this.descricao = "DESCONTO JUDICIAL";
            this.referencia = 0.0;
            this.provento = 0.0;
            this.desconto = desconto;

            return desconto;

        }
    
        return 0.0;
    }

    public double gerarNumeroAleatorio(double min, double max) {

        Random random = new Random();
        return random.nextDouble((max - min) + 1) + min;
    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
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

}
