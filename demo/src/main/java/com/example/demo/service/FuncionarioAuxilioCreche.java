package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.sql.Date;
import java.util.Map;

import com.example.demo.joins.BeneficiariosAuxilioCreche;
import com.example.demo.joins.quantidadeFuncionarios;


public class FuncionarioAuxilioCreche implements InterfaceService {

    private String descricao;
    private double referencia;
    private double provento;
    private double desconto;

    @Override
    public double calcularBeneficio(Map<String, Object> beneficios, Map<String, Object> funcionario) {
        if (Boolean.TRUE.equals(beneficios.get("Auxilio_creche"))) {

            Date dataNascimento = (Date) funcionario.get("data_nascimento");
            Instant instant = dataNascimento.toInstant();
            ZonedDateTime dataNascimentoZoned = instant.atZone(ZoneId.systemDefault());
            LocalDate dataNascimentoLocalDate = dataNascimentoZoned.toLocalDate();

            LocalDate dataAtual = LocalDate.now();

            long idadeEmAnos = ChronoUnit.YEARS.between(dataNascimentoLocalDate, dataAtual);


            if (idadeEmAnos > 16) {


            double salarioBase = (double) funcionario.get("salario_base");
            int id_funcionario = (int) funcionario.get("id");
            int id_empregador = (int) funcionario.get("id_empregador");

            int quantidade = quantidadeFuncionarios.quantidadeFuncionariosEmpresa(id_empregador);

                if (quantidade > 30) {

                    int beneficiarios = BeneficiariosAuxilioCreche.imprimirBeneficiariosPorId(id_funcionario);

                    double resultado = beneficiarios * 0.05;

                    if (resultado > 0.3) {

                        resultado = 0.3;
                        
                    }

                    double auxilio = salarioBase * resultado;


                    auxilio = arredondarParaDuasCasasDecimais(auxilio);

                    this.descricao = "AUXILIO CRECHE";
                    this.referencia = beneficiarios;
                    this.provento = auxilio;
                    this.desconto = 0.0;

                    return auxilio;


                    
                }
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

    public FuncionarioAuxilioCreche(String descricao, double referencia, double provento, double desconto) {
        this.descricao = descricao;
        this.referencia = referencia;
        this.provento = provento;
        this.desconto = desconto;
    }

    public FuncionarioAuxilioCreche() {
        
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
