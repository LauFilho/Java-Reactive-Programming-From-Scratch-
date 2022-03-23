package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        // publisher
        Mono<String> mono = Mono.just("Exemplo");

        // Opção 1 - Mono Subscribe sem construtor
        //mono.subscribe(System.out::println);

        // Opção 2 - Mono Subscribe seguido de -> 1 - String, 2 - Erro, 3 - Complete
        mono.subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed")
        );
    }
}
