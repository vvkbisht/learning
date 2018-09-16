package org.ion.tutorial.learn.disposable;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DisposableObserver {
	public static void main(String[] args) {

		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
		Observer<Long> myObserver = new Observer<Long>() {
			private Disposable disposable;

			@Override
			public void onSubscribe(Disposable disposable) {
				this.disposable = disposable;
			}

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

		// Below code will not compile as passing an Observer to the subscribe() method will be void 
		//Disposable disposable = source.subscribe(myObserver);
	}
}
