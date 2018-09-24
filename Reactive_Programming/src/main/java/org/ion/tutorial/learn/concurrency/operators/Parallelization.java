package org.ion.tutorial.learn.concurrency.operators;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Parallelization {
	public static void main(String[] args) throws InterruptedException {

		/*Demo1();
		Demo2();*/
		Demo3();

		Thread.sleep(20000);
	}

	private static void Demo3() {
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("Core count" + coreCount);
		AtomicInteger assigner = new AtomicInteger(0);
		Observable.range(1, 10).groupBy(i -> assigner.incrementAndGet() % coreCount)
				.flatMap(grp -> grp.observeOn(Schedulers.io())
						.map(i2 -> intenseCalculation(i2)))
				.doOnNext(i -> System.out.println(
						"Next" + i + " " + LocalTime.now() + " on thread " + Thread.currentThread().getName()))
				.subscribe(i -> System.out.println(
						"Received " + i + " " + LocalTime.now() + " on thread " + Thread.currentThread().getName()));
	}

	private static void Demo2() {
		Observable.range(1, 10)
				.flatMap(
						i -> Observable.just(i).subscribeOn(Schedulers.computation()).map(i2 -> intenseCalculation(i2)))
				.subscribe(i -> System.out.println(
						"Received " + i + " " + LocalTime.now() + " on thread " + Thread.currentThread().getName()));
	}

	private static void Demo1() {
		Observable.range(1, 10).map(i -> intenseCalculation(i))
				.subscribe(i -> System.out.println("Received " + i + " " + LocalTime.now()));
	}

	public static <T> T intenseCalculation(T value) throws InterruptedException {
		System.out.println(
				"Calculation on " + LocalTime.now() + " on thread " + Thread.currentThread().getName());
		Thread.sleep(2000);
		return value;
	}
}