package org.ion.tutorial.learn.throttling;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ThrottleFirst {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> source1 = Observable.interval(100, TimeUnit.MILLISECONDS).map(i -> (i + 1) * 100)
				.map(i -> "SOURCE 1: " + i).take(10);
		Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS).map(i -> (i + 1) * 300)
				.map(i -> "SOURCE 2: " + i).take(3);
		Observable<String> source3 = Observable.interval(2000, TimeUnit.MILLISECONDS).map(i -> (i + 1) * 2000)
				.map(i -> "SOURCE 3: " + i).take(2);
		//Observable.concat(source1, source2, source3).subscribe(System.out::println);

		Observable.concat(source1, source2, source3)
		.throttleLast(2, TimeUnit.SECONDS)
		.subscribe(System.out::println);
		Thread.sleep(6000);
	}
}