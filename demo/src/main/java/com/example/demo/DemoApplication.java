package com.example.demo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.insert.AdicionaisInsert;
import com.example.demo.repository.BeneficiosRepository;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.service.funcionario_INSS;


@SpringBootApplication
public class DemoApplication {

    private static Map<String, Object> funcionario;
    private static Map<String, Object> beneficios;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        FuncionarioRepository funcionarioRepository = context.getBean(FuncionarioRepository.class);
        BeneficiosRepository beneficiosRepository = context.getBean(BeneficiosRepository.class);
        AdicionaisInsert adicionaisInsert = context.getBean(AdicionaisInsert.class);
        


        funcionario = funcionarioRepository.imprimirFuncionarioPorId(1);
        beneficios = beneficiosRepository.imprimirBeneficiosPorId(1);
        

        System.out.println(funcionario);
        System.out.println(beneficios);

        funcionario_INSS funcionarioINSS = funcionario_INSS.calcularINSS(beneficios, funcionario);


        if (funcionarioINSS != null) {
            // Obter os valores calculados
            String descricao = funcionarioINSS.getDescricao();
            double referencia = funcionarioINSS.getReferencia();
            double provento = funcionarioINSS.getProvento();
            double desconto = funcionarioINSS.getDesconto();
        
            // Inserir os valores no banco de dados
            adicionaisInsert.inserirFuncionario(descricao, referencia, provento, desconto);
        }
;

    }


    

}
