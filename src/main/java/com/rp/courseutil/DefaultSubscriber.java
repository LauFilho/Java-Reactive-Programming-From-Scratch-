package com.rp.courseutil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriber(String name) {
        this.name = name + " - ";
    }

    public DefaultSubscriber() {

    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {

        System.out.println(name + "Recebido : " + o);
    }

    @Override
    public void onError(Throwable t) {

        System.out.println(name + "ERROR : " + t.getMessage());

    }

    @Override
    public void onComplete() {

        System.out.println(name + "Completo");

    }
}
