package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        // publisher - Cenário de Sucesso
        //Mono<String> mono = Mono.just("Exemplo");

        // publisher - Cenário de Erro
        Mono<Integer> mono = Mono.just("Exemplo")
                .map(String::length)
                .map(numero -> numero/1);

        // Opção 1 - Mono Subscribe sem construtor
        //mono.subscribe(System.out::println);

        // Opção 2 - Mono Subscribe seguido de -> 1 - String, 2 - Erro, 3 - Complete
//        mono.subscribe(
//                item -> System.out.println(item),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Completed")
//
//
//        );

        // Opção 3 - Mono Subscribe seguido de -> 1 - String, 2 - Erro, 3 - Complete com UTILs do package courseutil
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
