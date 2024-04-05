package com.example.demo.service;

import java.util.Map;


public class funcionario_INSS {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    // Construtor
    public funcionario_INSS(String descricao, double referencia, Double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }



    // Método para calcular INSS e retornar um objeto FuncionarioINSS
    public static funcionario_INSS calcularINSS(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("INSS"))) {
            double salarioBase = (double) funcionario.get("salario_base");
            int faixaINSS;
            double valorINSS;
    
            if (salarioBase <= 1751.81) {
                faixaINSS = 8;
            } else if (salarioBase <= 2919.72) {
                faixaINSS = 9;
            } else {
                faixaINSS = 11;
            }
    
            switch (faixaINSS) {
                case 8:
                    valorINSS = salarioBase * 0.08;
                    break;
                case 9:
                    valorINSS = salarioBase * 0.09;
                    break;
                case 11:
                    valorINSS = salarioBase * 0.11;
                    break;
                default:
                    valorINSS = 642.34;
                    break;
            }
    

            return new funcionario_INSS("I.N.S.S", faixaINSS, 0.0, valorINSS);


        }
    
        return null; // Retorna null se o funcionário não estiver sujeito ao INSS
    }
    

    // Getters e Setters
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setReferencia(double referencia) {
        this.referencia = referencia;
    }

    public void setProvento(double provento) {
        this.provento = provento;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }


}
