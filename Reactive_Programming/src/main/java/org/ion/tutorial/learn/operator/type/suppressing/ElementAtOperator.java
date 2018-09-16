package org.ion.tutorial.learn.operator.type.suppressing;

import io.reactivex.Observable;

public class ElementAtOperator {
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta").elementAt(3)
				.subscribe(i -> System.out.println("RECEIVED: " + i));
	}
}