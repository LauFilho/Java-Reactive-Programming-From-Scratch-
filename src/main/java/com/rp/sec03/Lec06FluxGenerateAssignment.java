package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {

            String pais = Util.faker().country().name();
            System.out.println("Pais :" + pais);
            synchronousSink.next(pais); // Vai pegar o próximo país

            if (pais.toLowerCase().equals("brazil")) {
                synchronousSink.complete();

            }

        }).subscribe(
                Util.subscriber()
        );
    }
}
