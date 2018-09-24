package org.ion.tutorial.learn.concurrency.operators;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SubscribeOn {
	public static void main(String[] args) {
		Observable.interval(1, TimeUnit.SECONDS)
		.subscribeOn(Schedulers.io())  //this is ignored
				.subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()));
		sleep(5000);
		
		Observable.interval(1, TimeUnit.SECONDS,Schedulers.io())
				.subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()));
		sleep(5000);
	}

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}