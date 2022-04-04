package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {

        Mono<String> stringMono = Mono.just("a");

        Flux<String> flux = Flux.from(stringMono);

        flux.subscribe(
                Util.onNext()
        );


    }

    private static void doSomoFluxandMono(Flux<String> stringFlux){

    }
}
