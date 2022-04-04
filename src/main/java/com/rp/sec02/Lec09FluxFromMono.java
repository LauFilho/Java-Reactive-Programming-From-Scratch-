package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {

        // Convertendo um Mono -> Flux
        Mono<String> stringMono = Mono.just("a");

        Flux<String> flux = Flux.from(stringMono);

        flux.subscribe(
                Util.onNext()
        );

        // Convertendo um Flux -> Mono jeito 1
        Flux<String> stringFlux = Flux.just("Flux vindo de um Mono");
        Mono<String> monoFromFlux = Mono.from(stringFlux);
        monoFromFlux.subscribe(s ->
                System.out.println("Flux -> Mono : " + s)
        );

        // Convertendo um Flux -> Mono jeito 2
        Flux.range(1, 10)
                .filter(integer -> integer > 3 && integer < 6)
                .next() // Transforma para um Mono
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

    }

    private static void doSomoFluxandMono(Flux<String> stringFlux) {

    }
}
