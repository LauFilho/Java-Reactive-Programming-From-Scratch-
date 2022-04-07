package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    public static void main(String[] args) {


        Flux.generate(synchronousSink -> {
                    System.out.println("Emitindo :");
                    synchronousSink.next(Util.faker().country().name());
                    //synchronousSink.complete();
                    synchronousSink.error(new RuntimeException("Erro"));


                })
                .take(5)
                .subscribe(Util.subscriber()
                );
    }
}
