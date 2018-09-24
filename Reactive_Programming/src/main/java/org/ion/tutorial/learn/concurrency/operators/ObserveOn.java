package org.ion.tutorial.learn.concurrency.operators;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObserveOn {
	public static void main(String[] args) throws InterruptedException {
		// Happens on IO Scheduler
		Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO", "232352/5675675/FOXTROT")
				.subscribeOn(Schedulers.io())
				.flatMap(s -> Observable.fromArray(s.split("/")))
				// Happens on Computation Scheduler
				.observeOn(Schedulers.computation())
				.filter(s -> s.matches("[0-9]+"))
				.map(Integer::valueOf)
				.reduce((total, next) -> total + next)
				.subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()));
		Thread.sleep(1000);
	}
}