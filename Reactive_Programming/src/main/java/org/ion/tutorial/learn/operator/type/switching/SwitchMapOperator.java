package org.ion.tutorial.learn.operator.type.switching;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class SwitchMapOperator {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> items = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta",
				"Iota");
		// delay each String to emulate an intense calculation
		Observable<String> processStrings = items
				.concatMap(s -> Observable.just(s).delay(randomSleepTime(), TimeUnit.MILLISECONDS));
		// run processStrings every 5 seconds, and kill each previous instance to start
		// next
		Observable.interval(5, TimeUnit.SECONDS)
				.switchMap(i -> processStrings.doOnDispose(() -> System.out.println("Disposing! Starting next")))
				.subscribe(System.out::println);
		// keep application alive for 20 seconds
		Thread.sleep(20000);
	}

	public static int randomSleepTime() {
		// returns random sleep time between 0 to 2000 milliseconds
		return ThreadLocalRandom.current().nextInt(2000);
	}
}