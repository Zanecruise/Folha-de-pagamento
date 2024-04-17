package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class FuncionarioValeTransporte implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Vale_Transporte"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            int diasUteis = 19; // mes de abril tem 19 dias uteis
            int quantidadePassagens = 2;
            int valorPassagem = 4;


            double valeTransporte = valorPassagem * diasUteis * quantidadePassagens;

            double porcentagemSalario = salarioBase * 0.06;

            if (valeTransporte <= porcentagemSalario) {

                valeTransporte = arredondarParaDuasCasasDecimais(valeTransporte);

                this.descricao = "VALE TRANSPORTE";
                this.referencia = valorPassagem;
                this.provento = valeTransporte;
                this.desconto = valeTransporte;

                return valeTransporte;
                
            } else {

                valeTransporte = arredondarParaDuasCasasDecimais(valeTransporte);

                this.descricao = "VALE TRANSPORTE";
                this.referencia = valorPassagem;
                this.provento = valeTransporte;
                this.desconto = porcentagemSalario;

                return valeTransporte;
                
            }

        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioValeTransporte(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioValeTransporte() {
        
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
