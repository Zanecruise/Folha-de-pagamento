package com.example.demo;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.demo.insert.AdicionaisInsert;
//import com.example.demo.joins.BeneficiariosLEFT;
import com.example.demo.repository.BeneficiosRepository;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.service.FuncionarioAdiantamento;
import com.example.demo.service.FuncionarioAdicionalNoturno;
import com.example.demo.service.FuncionarioAtrasos;
import com.example.demo.service.FuncionarioAuxilioCreche;
import com.example.demo.service.FuncionarioComissao;
import com.example.demo.service.FuncionarioContribuicaoSindical;
import com.example.demo.service.FuncionarioDSR;
import com.example.demo.service.FuncionarioDescontosJudiciais;
import com.example.demo.service.FuncionarioFGTS;
import com.example.demo.service.FuncionarioFaltas;
import com.example.demo.service.FuncionarioHoraExtra;
import com.example.demo.service.FuncionarioINSS;
import com.example.demo.service.FuncionarioIRRF;
import com.example.demo.service.FuncionarioInsalubridade;
import com.example.demo.service.FuncionarioPericulosidade;
import com.example.demo.service.FuncionarioSalarioFamilia;
import com.example.demo.service.FuncionarioTempoServico;
import com.example.demo.service.FuncionarioValeAlimentacao;
import com.example.demo.service.FuncionarioValeTransporte;
import com.example.demo.service.FuncionarioViagem;

@SpringBootApplication
public class DemoApplication {

    private static Map<String, Object> funcionario;
    private static Map<String, Object> beneficios;
    //private static int beneficiarios;
    private static int id = 1;
    private static int id_folha_pagamento = 1;
    

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        FuncionarioRepository funcionarioRepository = context.getBean(FuncionarioRepository.class);
        BeneficiosRepository beneficiosRepository = context.getBean(BeneficiosRepository.class);
        AdicionaisInsert adicionaisInsert = context.getBean(AdicionaisInsert.class);
        //BeneficiariosLEFT beneficiariosLEFT = context.getBean(BeneficiariosLEFT.class);


        beneficios = beneficiosRepository.imprimirBeneficiosPorId(id);
        funcionario = funcionarioRepository.imprimirFuncionarioPorId(id);
        //beneficiarios = beneficiariosLEFT.imprimirBeneficiariosPorId(id);
        


        System.out.println(beneficios);
        System.out.println(funcionario);
        //System.out.println(beneficiarios);

        FuncionarioAdiantamento adiantamento = new FuncionarioAdiantamento();
        FuncionarioFGTS fgts = new FuncionarioFGTS();
        FuncionarioINSS inss = new FuncionarioINSS();
        FuncionarioDescontosJudiciais descontosJudiciais = new FuncionarioDescontosJudiciais();
        FuncionarioDSR dsr = new FuncionarioDSR();
        FuncionarioSalarioFamilia salarioFamilia = new FuncionarioSalarioFamilia();
        FuncionarioPericulosidade periculosidade = new FuncionarioPericulosidade();
        FuncionarioViagem viagem = new FuncionarioViagem();
        FuncionarioComissao comissao = new FuncionarioComissao();
        FuncionarioTempoServico tempoServico = new FuncionarioTempoServico();
        FuncionarioInsalubridade insalubridade = new FuncionarioInsalubridade();
        FuncionarioAuxilioCreche auxilioCreche = new FuncionarioAuxilioCreche();
        FuncionarioHoraExtra horaExtra = new FuncionarioHoraExtra();
        FuncionarioAdicionalNoturno adicionalNoturno = new FuncionarioAdicionalNoturno();
        FuncionarioFaltas faltas = new FuncionarioFaltas();
        FuncionarioContribuicaoSindical cs = new FuncionarioContribuicaoSindical();
        FuncionarioValeAlimentacao valeAlimentacao = new FuncionarioValeAlimentacao();
        FuncionarioAtrasos atrasos = new FuncionarioAtrasos();
        FuncionarioValeTransporte valeTransporte = new FuncionarioValeTransporte();
        FuncionarioIRRF irrf = new FuncionarioIRRF();

        double funcionarioFGTS = fgts.calcularBeneficio(beneficios, funcionario);
        double funcionarioAdiantamento = adiantamento.calcularBeneficio(beneficios, funcionario);
        double funcionarioINSS = inss.calcularBeneficio(beneficios, funcionario);
        double funcionarioDescontosJudiciais = descontosJudiciais.calcularBeneficio(beneficios, funcionario);
        double funcionarioDRS = dsr.calcularBeneficio(beneficios, funcionario);
        double funcionarioSalarioFamilia = salarioFamilia.calcularBeneficio(beneficios, funcionario);
        double funcionarioPericulosidade = periculosidade.calcularBeneficio(beneficios, funcionario);
        double funcionarioViagem = viagem.calcularBeneficio(beneficios, funcionario);
        double funcionarioComissao = comissao.calcularBeneficio(beneficios, funcionario);
        double funcionarioTempoServico = tempoServico.calcularBeneficio(beneficios, funcionario);
        double funcionarioInsalubridade = insalubridade.calcularBeneficio(beneficios, funcionario);
        double funcionarioAuxilioCreche = auxilioCreche.calcularBeneficio(beneficios, funcionario);
        double funcionarioHoraExtra = horaExtra.calcularBeneficio(beneficios, funcionario);
        double funcionarioAdicionalNoturno = adicionalNoturno.calcularBeneficio(beneficios, funcionario);
        double funcionarioFaltas = faltas.calcularBeneficio(beneficios, funcionario);
        double funcionarioContribuicaoSindical = cs.calcularBeneficio(beneficios, funcionario);
        double funcionarioValeAlimentacao = valeAlimentacao.calcularBeneficio(beneficios, funcionario);
        double funcionarioAtrasos = atrasos.calcularBeneficio(beneficios, funcionario);
        double funcionarioValeTransporte = valeTransporte.calcularBeneficio(beneficios, funcionario);
        double funcionarioIRRF = irrf.calcularBeneficio(beneficios, funcionario);
        

