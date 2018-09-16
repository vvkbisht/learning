package org.ion.tutorial.learn.operator.type.collecting;

import java.util.HashSet;

import io.reactivex.Observable;

public class CollectOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").collect(HashSet::new, HashSet::add)
				.subscribe(s -> System.out.println("Received: " + s));
	}
}