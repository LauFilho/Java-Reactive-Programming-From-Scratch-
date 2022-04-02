package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayList {

    public static void main(String[] args) {

        Integer[] arrayInt = {11123, 123, 123};
        List<Object> list = Arrays.asList("a", "b", "c");
        Flux<Object> listaIterable = Flux.fromIterable(list);
        Flux.fromArray(arrayInt)
                .subscribe(Util.onNext());

        listaIterable.subscribe(
                lista -> System.out.println("Lista completa vinda de um Iterable :" + lista)
        );
    }
}
