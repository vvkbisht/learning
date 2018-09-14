package org.ion.tutorial.learn.observable.type;

import io.reactivex.Completable;

public class CompleteObservable {
	public static void main(String[] args) {
		Completable
			.fromRunnable(() -> runProcess())
			.subscribe(() -> System.out.println("Done!"));
	}

	public static void runProcess() {
		// run process here
	}
}
