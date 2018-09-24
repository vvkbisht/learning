package org.ion.tutorial.learn.multicasting.subject;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

public class UnicastSubjectDemo {
	public static void main(String[] args) throws InterruptedException {
		Demo1();
		Demo2();
	}

	private static void Demo2() throws InterruptedException {
		Subject<String> subject = UnicastSubject.create();
		Observable.interval(300, TimeUnit.MILLISECONDS).map(l -> ((l + 1) * 300) + " milliseconds").subscribe(subject);
		Thread.sleep(2000);
		// multicast to support multiple Observers
		Observable<String> multicast = subject.publish().autoConnect();
		// bring in first Observer
		multicast.subscribe(s -> System.out.println("Observer 1: " + s));
		Thread.sleep(2000);
		// bring in second Observer
		multicast.subscribe(s -> System.out.println("Observer 2: " + s));
		Thread.sleep(1000);
	}

	private static void Demo1() throws InterruptedException {
		Subject<String> subject = UnicastSubject.create();
		Observable.interval(300, TimeUnit.MILLISECONDS).map(l -> ((l + 1) * 300) + " milliseconds").subscribe(subject);
		Thread.sleep(2000);
		subject.subscribe(s -> System.out.println("Observer 1: " + s));
		Thread.sleep(2000);
	}
}