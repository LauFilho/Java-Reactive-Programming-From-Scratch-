package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println(Util.faker().gameOfThrones().dragon());

        Mono.fromRunnable(timeConsumingProcess()).subscribe(
                Util.onNext(),
                Util.onError(),
                runnable::run
        );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operação terminada ");
        };
    }
}
