package org.ion.tutorial.learn.operator.type.reducing;

import io.reactivex.Observable;

public class CountOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").count()
				.subscribe(s -> System.out.println("Received: " + s));
	}
}