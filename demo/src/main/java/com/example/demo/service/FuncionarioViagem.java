package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;

public class FuncionarioViagem implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Diaria_Viagem"))) {
            //double salarioBase = (double) funcionario.get("salario_base");

            double Diaria = gerarNumeroAleatorio(200, 500);

            Diaria = arredondarParaDuasCasasDecimais(Diaria);

            this.descricao = "DIARIA VIAGEM";
            this.referencia = 0.0;
            this.provento = Diaria;
            this.desconto = 0.0;

            return Diaria;
        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public double gerarNumeroAleatorio(double min, double max) {

        Random random = new Random();
        return random.nextDouble((max - min) + 1) + min;
    }


    public FuncionarioViagem(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioViagem() {
        
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

