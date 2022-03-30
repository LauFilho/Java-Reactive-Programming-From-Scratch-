package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // só usamos mono.just quando tevemos data para processar
        //Mono<String> mono = Mono.just(getName());

        //Usando Mono.fromSupplier (fornecedor) mono executa à partir de uma outra fonte
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> monoSupplier = Mono.fromSupplier(stringSupplier);
        monoSupplier.subscribe(
                Util.onNext()
        );

        //Usando Mono.Callable  mono executa diretamente
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable).subscribe(
                Util.onNext()
        );

    }

    private static String getName() {
        System.out.println("Gerando Nome...");
        return Util.faker().name().fullName();
    }
}
