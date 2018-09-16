package org.ion.tutorial.learn.operator.type.collecting;

import java.util.concurrent.ConcurrentHashMap;
import io.reactivex.Observable;

public class ToMapOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMap(s -> s.charAt(0)) //key function
				.subscribe(s -> System.out.println("Received: " + s));
		
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMap(s -> s.charAt(0), String::length)  //key and value function
				.subscribe(s -> System.out.println("Received: " + s));
		
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMap(s -> s.charAt(0), 
						String::length,
						ConcurrentHashMap::new) //changing default Map implementation
				.subscribe(s -> System.out.println("Received: " + s));
		
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMap(String::length)
				.subscribe(s -> System.out.println("Received: " + s));
	}
}