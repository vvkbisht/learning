package org.ion.tutorial.learn.buffering.type;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class TimeBasedBuffering {
	public static void main(String[] args) throws InterruptedException {
		/*Observable.interval(300, TimeUnit.MILLISECONDS).map(i -> (i + 1) * 300) // map to elapsed time
				.buffer(1, TimeUnit.SECONDS).subscribe(System.out::println);
		Thread.sleep(3000);*/
		System.out.println("****************************************************");
		Observable.interval(300, TimeUnit.MILLISECONDS).map(i -> (i + 1) * 300) // map to elapsed time
				.buffer(1, TimeUnit.SECONDS, 2).subscribe(System.out::println);
		Thread.sleep(3000);
	}
}