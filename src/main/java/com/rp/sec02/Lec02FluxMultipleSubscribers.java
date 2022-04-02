package com.rp.sec02;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class Lec02FluxMultipleSubscribers {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        Flux<Integer> pares = flux.filter(o -> o % 2 == 0);
        Flux<Integer> impares = flux.filter(o -> o % 2 != 0);

        flux.subscribe(
                subs1 -> System.out.println("Numeros (Todos) : " + subs1)
        );
        pares.subscribe(
                paresVar -> System.out.println("Numeros (Pares) : " + paresVar)
        );
        impares.subscribe(
          imparesVar -> System.out.println("Numeros (Impares) : " + imparesVar)
        );
    }
}
