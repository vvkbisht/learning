package org.ion.tutorial.learn.operator.type.suppressing;

import io.reactivex.Observable;

public class DistinctOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").map(String::length).distinct()
				.subscribe(i -> System.out.println("RECEIVED: " + i));
		
		Observable.just("Alpha", "Beta", "Gamma", "Delta",
				"Epsilon")
				.distinct(String::length)
				.subscribe(i -> System.out.println("RECEIVED: " + i));
	}
}