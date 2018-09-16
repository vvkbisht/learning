package org.ion.tutorial.learn.operator.type.transforming;

import io.reactivex.Observable;

public class CastOperator {
	public static void main(String[] args) {
		Observable<Object> source = Observable
									.just("Alpha", "Beta", "Gamma")
									.map(s -> (Object) s);

		Observable<Object> items = Observable
									.just("Alpha", "Beta", "Gamma")
									.cast(Object.class);
	}
}
