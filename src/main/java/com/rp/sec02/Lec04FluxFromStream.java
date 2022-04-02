package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class Lec04FluxFromStream {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);
        //Stream(Fluxo) é um conjunto de dados que, depois de utilizado, não pode ser mais acessado novamente.
        Stream<Integer> stream = list.stream();

        //stream.forEach(integer -> System.out.println("Numero da lista : " + integer));

        Flux<Integer> fromStream = Flux.fromStream(() -> list.stream());

        fromStream.subscribe(
                Util.onNext()
        );

        // Como eu passei um parâmetro como uma lista de streams, eu consigo reutilizar a mesma stream várias vezes
        fromStream.subscribe(
                Util.onNext()
        );

        Flux.fromStream(stream).subscribe(
                integer -> System.out.println("Numero Stream :" + integer)
        );

    }
}
