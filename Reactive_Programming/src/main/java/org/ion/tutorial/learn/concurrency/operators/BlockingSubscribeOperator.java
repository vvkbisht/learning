package org.ion.tutorial.learn.concurrency.operators;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class BlockingSubscribeOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").subscribeOn(Schedulers.computation())
				.map(BlockingSubscribeOperator::intenseCalculation)
				.blockingSubscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done!"));
	}

	public static <T> T intenseCalculation(T value) {
		sleep(ThreadLocalRandom.current().nextInt(3000));
		return value;
	}

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}