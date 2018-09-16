package org.ion.tutorial.learn.operator.type.action;

import io.reactivex.Observable;

public class DoOnCompleteOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.doOnComplete(() -> System.out.println("Source is done emitting!")).map(String::length)
				.subscribe(i -> System.out.println("Received: " + i));
	}
}