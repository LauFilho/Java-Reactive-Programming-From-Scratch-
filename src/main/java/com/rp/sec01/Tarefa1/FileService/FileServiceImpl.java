package com.rp.sec01.Tarefa1.FileService;


import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class FileServiceImpl {

    private static final Path PATH = Paths.get("E:\\Documentos (F)\\Programação\\Java Reactive Programming [ From Scratch ]\\src\\main\\java\\com\\rp\\resources\\assignment\\sec01\\");

    public static Mono<String> readMono(String nomeArquivo) {
        return Mono.fromSupplier(() -> readFile(nomeArquivo));
    }

    public static Mono<Void> writeMono(String nomeArquivo, String conteudo) {
        return Mono.fromRunnable(() -> writeFile(nomeArquivo, conteudo));
    }

    public static Mono<Void> deleteMono(String nomeArquivo) {
        return Mono.fromRunnable(() -> deleteFile(nomeArquivo));
    }

    private static String readFile(String nomeArquivo) {
        try {
            return String.valueOf((Files.readAllBytes((PATH.resolve(nomeArquivo))).toString()));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    private static void writeFile(String nomeArquivo, String conteudo) {
        try {
            Files.write(PATH.resolve(nomeArquivo), Collections.singleton(conteudo));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void deleteFile(String nomeArquivo) {
        try {
            Files.delete(PATH.resolve(nomeArquivo));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
