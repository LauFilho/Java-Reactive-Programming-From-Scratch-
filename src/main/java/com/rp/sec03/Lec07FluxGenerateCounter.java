package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {

    public static void main(String[] args) {

        // Flux Generate passando parametro de estado inicial, servindo como loop dentro do sink
        Flux.generate(
                        () -> 1,
                        (contador, synchronousSink) -> {
                            String pais = Util.faker().country().name();
                            System.out.println("Pais :" + pais);
                            synchronousSink.next(pais);

                            if (pais.toLowerCase().equals("brazil") || contador > 11) {
                                synchronousSink.complete();

                            }

                            return contador + 1;
                        }
                )
                .subscribe(Util.subscriber());

    }

}
