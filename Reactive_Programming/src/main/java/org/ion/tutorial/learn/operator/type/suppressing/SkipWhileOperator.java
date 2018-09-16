package org.ion.tutorial.learn.operator.type.suppressing;

import io.reactivex.Observable;

public class SkipWhileOperator {
	public static void main(String[] args) {
		Observable.range(1, 100).skipWhile(i -> i <= 95).subscribe(i -> System.out.println("RECEIVED: " + i));
	}
}