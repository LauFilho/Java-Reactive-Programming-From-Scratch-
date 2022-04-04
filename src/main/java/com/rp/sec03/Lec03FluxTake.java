package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

    public static void main(String[] args) {

        Flux.range(1,10)
                .log()
                .take(4) // Se limita à pegar N itens do fluxo, dando um cancel() no Subscription
                .subscribe(Util.subscriber());
    }
}
