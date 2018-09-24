package org.ion.tutorial.learn.multicasting.replay;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class CacheOperator {
	public static void main(String[] args) throws InterruptedException {
		//Demo1();
		//Demo2();
		Demo3();
	}

	private static void Demo1() {
		Observable<Integer> cachedRollingTotals = Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
				.scan(0, (total, next) -> total + next)
				.doOnNext(x -> System.out.println("on next"+x))
				.cache();
		cachedRollingTotals.subscribe(l -> System.out.println("Observer 1: " + l));
		cachedRollingTotals.subscribe(l -> System.out.println("Observer 2: " + l));
	}
	
	private static void Demo2() throws InterruptedException {
		Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS).cache();
		// Observer 1
		seconds.subscribe(l -> System.out.println("Observer 1: " + l));
		Thread.sleep(3000);
		// Observer 2
		seconds.subscribe(l -> System.out.println("Observer 2: " + l));
		Thread.sleep(3000);
		// Observer 3
		seconds.subscribe(l -> System.out.println("Observer 3: " + l));
	}
	
	private static void Demo3() {
		Observable<Integer> cachedRollingTotals =
				Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
				.scan(0, (total,next) -> total + next)
				.doOnNext(x -> System.out.println("on next"+x))
				.cacheWithInitialCapacity(3);
		cachedRollingTotals.subscribe(l -> System.out.println("Observer 1: " + l));
		cachedRollingTotals.subscribe(l -> System.out.println("Observer 2: " + l));
	}
}