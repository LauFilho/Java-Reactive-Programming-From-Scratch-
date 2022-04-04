package com.rp.sec02;

import com.rp.sec02.Tarefa02.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class Lec10StockPriceTarefa {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Flux<Integer> price = StockPricePublisher.getPrice();
        price.subscribeWith(new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {

                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer preco) {
                System.out.println(LocalDateTime.now() + " : Preço : " + preco);

                if (preco > 110 || preco < 90) {
                    this.subscription.cancel();
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable t) {

                latch.countDown();
            }

            @Override
            public void onComplete() {
                latch.countDown();

            }
        });
        latch.await();
    }
}
