package org.ion.tutorial.learn.operator.type.suppressing;

import io.reactivex.Observable;

public class TakeUntilOperator {
	public static void main(String[] args) {
		Observable
			.range(1, 100)
			.takeUntil(i -> i > 5)
			.subscribe(i -> System.out.println("RECEIVED: " + i));
	}
}
