package org.ion.tutorial.learn.exercise;

import io.reactivex.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TimingExercise {
    public static void main(String args[]) throws InterruptedException {
        Observable source = Observable
                .create(emitter -> {
                    for (int i = 0; i < 10; i++) {
                        emitter.onNext(getRandomNumber(5));
                    }
                })
                .doOnNext(s -> System.out.println("Processing: " + s))
                .concatMap(x ->
                        Observable
                                .just(x)
                                .delay(getRandomNumber(5), TimeUnit.SECONDS)
                );

        source.subscribe(System.out::println);

        Thread.sleep(20000);
    }

    private static int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }
}