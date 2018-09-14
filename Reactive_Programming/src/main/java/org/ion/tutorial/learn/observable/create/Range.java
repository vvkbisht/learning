package org.ion.tutorial.learn.observable.create;

import io.reactivex.Observable;

public class Range {
	public static void main(String[] args) {
		Observable
			.range(1, 10)
			.subscribe(s -> System.out.println("RECEIVED: " + s));
	}
}