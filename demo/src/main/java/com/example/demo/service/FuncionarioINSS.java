package com.example.demo.service;

import java.util.Map;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class FuncionarioINSS implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("INSS"))) {
            double salario = (double) funcionario.get("salario_base");
            double faixaINSS;
    
            double inss = 0.0;
            double faixa1 = 1412.00;
            double faixa2 = 2666.68;
            double faixa3 = 4000.03;
            double faixa4 = 7786.02;
            
            // 1ª faixa salarial
            if (salario <= faixa1) {
                inss = salario * 0.075;
                faixaINSS = 7.5;

            } else {
                inss += faixa1 * 0.075;
                salario -= faixa1;
                faixaINSS = 7.5;
                
                // 2ª faixa salarial
                if (salario <= (faixa2 - faixa1)) {
                    inss += salario * 0.09;
                    faixaINSS = 9.0;

                } else {
                    inss += (faixa2 - faixa1) * 0.09;
                    salario -= (faixa2 - faixa1);
                    faixaINSS = 9.0;
                    
                    // 3ª faixa salarial
                    if (salario <= (faixa3 - faixa2)) {
                        inss += salario * 0.12;
                        faixaINSS = 12.0;

                    } else {
                        inss += (faixa3 - faixa2) * 0.12;
                        salario -= (faixa3 - faixa2);
                        faixaINSS = 12.0;
                        
                        // 4ª faixa salarial
                        if (salario <= (faixa4 - faixa3)) {
                            inss += salario * 0.14;
                            faixaINSS = 14.0;

                        } else {
                            // Salário ultrapassa o limite de benefício do INSS
                            inss += (faixa4 - faixa3) * 0.14;
                            salario -= (faixa4 - faixa3);
                            faixaINSS = 14.0;

                        }
                    }
                }
            }

            inss = arredondarParaDuasCasasDecimais(inss);

            this.descricao = "I.N.S.S";
            this.referencia = faixaINSS;
            this.provento = 0.0;
            this.desconto = inss;

            return inss;

        }
    
        return 0.0;
    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioINSS() {
        
    }
 
    public FuncionarioINSS(String descricao, double referencia, Double provento, double desconto) {
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
