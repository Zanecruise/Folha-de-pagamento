package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class FuncionarioFGTS implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {

        if (Boolean.TRUE.equals(beneficios.get("FGTS"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            double referencia = 0.08; // 8%

            double FGTS = salarioBase * referencia;

            FGTS = arredondarParaDuasCasasDecimais(FGTS);

            this.descricao = "F.G.T.S";
            this.referencia = 8;
            this.provento = 0.0;
            this.desconto = FGTS;

            return FGTS;
            
        } else {

            return 0.0; 

        }
    
        
    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioFGTS() {
        
    }

    public FuncionarioFGTS(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
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
