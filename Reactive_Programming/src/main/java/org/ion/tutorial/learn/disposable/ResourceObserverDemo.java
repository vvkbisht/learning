package org.ion.tutorial.learn.disposable;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

public class ResourceObserverDemo {
	public static void main(String[] args) {

		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
		ResourceObserver<Long> myObserver = new ResourceObserver<Long>() {
			@Override
			public void onError(Throwable e) {
				// has access to Disposable
			}

			@Override
			public void onComplete() {
				// has access to Disposable
			}

			@Override
			public void onNext(Long t) {
				// TODO Auto-generated method stub

			}
		};

		// capture Disposable
		Disposable disposable = source.subscribeWith(myObserver);
	}
}
