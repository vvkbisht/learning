package org.ion.tutorial.learn.operator.type.suppressing;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class TakeOperator {
	public static void main(String[] args) throws InterruptedException {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").take(3)
				.subscribe(s -> System.out.println("RECEIVED: " + s));

		Observable.interval(300, TimeUnit.MILLISECONDS).take(2, TimeUnit.SECONDS)
				.subscribe(i -> System.out.println("RECEIVED: " + i));
		Thread.sleep(5000);
	}
}