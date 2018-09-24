package org.ion.tutorial.learn.concurrency.operators;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DisposeOn {
	public static void main(String[] args) throws InterruptedException {
		Disposable d = Observable.interval(1, TimeUnit.SECONDS)
				.doOnDispose(() -> System.out.println("Disposing on thread " + Thread.currentThread().getName()))
				.unsubscribeOn(Schedulers.io()).subscribe(i -> System.out.println("Received " + i));
		Thread.sleep(3000);
		d.dispose();
		Thread.sleep(3000);
	}
}