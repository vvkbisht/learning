package org.ion.tutorial.learn.multicasting.subject;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.Subject;

public class AsyncSubjectDemo {
	public static void main(String[] args) {
		Subject<String> subject = AsyncSubject.create();
		subject.subscribe(s -> System.out.println("Observer 1: " + s), Throwable::printStackTrace,
				() -> System.out.println("Observer 1 done!"));
		subject.onNext("Alpha");
		subject.onNext("Beta");
		subject.onNext("Gamma");
		subject.onComplete();
		subject.subscribe(s -> System.out.println("Observer 2: " + s), Throwable::printStackTrace,
				() -> System.out.println("Observer 2 done!"));
	}
}