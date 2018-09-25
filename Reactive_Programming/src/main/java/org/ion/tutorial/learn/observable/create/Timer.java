package org.ion.tutorial.learn.observable.create;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Timer {
	public static void main(String[] args) throws InterruptedException {
		Observable<Long> timer = Observable.timer(1, TimeUnit.SECONDS);
		timer
		.subscribe(
					System.out::println, 
					Throwable::printStackTrace, 
					() -> System.out.println("Done!")
				);
		
		Thread.sleep(5000);
	}
}