package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {
    public static void main(String[] args) {

        // Flux interval serve como pontá pé de start para que o flux comece a agir, ou seja, à cada tempo do intervalo
        // dito ele realiza a ação
        Flux.interval(Duration.ofSeconds(2))
                .log()
                .subscribe(
                        Util.onNext()
                );
        Util.sleepSeconds(4);
    }
}
