package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class FuncionarioDSR implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("DSR"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            double referencia = 4; // dias de descanso no mês

            //DSR = (salário recebido * número de descanso no mês) / dias úteis do mês
            double DSR = (salarioBase * referencia) / 22; 
            


            DSR = arredondarParaDuasCasasDecimais(DSR);

            this.descricao = "DSR";
            this.referencia = referencia;
            this.provento = DSR;
            this.desconto = 0.0;

            return DSR;
        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioDSR(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioDSR() {
        
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
