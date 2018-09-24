package org.ion.tutorial.learn.multicasting.replay;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ReplayOperator {
	public static void main(String[] args) throws InterruptedException {
		Demo1();
		Demo2();
		Demo3();
	}

	private static void Demo3() throws InterruptedException {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").replay(1).refCount();
		// Observer 1
		source.subscribe(l -> System.out.println("Observer 1: " + l));
		Thread.sleep(3000);
		// Observer 2
		source.subscribe(l -> System.out.println("Observer 2: " + l));
		Thread.sleep(3000);
	}

	private static void Demo2() {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").replay(1)
				.autoConnect();
		// Observer 1
		source.subscribe(l -> System.out.println("Observer 1: " + l));
		// Observer 2
		source.subscribe(l -> System.out.println("Observer 2: " + l));
	}

	private static void Demo1() throws InterruptedException {
		Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS).replay().autoConnect();
		// Observer 1
		seconds.subscribe(l -> System.out.println("Observer 1: " + l));
		Thread.sleep(3000);
		// Observer 2
		seconds.subscribe(l -> System.out.println("Observer 2: " + l));
		Thread.sleep(3000);
	}
}