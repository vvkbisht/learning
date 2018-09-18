package org.ion.tutorial.learn.observable.combine;

import io.reactivex.Observable;

public class ConcatMapOperator {
	public static void main(String[] args) {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		source.flatMap(s -> Observable.fromArray(s.split(""))).subscribe(System.out::println);
	}
}