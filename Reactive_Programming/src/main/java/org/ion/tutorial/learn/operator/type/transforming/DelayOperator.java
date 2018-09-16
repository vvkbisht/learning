package org.ion.tutorial.learn.operator.type.transforming;

import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;

public class DelayOperator {
	public static void main(String[] args) throws InterruptedException {
		Observable.create(e -> {
			e.onNext("hello");
			e.onNext("hello");
			e.onNext("hello");
		}).delay(3, TimeUnit.SECONDS).subscribe(s -> System.out.println("Received: " + s));
		Thread.sleep(5000);
	}
}