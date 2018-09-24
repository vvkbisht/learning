package org.ion.tutorial.learn.concurrency.scheduler.types;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class NewThread {
	public static void main(String[] args) throws InterruptedException {
		Observable
			.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
			.map(x -> "vive")
			.subscribeOn(Schedulers.newThread()) //asking it to run on diff thread instead of main
			.map(s -> intenseCalculation((s)))
			.subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()));
		Observable
			.range(1, 6)
			.subscribeOn(Schedulers.computation())
			.map(s -> intenseCalculation((s)))
			.subscribe(System.out::println);
		Thread.sleep(20000);
	}

	public static <T> T intenseCalculation(T value) throws InterruptedException {
		Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
		return value;
	}
}