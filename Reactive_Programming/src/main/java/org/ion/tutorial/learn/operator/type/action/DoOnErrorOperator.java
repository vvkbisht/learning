package org.ion.tutorial.learn.operator.type.action;

import io.reactivex.Observable;

public class DoOnErrorOperator {
	public static void main(String[] args) {
		Observable.just(5, 2, 4, 0, 3, 2, 8).doOnError(e -> System.out.println("Source failed!")).map(i -> 10 / i)
				.doOnError(e -> System.out.println("Division failed!"))
				.subscribe(i -> System.out.println("RECEIVED: " + i), e -> System.out.println("RECEIVED ERROR: " + e));
	}
}