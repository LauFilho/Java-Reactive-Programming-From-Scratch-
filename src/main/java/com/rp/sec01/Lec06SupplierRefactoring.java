package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {

        Mono<String> response = getName();
        response.subscribe(
                Util.onNext()
        );
    }

    private static Mono<String> getName() {
        System.out.println("Entrando no método getName...");
        return Mono.fromSupplier(() -> {
            System.out.println("Gerando Nome...");
            Util.sleepSeconds(5);
            return Util.faker().name().fullName();
        });
    }
}
