package org.ion.tutorial.learn.multicasting.autoconnect;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class AutoConnectOperator {
	public static void main(String[] args) throws InterruptedException {
		//Demo1();
		Demo2();
	}

	private static void Demo2() throws InterruptedException {
		Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS).publish().autoConnect();
		// Observer 1
		seconds.subscribe(i -> System.out.println("Observer 1: " + i));
		Thread.sleep(3000);
		// Observer 2
		seconds.subscribe(i -> System.out.println("Observer 2: " + i));
		Thread.sleep(3000);
	}

	private static void Demo1() {
		Observable<Integer> threeRandoms = Observable.range(1, 3).map(i -> randomInt()).publish().autoConnect(2);
		// Observer 1 - print each random integer
		threeRandoms.subscribe(i -> System.out.println("Observer 1:" + i));
		// Observer 2 - sum the random integers, then print
		threeRandoms.reduce(0, (total, next) -> total + next).subscribe(i -> System.out.println("Observer 2: " + i));

		// Observer 3 - receives nothing
		threeRandoms.subscribe(i -> System.out.println("Observer 3:" + i));
	}

	public static int randomInt() {
		return ThreadLocalRandom.current().nextInt(100000);
	}
}