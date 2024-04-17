package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.example.demo.joins.QuantidadeFaltas;

public class FuncionarioValeAlimentacao implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Vale_Alimentacao"))) {
            
            int id_beneficios_fixos = (int) beneficios.get("id");

            int quantidade = QuantidadeFaltas.quantidadeFaltas(id_beneficios_fixos);

            double diasTrabalhados  = 19 - quantidade; // 19 dias uteis abril

            double valorDiaVale = 20;

            // TOTAL DIAS UTEIS - FALTAS // 19 - FALTAS
            double valorTotalVale = valorDiaVale * diasTrabalhados;

            double descontoVale = (valorTotalVale * 0.1); // Desconto de 10%

            double valeAlimentacao = valorTotalVale - descontoVale;


            valeAlimentacao = arredondarParaDuasCasasDecimais(valeAlimentacao);

            this.descricao = "VALE ALIMENTACAO";
            this.referencia = valorDiaVale;
            this.provento = valeAlimentacao;
            this.desconto = descontoVale;

            return valeAlimentacao;
        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioValeAlimentacao(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioValeAlimentacao() {
        
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
