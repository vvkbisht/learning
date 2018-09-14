package org.ion.tutorial.learn.observable.create;

import io.reactivex.Observable;

public class Error {
	public static void main(String[] args) {
		Observable
			.error(new Exception("Crash and burn!"))
			.subscribe(
						i -> System.out.println("RECEIVED: " + i),
						Throwable::printStackTrace, 
						() -> System.out.println("Done!")
					);
		
		Observable
		.error(() -> new Exception("Crash and burn!"))
		.subscribe(
					i -> System.out.println("RECEIVED: " + i),
					Throwable::printStackTrace, 
					() -> System.out.println("Done!")
				);
	}
}