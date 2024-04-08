package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.example.demo.joins.BeneficiariosLEFT;

public class FuncionarioSalarioFamilia implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {

        if (Boolean.TRUE.equals(beneficios.get("Salario_Familia"))) {

            double salarioBase = (double) funcionario.get("salario_base");
            int id_funcionario = (int) funcionario.get("id");

            if (salarioBase < 1819.26) {

                int beneficiarios = BeneficiariosLEFT.imprimirBeneficiariosPorId(id_funcionario);


                //imprimirBeneficiariosPorId
                //Valor ganho por filho : 62,04
                //Salário-Família: Quantidade de filhos * 62,04 = Valor ganho
                //Salário-Família: 3 * 62,04 = R$186,12

                double Salario_Familia = beneficiarios * 62.04;

                Salario_Familia = arredondarParaDuasCasasDecimais(Salario_Familia);

                this.descricao = "SALARIO FAMILIA";
                this.referencia = beneficiarios;
                this.provento = Salario_Familia;
                this.desconto = 0.0;

                return Salario_Familia;


                
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

    public FuncionarioSalarioFamilia(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioSalarioFamilia() {
        
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
