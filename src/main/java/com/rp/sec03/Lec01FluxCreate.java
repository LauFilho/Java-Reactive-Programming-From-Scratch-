package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {

                    String pais;
                    do {
                        pais = Util.faker().country().name();
                        fluxSink.next(pais);
                    } while (!pais.toLowerCase().equals("canada"));
                    fluxSink.complete();

                })
                .subscribe(Util.subscriber());
    }
}
