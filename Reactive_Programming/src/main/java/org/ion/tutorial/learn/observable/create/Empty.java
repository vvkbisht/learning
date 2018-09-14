package org.ion.tutorial.learn.observable.create;

import io.reactivex.Observable;

public class Empty {
	public static void main(String[] args) {
		Observable<String> empty = Observable.empty();
		empty
		.subscribe(
					System.out::println, 
					Throwable::printStackTrace, 
					() -> System.out.println("Done!")
				);
	}
}