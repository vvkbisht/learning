package org.ion.tutorial.learn.multicasting.subject;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class SubjectUsage {
	public static void main(String[] args) {
		Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS)
				.map(l -> (l + 1) + " seconds")
				.doOnNext((x) -> System.out.println("1st Source is  emitting! "+x));
		
		Observable<String> source2 = Observable.range(1,10)
				.map(l -> ((l + 1) * 300) + " milliseconds")
				.doOnComplete(() -> System.out.println("2nd Source is done emitting!"));
		Subject<String> subject = PublishSubject.create();
		subject.subscribe(System.out::println); //subject acting as observable
		source1.subscribe(subject); //subject acting as observer 
		source2.subscribe(subject); //subject acting as observer
		sleep(4000);
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}