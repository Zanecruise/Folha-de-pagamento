package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.example.demo.joins.QuantidadeFaltas;

public class FuncionarioAtrasos implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Faltas"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            int id_funcionario = (int) funcionario.get("id");

            int quantidade = QuantidadeFaltas.quantidadeFaltas(id_funcionario);


            double valorDia = salarioBase/30;

            double faltasDesconto = quantidade * valorDia;

            faltasDesconto = arredondarParaDuasCasasDecimais(faltasDesconto);

            this.descricao = "FALTAS";
            this.referencia = quantidade;
            this.provento = 0.0;
            this.desconto = faltasDesconto;

            return faltasDesconto;
        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioAtrasos(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioAtrasos() {
        
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
