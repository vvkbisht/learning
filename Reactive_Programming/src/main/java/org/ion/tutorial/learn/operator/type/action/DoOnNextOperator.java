package org.ion.tutorial.learn.operator.type.action;

import io.reactivex.Observable;

public class DoOnNextOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.doOnNext(s -> System.out.println("Processing: " + s)).map(String::length)
				.subscribe(i -> System.out.println("Received: " + i));
	}
}