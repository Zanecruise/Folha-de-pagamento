package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class ClasseBase implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Adiantamento"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            double referencia = 0.1; // = 10%

            // 10% de adiantamento no MAX
            double Adiantamento = salarioBase * referencia;

            Adiantamento = arredondarParaDuasCasasDecimais(Adiantamento);

            this.descricao = "ADIANTAMENTO";
            this.referencia = 10;
            this.provento = Adiantamento;
            this.desconto = 0.0;

            return Adiantamento;
        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public ClasseBase(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public ClasseBase() {
        
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
