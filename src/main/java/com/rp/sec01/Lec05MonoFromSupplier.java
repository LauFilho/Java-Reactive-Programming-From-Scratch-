package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // só usamos mono.just quando tevemos data para processar
        //Mono<String> mono = Mono.just(getName());
        Mono<String> monoSupplier = Mono.fromSupplier(() -> getName());
        monoSupplier.subscribe(
                Util.onNext()
        );
    }

    private static String getName() {
        System.out.println("Gerando Nome...");
        return Util.faker().name().fullName();
    }
}
