package org.ion.tutorial.learn.operator.type.collecting;

import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.Observable;

public class ToListOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").toList()
				.subscribe(s -> System.out.println("Received: " + s));
		
		Observable.range(1,1000)
			.toList(1000)  //specifying list capacity
			.subscribe(s -> System.out.println("Received: " + s));
		
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
			.toList(CopyOnWriteArrayList::new) //specifying list implementation
			.subscribe(s -> System.out.println("Received: " + s));
	}
}