package org.ion.tutorial.learn.observable.combine;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class FlatMapOperator {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		source.flatMap(s -> Observable.fromArray(s.split(""))).subscribe(System.out::println);

		Observable<Integer> intervalArguments = Observable.just(2, 3, 10, 7);
		intervalArguments.flatMap(i -> {
			if (i == 0)
				return Observable.empty();
			else
				return Observable.interval(i, TimeUnit.SECONDS)
						.map(i2 -> i + "s interval: " + ((i + 1) * i) + "seconds elapsed");
		}).subscribe(System.out::println);
		Thread.sleep(12000);
	}
}