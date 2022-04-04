package com.rp.sec02;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {

                        System.out.println("Recebido Sub: " + subscription);
                        atomicReference.set(subscription);
                        System.out.println(atomicReference);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext valor: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError valor: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");

                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("Cancelando");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
    }
}
