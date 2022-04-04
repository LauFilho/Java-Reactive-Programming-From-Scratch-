package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

    public static void main(String[] args) {
        // Exemplo 1 : Com do While pro Flux.create
        Flux.create(fluxSink -> {

                    String pais;
                    do {
                        pais = Util.faker().country().name();
                        System.out.println("Emitindo o País :" + pais);
                        fluxSink.next(pais);
                    } while (!pais.toLowerCase().equals("brazil") && !fluxSink.isCancelled());
                    fluxSink.complete();

                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
