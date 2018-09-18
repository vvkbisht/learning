package org.ion.tutorial.learn.observable.combine;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ZippingOperator {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		Observable<Integer> source2 = Observable.range(1, 6);
		Observable.zip(source1, source2, (s, i) -> s + "-" + i).subscribe(System.out::println);

		Observable<String> strings = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
		Observable.zip(strings, seconds, (s, l) -> s)
				.subscribe(s -> System.out.println("Received " + s + " at " + LocalTime.now()));
		Thread.sleep(6000);
	}
}