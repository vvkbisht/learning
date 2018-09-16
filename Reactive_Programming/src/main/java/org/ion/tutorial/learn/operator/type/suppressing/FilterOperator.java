package org.ion.tutorial.learn.operator.type.suppressing;

import io.reactivex.Observable;

public class FilterOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").filter(s -> s.length() != 5)
				.subscribe(s -> System.out.println("RECEIVED: " + s));
	}
}