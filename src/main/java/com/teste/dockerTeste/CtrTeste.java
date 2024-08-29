package com.teste.dockerTeste;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/teste")
public class CtrTeste {
    @Value("${google}")
    private String minhaVariavel;

    @GetMapping
    public ResponseEntity<String> teste() {
        InputStream inputStream = null;
        BufferedReader reader = null;

        try {
            // Inicializa o InputStream com um arquivo no seu sistema
            inputStream = new FileInputStream(minhaVariavel);

            // Converte o InputStream para um InputStreamReader
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            // Converte o InputStreamReader para um BufferedReader para leitura eficiente
            reader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = reader.readLine()) != null) {
                // Processa cada linha lida do arquivo
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Fecha os recursos para evitar vazamento de memória
            try {
                if (reader != null) {
                    reader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return ResponseEntity.ok("Tudo funcionando !!! - alterado 22:23 git" + minhaVariavel);
    }
}
