package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.example.demo.repository.AtrasosRepository;
import com.example.demo.repository.BancoDeHorasRepository;

public class FuncionarioAtrasos implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Atrasos"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            int id_beneficios_fixos = (int) beneficios.get("id");

            int quantidadeAtrasos = AtrasosRepository.quantidadeAtrasos(id_beneficios_fixos);

            Map<String, Object> bancoMap = BancoDeHorasRepository.imprimirBancoHoras((int) beneficios.get("id"));

            double horasTotais = (double) bancoMap.get("horas_totais");

            double salarioHora = salarioBase / horasTotais;


            double atrasos = salarioHora * quantidadeAtrasos;

            atrasos = arredondarParaDuasCasasDecimais(atrasos);


            this.descricao = "ATRASOS";

            this.descricao = "FALTAS";

            this.referencia = quantidadeAtrasos;
            this.provento = 0.0;
            this.desconto = atrasos;

            return atrasos;
        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioAtrasos(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioAtrasos() {
        
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
