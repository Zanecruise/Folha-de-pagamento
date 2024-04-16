package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;

public class FuncionarioInsalubridade implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Insalubridade"))) {

            if (Boolean.FALSE.equals(beneficios.get("Periculosidade"))){ 

                double salarioBase = (double) funcionario.get("salario_base");

                int opcao = gerarNumeroAleatorio(1, 3);

                double insalubridade;
                double referencia;

                switch (opcao) {
                    case 1: // 10%
                        
                        insalubridade = salarioBase * 0.1;
                        referencia = 10;
                        insalubridade = arredondarParaDuasCasasDecimais(insalubridade);

                        this.descricao = "INSALUBRIDADE";
                        this.referencia = referencia;
                        this.provento = insalubridade;
                        this.desconto = 0.0;

                        return insalubridade;

                    case 2: // 20%

                        insalubridade = salarioBase * 0.2;
                        referencia = 20;
                        insalubridade = arredondarParaDuasCasasDecimais(insalubridade);
                        
                        this.descricao = "INSALUBRIDADE";
                        this.referencia = referencia;
                        this.provento = insalubridade;
                        this.desconto = 0.0;

                        return insalubridade;

                    case 3: // 40%

                        insalubridade = salarioBase * 0.4;
                        referencia = 40;
                        insalubridade = arredondarParaDuasCasasDecimais(insalubridade);

                        this.descricao = "INSALUBRIDADE";
                        this.referencia = referencia;
                        this.provento = insalubridade;
                        this.desconto = 0.0;

                        return insalubridade;
                        
                
                    default:
                        break;
                }

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

    public int gerarNumeroAleatorio(int min, int max) {

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public FuncionarioInsalubridade(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioInsalubridade() {
        
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
