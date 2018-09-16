package org.ion.tutorial.learn.operator.type.action;

import io.reactivex.Observable;

public class DoOnSuccessOperator {
	public static void main(String[] args) {
		Observable.just(5, 3, 7, 10, 2, 14).reduce((total, next) -> total + next)
				.doOnSuccess(i -> System.out.println("Emitting: " + i))
				.subscribe(i -> System.out.println("Received: " + i));
	}
}
