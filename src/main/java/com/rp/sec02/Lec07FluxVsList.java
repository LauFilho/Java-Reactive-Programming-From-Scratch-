package com.rp.sec02;

import com.rp.courseutil.Util;
import com.rp.sec02.helper.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        //Solução sem FLux
        List<String> listaNomes = NameGenerator.stringList(2);
        System.out.println("Lista de Nomes, sem Flux" + listaNomes);
        //Solução com FLux
        NameGenerator.stringListFlux(5)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );


    }
}
