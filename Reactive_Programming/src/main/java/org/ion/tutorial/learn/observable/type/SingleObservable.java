package org.ion.tutorial.learn.observable.type;

import io.reactivex.Single;

public class SingleObservable {
	public static void main(String[] args) {
		Single
			.just("Hello")
			.map(String::length)
			.subscribe(
					System.out::println, 
					Throwable::printStackTrace
				);
	}
}