package org.ion.tutorial.learn.operator.type.suppressing;

import io.reactivex.Observable;

public class SkipOperator {
	public static void main(String[] args) {
		Observable.range(1, 100).skip(90).subscribe(i -> System.out.println("RECEIVED: " + i));
	}
}