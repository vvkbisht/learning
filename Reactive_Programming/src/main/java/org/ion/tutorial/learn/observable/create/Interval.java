package org.ion.tutorial.learn.observable.create;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class Interval {
	public static void main(String[] args) throws InterruptedException {
		Observable
			.interval(1, TimeUnit.SECONDS)
			.subscribe(s -> System.out.println(s + " Mississippi"));
		Thread.sleep(5000);
	}
}