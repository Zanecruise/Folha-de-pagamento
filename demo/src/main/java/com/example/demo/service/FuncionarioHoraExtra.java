package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.example.demo.repository.BancoDeHorasRepository;

public class FuncionarioHoraExtra implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {

        if (Boolean.TRUE.equals(beneficios.get("Hora_Extra"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            Map<String, Object> bancoMap = BancoDeHorasRepository.imprimirBancoHoras((int) funcionario.get("id"));

            double horasTotais = (double) bancoMap.get("horas_totais");
            double horas50 = (double) bancoMap.get("horas_extras_50%");
            double horas100 = (double) bancoMap.get("horas_extras_100%");

            double salarioHora = salarioBase / horasTotais;

            double horaExtraTotal = 0;

            if (horas50 > 0) {

                double horaExtra50 = salarioHora * 1.5;
                horaExtraTotal = horas50 * horaExtra50;
                
            }
            if (horas100 > 0) {

                double horaExtra100 = salarioHora * 1.5;
                horaExtraTotal += horas100 * horaExtra100;
                
            }

            double referencia = horas50 + horas100;

            horaExtraTotal = arredondarParaDuasCasasDecimais(horaExtraTotal);

            this.descricao = "HORA EXTRA";
            this.referencia = referencia;
            this.provento = horaExtraTotal;
            this.desconto = 0.0;

            return horaExtraTotal;
        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioHoraExtra(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioHoraExtra() {
        
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
