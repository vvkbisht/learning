package org.ion.tutorial.learn.operator.type.suppressing;

import io.reactivex.Observable;

public class DistinctUntilChangedOperator {
	public static void main(String[] args) {
		Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1).distinctUntilChanged()
				.subscribe(i -> System.out.println("RECEIVED: " + i));
		
		Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
				"Delta")
				.distinctUntilChanged(String::length)
				.subscribe(i -> System.out.println("RECEIVED: " + i));
	}
}