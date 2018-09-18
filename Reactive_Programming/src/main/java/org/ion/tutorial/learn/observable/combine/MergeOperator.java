package org.ion.tutorial.learn.observable.combine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class MergeOperator {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> source1 = Observable.just("Alpha", "Beta");
		Observable<String> source2 = Observable.just("Gamma", "Delta");
		Observable.merge(source1, source2).subscribe(i -> System.out.println("RECEIVED: " + i));

		source1.mergeWith(source2).subscribe(i -> System.out.println("RECEIVED: " + i));

		Observable<String> source3 = Observable.just("Epsilon", "Zeta");
		Observable<String> source4 = Observable.just("Eta", "Theta");
		Observable<String> source5 = Observable.just("Iota", "Kappa");
		Observable.mergeArray(source1, source2, source3, source4, source5)
				.subscribe(i -> System.out.println("RECEIVED: " + i));

		List<Observable<String>> sources = Arrays.asList(source1, source2, source3, source4, source5);
		Observable.merge(sources).subscribe(i -> System.out.println("RECEIVED: " + i));

		// emit every second
		Observable<String> sourceA = Observable.interval(1, TimeUnit.SECONDS).map(l -> l + 1) // emit elapsed seconds
				.map(l -> "Source1: " + l + " seconds");
		// emit every 300 milliseconds
		Observable<String> sourceB = Observable.interval(300, TimeUnit.MILLISECONDS).map(l -> (l + 1) * 300)
				.map(l -> "Source2: " + l + " milliseconds");
		// merge and subscribe
		Observable.merge(sourceA, sourceB).subscribe(System.out::println);
		// keep alive for 3 seconds
		Thread.sleep(3000);
	}
}