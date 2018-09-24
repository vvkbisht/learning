package org.ion.tutorial.learn.multicasting.subject;

import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class ReplaySubjectDemo {
	public static void main(String[] args) {
		Subject<String> subject = ReplaySubject.create();
		subject.subscribe(s -> System.out.println("Observer 1: " + s));
		subject.onNext("Alpha");
		subject.onNext("Beta");
		subject.onNext("Gamma");
		subject.onComplete();
		subject.subscribe(s -> System.out.println("Observer 2: " + s));
	}
}