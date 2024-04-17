package com.example.demo;

import java.text.ParseException;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.insert.AdicionaisInsert;
import com.example.demo.joins.FuncionarioEmpregadorJoin;
import com.example.demo.repository.AdicionaisRepository;
import com.example.demo.repository.AtributosFolhaRepository;
//import com.example.demo.joins.BeneficiariosLEFT;
import com.example.demo.repository.BeneficiosRepository;
import com.example.demo.repository.EnderecoToString;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.service.FuncionarioAdiantamento;
import com.example.demo.service.FuncionarioDSR;
import com.example.demo.service.FuncionarioDescontosJudiciais;
import com.example.demo.service.FuncionarioFGTS;
import com.example.demo.service.FuncionarioINSS;
import com.example.demo.service.FuncionarioPericulosidade;
import com.example.demo.service.FuncionarioSalarioFamilia;
import com.example.output.FolhaDePagamento;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo", "com.example.output" })
public class DemoApplication {

    private static Map<String, Object> funcionario;
    private static Map<String, Object> beneficios;
    // private static int beneficiarios;
    private static int id = 1;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        FuncionarioRepository funcionarioRepository = context.getBean(FuncionarioRepository.class);
        BeneficiosRepository beneficiosRepository = context.getBean(BeneficiosRepository.class);
        AdicionaisInsert adicionaisInsert = context.getBean(AdicionaisInsert.class);
        // BeneficiariosLEFT beneficiariosLEFT =
        // context.getBean(BeneficiariosLEFT.class);

        beneficios = beneficiosRepository.imprimirBeneficiosPorId(id);
        funcionario = funcionarioRepository.imprimirFuncionarioPorId(id);
        // beneficiarios = beneficiariosLEFT.imprimirBeneficiariosPorId(id);

        System.out.println(beneficios);
        System.out.println(funcionario);
        // System.out.println(beneficiarios);

        FuncionarioAdiantamento adiantamento = new FuncionarioAdiantamento();
        FuncionarioFGTS fgts = new FuncionarioFGTS();
        FuncionarioINSS inss = new FuncionarioINSS();
        FuncionarioDescontosJudiciais descontosJudiciais = new FuncionarioDescontosJudiciais();
        FuncionarioDSR dsr = new FuncionarioDSR();
        FuncionarioSalarioFamilia salarioFamilia = new FuncionarioSalarioFamilia();
        FuncionarioPericulosidade periculosidade = new FuncionarioPericulosidade();

        double funcionarioFGTS = fgts.calcularBeneficio(beneficios, funcionario);
        double funcionarioAdiantamento = adiantamento.calcularBeneficio(beneficios, funcionario);
        double funcionarioINSS = inss.calcularBeneficio(beneficios, funcionario);
        double funcionarioDescontosJudiciais = descontosJudiciais.calcularBeneficio(beneficios, funcionario);
        double funcionarioDRS = dsr.calcularBeneficio(beneficios, funcionario);
        double FuncionarioSalarioFamilia = salarioFamilia.calcularBeneficio(beneficios, funcionario);
        double FuncionarioPericulosidade = periculosidade.calcularBeneficio(beneficios, funcionario);

        // System.out.println(funcionarioDRS);
        System.out.println(FuncionarioSalarioFamilia);

        if (funcionarioINSS != 0.0) {

            String descricao = inss.getDescricao();
            double referencia = inss.getReferencia();
            double provento = inss.getProvento();
            double desconto = inss.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id);
        }

        if (funcionarioFGTS != 0.0) {
            String descricao = fgts.getDescricao();
            double desconto = fgts.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, 0, 0, desconto, id);
        }

        if (funcionarioAdiantamento != 0.0) {

            String descricao = adiantamento.getDescricao();
            double referencia = adiantamento.getReferencia();
            double provento = adiantamento.getProvento();
            double desconto = adiantamento.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id);

        }

        if (funcionarioDescontosJudiciais != 0.0) {

            String descricao = descontosJudiciais.getDescricao();
            double referencia = descontosJudiciais.getReferencia();
            double provento = descontosJudiciais.getProvento();
            double desconto = descontosJudiciais.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id);

        }

        if (funcionarioDRS != 0.0) {

            String descricao = dsr.getDescricao();
            double referencia = dsr.getReferencia();
            double provento = dsr.getProvento();
            double desconto = dsr.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id);

        }

        if (FuncionarioSalarioFamilia != 0.0) {

            String descricao = salarioFamilia.getDescricao();
            double referencia = salarioFamilia.getReferencia();
            double provento = salarioFamilia.getProvento();
            double desconto = salarioFamilia.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id);

        }

        if (FuncionarioPericulosidade != 0.0) {

            String descricao = periculosidade.getDescricao();
            double referencia = periculosidade.getReferencia();
            double provento = periculosidade.getProvento();
            double desconto = periculosidade.getDesconto();

            adicionaisInsert.inserirAdiantamento(descricao, referencia, provento, desconto, id);
        }

    }

}
