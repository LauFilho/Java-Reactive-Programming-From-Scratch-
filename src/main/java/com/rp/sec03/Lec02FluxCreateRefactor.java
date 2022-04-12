package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {

        // Exemplo 2 : Usando o FluxCreate com o conceito de FluxSink embutido internamente
        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer)
                .timeout(Duration.ofSeconds(1))
                .subscribe(Util.subscriber()
                );

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        //Util.sleepSeconds(10);
    }

}
