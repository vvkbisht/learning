package org.ion.tutorial.learn.operator.type.transforming;

import io.reactivex.Observable;

public class ScanOperator {
	public static void main(String[] args) {
		Observable.just(5, 3, 7, 10, 2, 14).scan((accumulator, next) -> accumulator + next)
				.subscribe(s -> System.out.println("Received: " + s));
		
		Observable.just("Alpha", "Beta", "Gamma", "Delta","Epsilon")
				.scan(0, (total, next) -> total + 1) //here next is emmission from observable
				.subscribe(s -> System.out.println("Received: " + s));
	}
}