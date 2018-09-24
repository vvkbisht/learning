package org.ion.tutorial.learn.multicasting.replay;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ReplayWindow {
	public static void main(String[] args) throws InterruptedException {
		Demo1();
		Demo2();
	}

	private static void Demo1() throws InterruptedException {
		Observable<Long> seconds = Observable.interval(300, TimeUnit.MILLISECONDS)
				.map(l -> (l + 1) * 300)  // map to elapsed milliseconds
				.replay(1, TimeUnit.SECONDS).autoConnect();
		// Observer 1
		seconds.subscribe(l -> System.out.println("Observer 1: " + l));
		Thread.sleep(2000);
		// Observer 2
		seconds.subscribe(l -> System.out.println("Observer 2: " + l));
		Thread.sleep(1000);
	}
	
	private static void Demo2() throws InterruptedException {
		Observable<Long> seconds = Observable.interval(300, TimeUnit.MILLISECONDS)
				.map(l -> (l + 1) * 300)  // map to elapsed milliseconds
				.replay(1, 1, TimeUnit.SECONDS).autoConnect();
		// Observer 1
		seconds.subscribe(l -> System.out.println("Observer 1: " + l));
		Thread.sleep(2000);
		// Observer 2
		seconds.subscribe(l -> System.out.println("Observer 2: " + l));
		Thread.sleep(1000);
	}
}