package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;

public class FuncionarioComissao implements InterfaceService{

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Comissao"))) {

            double referencia = 30; //30% = 0.3

            double valorVenda = gerarNumeroAleatorio(200, 500);

            double comissao = valorVenda * 0.3;

            comissao = arredondarParaDuasCasasDecimais(comissao);

            this.descricao = "COMISSAO";
            this.referencia = referencia;
            this.provento = comissao;
            this.desconto = 0.0;

            return comissao;

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

    public FuncionarioComissao(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioComissao() {

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
