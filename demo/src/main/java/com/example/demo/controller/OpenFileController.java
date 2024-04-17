package com.example.demo.controller;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

/*
 * tentei fazer a abertura do arquivo depois de preencher o excel mas aparenmente n deu certo
 */
@RestController
public class OpenFileController {

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam("filePath") String filePath) throws IOException {
        // Obter o nome do arquivo a partir do caminho do arquivo
        Path path = Paths.get(filePath);
        String filename = path.getFileName().toString();

        // Carregar o arquivo como um recurso
        Resource resource = new UrlResource(path.toUri());

        // Configurar o cabeçalho da resposta para indicar o download do arquivo
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }

}
