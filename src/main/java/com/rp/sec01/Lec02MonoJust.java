package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

        //publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);
        mono.subscribe(integer -> System.out.println("Recebi o inteiro do publisher : " + integer));



    }
}
