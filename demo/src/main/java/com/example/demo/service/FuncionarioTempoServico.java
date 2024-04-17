package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.sql.Date;

public class FuncionarioTempoServico implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Adicional_Tempo_Servico"))) {
            double salarioBase = (double) funcionario.get("salario_base");

            Date admissaoDoBanco = (Date) funcionario.get("admissao");

            LocalDate admissao = admissaoDoBanco.toLocalDate();

            LocalDate dataEspecifica = LocalDate.now();


            long diffInDays = ChronoUnit.DAYS.between(admissao, dataEspecifica);

            long anos = diffInDays / 365; 

            long quinquenio = anos/5;

            double Adicional = ( salarioBase * 0.05 ) * quinquenio;


            Adicional = arredondarParaDuasCasasDecimais(Adicional);

            this.descricao = "ADICIONAL TEMPO SERVICO";
            this.referencia = quinquenio;
            this.provento = Adicional;
            this.desconto = 0.0;

            return Adicional;
        }
    
        return 0.0; 

    }

    @Override
    public double arredondarParaDuasCasasDecimais(double valor) {
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        valorBigDecimal = valorBigDecimal.setScale(2, RoundingMode.HALF_UP);
        return valorBigDecimal.doubleValue();
    }

    public FuncionarioTempoServico(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioTempoServico() {
        
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
