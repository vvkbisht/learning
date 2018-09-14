package org.ion.tutorial.learn.observable.create;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class Just {
	public static void main(String[] args) {
		Observable<String> source = Observable
				.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		source
		.map(String::length)
		.filter(i -> i >= 5)
		.subscribe(s -> System.out.println("RECEIVED: " + s));

		List<String> items = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		Observable<String> source2 = Observable
				.fromIterable(items);
		source2
		.map(String::length)
		.filter(i -> i >= 5)
		.subscribe(s -> System.out.println("RECEIVED: " + s));
	}
}
