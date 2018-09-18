package org.ion.tutorial.learn.observable.combine;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class CombineLatestOperator {
	public static void main(String[] args) throws InterruptedException {
		Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
		Observable<Long> source2 = Observable.interval(2, TimeUnit.SECONDS);
		Observable.combineLatest(source1, source2, (l1, l2) -> "SOURCE 1: " + l1 + " SOURCE 2: " + l2)
				.subscribe(System.out::println);
		Thread.sleep(3000);
	}
}