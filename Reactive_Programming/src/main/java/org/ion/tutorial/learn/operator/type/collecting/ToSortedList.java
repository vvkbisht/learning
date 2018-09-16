package org.ion.tutorial.learn.operator.type.collecting;

import io.reactivex.Observable;

public class ToSortedList {
	public static void main(String[] args) {
		Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
			.toSortedList()
			.subscribe(s -> System.out.println("Received: " + s));
	}
}