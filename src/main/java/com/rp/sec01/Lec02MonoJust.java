package com.rp.sec01;

import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Lec02MonoJust {

    public static void main(String[] args) {

        //publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);
        mono.subscribe(integer -> System.out.println("Recebi o inteiro do publisher : " + integer));


    }
}
