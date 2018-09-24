package org.ion.tutorial.learn.concurrency.scheduler.types;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class CustomScheduler {
	public static void main(String[] args) {
		int numberOfThreads = 20;
		ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
		Scheduler scheduler = Schedulers.from(executor);
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").subscribeOn(scheduler)
				.doFinally(executor::shutdown)
				.subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()));

	}
}