package org.ion.tutorial.learn.observable.create;

import io.reactivex.Observable;

public class Never {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> empty = Observable.never();
		empty
			.subscribe(
						System.out::println, 
						Throwable::printStackTrace, 
						() -> System.out.println("Done!")
					);
		Thread.sleep(5000);
	}
}