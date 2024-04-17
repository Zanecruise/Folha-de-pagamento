package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DemoApplication;
import com.example.demo.repository.FuncionarioMAPRepository;
import com.example.demo.repository.verificaSeTemFolha;
import com.example.output.FolhaDePagamento;

/*
 
Essa classe pega o id do funcionario do html*/
@RestController
public class IntermedioController {

    private final FolhaDePagamento folhaDePagamento;
    private final PuxaIdFolha idDaFolha;
    private final DemoApplication main;

    @Autowired
    public IntermedioController(FolhaDePagamento folhaDePagamento, PuxaIdFolha idDaFolha, DemoApplication main) {
        this.folhaDePagamento = folhaDePagamento;
        this.idDaFolha = idDaFolha;
        this.main = main;
    }

    @PostMapping("/final/emitir-folha/{id_funcionario}")
    public void intermedEmitirFolha(@PathVariable int id_funcionario) {
        System.out.println("ID do funcionario: " + id_funcionario);
        int idFolha = idDaFolha.getIdDaFolha(id_funcionario);

        double folhas = verificaSeTemFolha.quantidadeFolha(idFolha);
        System.out.println(folhas);

        Map<String, Object> funcionario = FuncionarioMAPRepository.imprimirFuncionarioPorId(id_funcionario);

        String x = (String) funcionario.get("categoria");
        String y = (String) funcionario.get("categoria");
        System.out.println(x);
        System.out.println(y);
        

        if ("empregado_contratado".equals(x) || "empregado_contratado".equals(y)) {

            if (folhas == 1.0) {

                DemoApplication.calcularTudo(idFolha, id_funcionario);
                folhaDePagamento.emitirFolha(id_funcionario);
                
                
            } else{
    
                System.out.println("Ja existe uma folha para esse funcionario");
                folhaDePagamento.emitirFolha(id_funcionario);
    
    
            }
            

        }else{


            System.out.println("Não é possivel gerar a folha de pagamento para esse tipo de funcionario");

        }

        

        
    }
}