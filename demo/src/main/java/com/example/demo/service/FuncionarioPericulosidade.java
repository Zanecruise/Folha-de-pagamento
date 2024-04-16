package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class FuncionarioPericulosidade implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Periculosidade"))) {

            if (Boolean.FALSE.equals(beneficios.get("Insalubridade"))){ 

                double salarioBase = (double) funcionario.get("salario_base");

                double referencia = 0.3; // = 30%

                //Periculosidade: Salário * 0.3 = Valor da porcentagem de periculosidade
                //Periculosidade: R$ 2.500 * 0,3 = R$ 750

                double Periculosidade = salarioBase * referencia;


                Periculosidade = arredondarParaDuasCasasDecimais(Periculosidade);

                this.descricao = "PERICULOSIDADE";
                this.referencia = 30;
                this.provento = Periculosidade;
                this.desconto = 0.0;

                return Periculosidade;

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

    public FuncionarioPericulosidade(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioPericulosidade() {
        
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
