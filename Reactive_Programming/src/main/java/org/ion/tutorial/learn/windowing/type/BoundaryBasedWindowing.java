package org.ion.tutorial.learn.windowing.type;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class BoundaryBasedWindowing {
	public static void main(String[] args) throws InterruptedException {
		Observable<Long> cutOffs = Observable.interval(1, TimeUnit.SECONDS);
		Observable.interval(300, TimeUnit.MILLISECONDS).map(i -> (i + 1) * 300) // map to elapsed time
				.window(cutOffs)
				.flatMapSingle(obs -> obs.reduce("", (total, next) -> total + (total.equals("") ? "" : "|") + next))
				.subscribe(System.out::println);
		Thread.sleep(5000);
	}
}