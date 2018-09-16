package org.ion.tutorial.learn.operator.type.transforming;

import io.reactivex.Observable;

public class RepeatOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").repeat(2)
				.subscribe(s -> System.out.println("Received: " + s));
	}
}