package org.ion.tutorial.learn.observable.type;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableDemo {
	public static void main(String[] args) throws InterruptedException {
		ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
		// Set up observer 1
		source.subscribe(s -> System.out.println("Observer 1: " + s));
		// Set up observer 2
		source.subscribe(i -> System.out.println("Observer 2: " + i));
		// Fire!
		source.connect();

		Thread.sleep(5000);
		source.subscribe(s -> System.out.println("Observer 3: " + s));
		Thread.sleep(5000);

	}
}