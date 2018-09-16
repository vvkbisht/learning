package org.ion.tutorial.learn.operator.type.collecting;

import io.reactivex.Observable;

public class ToMultiMapOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").toMap(String::length)
				.subscribe(s -> System.out.println("Received: " + s));

		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").toMultimap(String::length)
				.subscribe(s -> System.out.println("Received: " + s));
	}
}