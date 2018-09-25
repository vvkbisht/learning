package org.ion.tutorial.learn.observable.create;

import io.reactivex.Observable;

public class Defer {
	private static int start = 1;
	private static int count = 5;

	public static void main(String[] args) {
		// demo1();
		
		demo2();

	}

	private static void demo2() {
		Observable<Integer> source2 = Observable.defer(() ->
		Observable.range(start,count));
		source2.subscribe(i -> System.out.println("Observer 1: " + i));
		//modify count
		count = 10;
		source2.subscribe(i -> System.out.println("Observer 2: " + i));
	}

	private static void demo1() {
		Observable<Integer> source1 = Observable.range(start, count);
		source1.subscribe(i -> System.out.println("Observer 1: " + i));
		// modify count
		count = 10;
		//does not detect the changes
		source1.subscribe(i -> System.out.println("Observer 2: " + i));
	}
}