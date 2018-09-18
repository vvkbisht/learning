package org.ion.tutorial.learn.operator.type.action;

import io.reactivex.Observable;

public class DoOnSubscribeOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.doOnSubscribe(d -> System.out.println("Subscribing!"))
				.doOnDispose(() -> System.out.println("Disposing!"))
				.subscribe(i -> System.out.println("RECEIVED: " + i));
	}
}