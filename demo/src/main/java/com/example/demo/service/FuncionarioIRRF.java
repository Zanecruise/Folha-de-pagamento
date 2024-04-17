package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.example.demo.repository.DescontosIRRFRepository;

public class FuncionarioIRRF {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario, int id_folha_pagamento) {
        if (Boolean.TRUE.equals(beneficios.get("IRRF"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            double descontos = DescontosIRRFRepository.descontoTotal(id_folha_pagamento); // COLOCAR O ID DA FOLHA

            // Salário líquido é o salário base menos os descontos
            double salarioLiquido = salarioBase - descontos;

            // Defina as faixas e alíquotas de acordo com a tabela do IRRF
            // Esses valores devem ser atualizados de acordo com a tabela vigente
            double faixa1 = 1903.98; // Faixa de isenção
            double faixa2 = 2826.65;
            double faixa3 = 3751.05;
            double faixa4 = 4664.68;
            double faixa5 = 5595.80;

        
            double aliquota2 = 0.075;
            double aliquota3 = 0.15;
            double aliquota4 = 0.225;
            double aliquota5 = 0.275;

            // Calcula o imposto de acordo com a faixa de renda
            double imposto = 0.0;
            double faixa;

            if (salarioLiquido <= faixa1) {
                imposto = 0.0; // Isento
                faixa = 1;
            } else if (salarioLiquido <= faixa2) {
                imposto = (salarioLiquido - faixa1) * aliquota2;
                faixa = 2;
            } else if (salarioLiquido <= faixa3) {
                imposto = (salarioLiquido - faixa2) * aliquota3 + (faixa2 - faixa1) * aliquota2;
                faixa = 3;
            } else if (salarioLiquido <= faixa4) {
                imposto = (salarioLiquido - faixa3) * aliquota4 + (faixa3 - faixa2) * aliquota3 + (faixa2 - faixa1) * aliquota2;
                faixa = 4;
            } else {
                imposto = (salarioLiquido - faixa4) * aliquota5 + (faixa4 - faixa3) * aliquota4 + (faixa3 - faixa2) * aliquota3 + (faixa2 - faixa1) * aliquota2;
                faixa = 5;
            }

            imposto = arredondarParaDuasCasasDecimais(imposto);

            this.descricao = "IRRF";
            this.referencia = faixa;
            this.provento = 0.0;
            this.desconto = imposto;

            
            System.out.println("CALCULOU IR");
            return imposto;

           
        }
        System.out.println("NAO CALCULOU IR");
        return 0.0; 
        

    }

    
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioIRRF(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioIRRF() {
        
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
