package org.ion.tutorial.learn.observable.combine;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class AmbiguousOperator {
	public static void main(String[] args) throws InterruptedException {
		// emit every second
		Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS).take(2).map(l -> l + 1)
				.map(l -> "Source1: " + l + " seconds");
		// emit every 300 milliseconds
		Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS).map(l -> (l + 1) * 300)
				.map(l -> "Source2: " + l + " milliseconds");
		// emit Observable that emits first
		Observable.amb(Arrays.asList(source1, source2)).subscribe(i -> System.out.println("RECEIVED: " + i));
		// keep application alive for 5 seconds
		Thread.sleep(5000);
	}

}