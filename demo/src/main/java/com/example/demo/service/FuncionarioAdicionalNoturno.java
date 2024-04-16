package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.example.demo.repository.BancoDeHorasRepository;

public class FuncionarioAdicionalNoturno implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {

        if (Boolean.TRUE.equals(beneficios.get("Adicional_noturno"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            Map<String, Object> bancoMap = BancoDeHorasRepository.imprimirBancoHoras((int) beneficios.get("id"));

            double horasTotais = (double) bancoMap.get("horas_totais");
            double horasNoturno = (double) bancoMap.get("Horas_noturno");


            double salarioHora = salarioBase / horasTotais;


            if (horasNoturno > 0) {

                double adicional = salarioHora * 1.2;
                double adicionalNoturno = horasNoturno * adicional;

                adicionalNoturno = arredondarParaDuasCasasDecimais(adicionalNoturno);
                this.descricao = "ADICIONAL NOTURNO";
                this.referencia = horasNoturno;
                this.provento = adicionalNoturno;
                this.desconto = 0.0;

                return adicionalNoturno;

                
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

    public FuncionarioAdicionalNoturno(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioAdicionalNoturno() {
        
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
