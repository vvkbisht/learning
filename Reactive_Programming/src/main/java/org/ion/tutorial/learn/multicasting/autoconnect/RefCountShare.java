package org.ion.tutorial.learn.multicasting.autoconnect;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class RefCountShare {
	public static void main(String[] args) throws InterruptedException {
		Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS).publish().refCount();
		
		/*//You can also use an alias for publish().refCount() using the share() operator
		 * Observable<Long> seconds =
				Observable.interval(1, TimeUnit.SECONDS).share();*/
		
		// Observer 1
		seconds.take(5).subscribe(l -> System.out.println("Observer 1: " + l));
		Thread.sleep(3000);
		// Observer 2
		seconds.take(5).subscribe(l -> System.out.println("Observer 2: " + l));
		Thread.sleep(3000);
		// there should be no more Observers at this point as both observer 1 and 2 are over
		// Observer 3
		seconds.subscribe(l -> System.out.println("Observer 3: " + l));
		Thread.sleep(3000);
	}
}