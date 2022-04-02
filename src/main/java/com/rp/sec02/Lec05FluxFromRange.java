package com.rp.sec02;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class Lec05FluxFromRange {

    public static void main(String[] args) {


        Flux.range(1, 5)
                .map(i -> Faker.instance().gameOfThrones().character())
                .subscribe(
                        nome -> System.out.println("Mapeado : " + nome)
                );
    }
}
