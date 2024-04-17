package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * essa controller executa a pagina principal html
 */
@Controller
@RequestMapping("/folha-pagamento")
public class IndexController {

    @GetMapping("emitir")
    public String renderTelaPrincipal() {
        return "index";
    }

}
