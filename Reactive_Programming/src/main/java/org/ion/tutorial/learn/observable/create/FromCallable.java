package org.ion.tutorial.learn.observable.create;

import io.reactivex.Observable;

public class FromCallable {
	public static void main(String[] args) {
		/*Observable
		.just(1 / 0)
		.subscribe(
					i -> System.out.println("RECEIVED: " + i),
					e -> System.out.println("Error Captured: " + e)
				);*/
		
		Observable
		.fromCallable(() -> 1 / 0)
		.subscribe(
					i -> System.out.println("Received: " + i),
					e -> System.out.println("Error Captured: " + e)
				);

	}
}
