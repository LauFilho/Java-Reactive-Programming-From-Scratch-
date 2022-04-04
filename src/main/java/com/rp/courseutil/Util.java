package com.rp.courseutil;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {

        return o -> System.out.println("Recebido : " + o);
    }

    public static Consumer<Throwable> onError() {

        return e -> System.out.println("Erro : " + e.getMessage());
    }

    public static Runnable onComplete() {

        return () -> System.out.println("Completo");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepSeconds(int segundos) {

        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String nome) {
        return new DefaultSubscriber(nome);
    }

}
