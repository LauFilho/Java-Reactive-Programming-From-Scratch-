package com.rp.sec02;

import com.github.javafaker.Faker;
import com.rp.courseutil.Util;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;

public class Lec01FluxIntro {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.just(1, 2, 3, 4, "a", Faker.instance().gameOfThrones().character());
        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
