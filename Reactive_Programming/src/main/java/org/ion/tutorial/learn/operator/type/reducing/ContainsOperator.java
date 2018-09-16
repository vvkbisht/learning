package org.ion.tutorial.learn.operator.type.reducing;

import io.reactivex.Observable;

public class ContainsOperator {
	public static void main(String[] args) {
		Observable.range(1, 10000).contains(9563).subscribe(s -> System.out.println("Received: " + s));
	}
}