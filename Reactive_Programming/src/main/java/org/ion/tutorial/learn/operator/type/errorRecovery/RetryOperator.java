package org.ion.tutorial.learn.operator.type.errorRecovery;

import io.reactivex.Observable;

public class RetryOperator {
	public static void main(String[] args) {
		Observable
			.just(5, 2, 4, 0, 3, 2, 8)
			.map(i -> 10 / i)
			.retry()
			.subscribe(i -> System.out.println("RECEIVED: " + i), 
				e -> System.out.println("RECEIVED ERROR: " + e)
				);
		
		Observable.just(5, 2, 4, 0, 3, 2, 8)
			.map(i -> 10 / i)
			.retry(2)
			.subscribe(i -> System.out.println("RECEIVED: " + i),
					   e -> System.out.println("RECEIVED ERROR: " + e)
					  );
	}
}