        if (funcionarioINSS != 0.0) {

            String descricao = inss.getDescricao();
            double referencia = inss.getReferencia();
            double provento = inss.getProvento();
            double desconto = inss.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
        }

        if (funcionarioFGTS != 0.0) {
            String descricao = fgts.getDescricao();
            double referencia = fgts.getReferencia();
            double provento = fgts.getProvento();
            double desconto = fgts.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
        }

        if (funcionarioAdiantamento != 0.0) {

            String descricao = adiantamento.getDescricao();
            double referencia = adiantamento.getReferencia();
            double provento = adiantamento.getProvento();
            double desconto = adiantamento.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);

        }

        if (funcionarioDescontosJudiciais != 0.0) {

            String descricao = descontosJudiciais.getDescricao();
            double referencia = descontosJudiciais.getReferencia();
            double provento = descontosJudiciais.getProvento();
            double desconto = descontosJudiciais.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);

        }

        if (funcionarioDRS != 0.0) {

            String descricao = dsr.getDescricao();
            double referencia = dsr.getReferencia();
            double provento = dsr.getProvento();
            double desconto = dsr.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);

        }

        if (funcionarioSalarioFamilia != 0.0) {

            String descricao = salarioFamilia.getDescricao();
            double referencia = salarioFamilia.getReferencia();
            double provento = salarioFamilia.getProvento();
            double desconto = salarioFamilia.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);

        }

        if (funcionarioPericulosidade != 0.0) {

            String descricao = periculosidade.getDescricao();
            double referencia = periculosidade.getReferencia();
            double provento = periculosidade.getProvento();
            double desconto = periculosidade.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
        }

        if (funcionarioViagem != 0.0) {

            String descricao = viagem.getDescricao();
            double referencia = viagem.getReferencia();
            double provento = viagem.getProvento();
            double desconto = viagem.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
        }

        
        if (funcionarioComissao != 0.0) {

            String descricao = comissao.getDescricao();
            double referencia = comissao.getReferencia();
            double provento = comissao.getProvento();
            double desconto = comissao.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
        }

        if (funcionarioTempoServico != 0.0) {

            String descricao = tempoServico.getDescricao();
            double referencia = tempoServico.getReferencia();
            double provento = tempoServico.getProvento();
            double desconto = tempoServico.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
        }

        if (funcionarioInsalubridade != 0.0) {

            String descricao = insalubridade.getDescricao();
            double referencia = insalubridade.getReferencia();
            double provento = insalubridade.getProvento();
            double desconto = insalubridade.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
        }


        if (funcionarioAuxilioCreche != 0.0) {

            String descricao = auxilioCreche.getDescricao();
            double referencia = auxilioCreche.getReferencia();
            double provento = auxilioCreche.getProvento();
            double desconto = auxilioCreche.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
           
        }

        if (funcionarioHoraExtra != 0.0) {

            String descricao = horaExtra.getDescricao();
            double referencia = horaExtra.getReferencia();
            double provento = horaExtra.getProvento();
            double desconto = horaExtra.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
            
        }

        if (funcionarioAdicionalNoturno != 0.0) {

            String descricao = adicionalNoturno.getDescricao();
            double referencia = adicionalNoturno.getReferencia();
            double provento = adicionalNoturno.getProvento();
            double desconto = adicionalNoturno.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
            
        }

        if (funcionarioFaltas != 0.0) {

            String descricao = faltas.getDescricao();
            double referencia = faltas.getReferencia();
            double provento = faltas.getProvento();
            double desconto = faltas.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
            
        }

        if (funcionarioContribuicaoSindical != 0.0) {

            String descricao = cs.getDescricao();
            double referencia = cs.getReferencia();
            double provento = cs.getProvento();
            double desconto = cs.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
            
        }

        if (funcionarioValeAlimentacao != 0.0) {

            String descricao = valeAlimentacao.getDescricao();
            double referencia = valeAlimentacao.getReferencia();
            double provento = valeAlimentacao.getProvento();
            double desconto = valeAlimentacao.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
            
        }

        if (funcionarioAtrasos != 0.0) {

            String descricao = atrasos.getDescricao();
            double referencia = atrasos.getReferencia();
            double provento = atrasos.getProvento();
            double desconto = atrasos.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
            
        }

        if (funcionarioValeTransporte != 0.0) {

            String descricao = valeTransporte.getDescricao();
            double referencia = valeTransporte.getReferencia();
            double provento = valeTransporte.getProvento();
            double desconto = valeTransporte.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
            
        }

        if (funcionarioIRRF != 0.0) {

            String descricao = irrf.getDescricao();
            double referencia = irrf.getReferencia();
            double provento = irrf.getProvento();
            double desconto = irrf.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id, id_folha_pagamento);
            
        }

        

    }

}
