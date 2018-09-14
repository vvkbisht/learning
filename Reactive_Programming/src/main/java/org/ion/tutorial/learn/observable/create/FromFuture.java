package org.ion.tutorial.learn.observable.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.reactivex.Observable;

public class FromFuture {

	private static ExecutorService executor = Executors.newSingleThreadExecutor();

	public static Future<Integer> calculate(Integer input) {
		return executor.submit(() -> {
			return input * input;
		});
	}

	public static void main(String[] args) {
		Future<Integer> futureValue = calculate(10);
		Observable.fromFuture(futureValue).subscribe(System.out::println);
	}
}
