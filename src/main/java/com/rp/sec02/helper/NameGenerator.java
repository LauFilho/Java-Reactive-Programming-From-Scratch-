package com.rp.sec02.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    //Solução sem Flux
    public static List<String> stringList(int qtdNomes) {
        List<String> nameList = new ArrayList<>(qtdNomes);
        for (int i = 0; i < qtdNomes; i++) {
            nameList.add(getName());
        }
        return nameList;
    }

    //Solução com Flux
    public static Flux<String>stringListFlux( int qtdNomes){
        return Flux.range(0, qtdNomes)
                .map(nome -> getName());
    }

    private static String getName() {
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
