package org.ion.tutorial.learn.windowing.type;

import io.reactivex.Observable;

public class FixedSizeWindowing {
	public static void main(String[] args) {
		Observable.range(1, 50).window(8)
				.flatMapSingle(obs -> obs.reduce("", (total, next) -> total + (total.equals("") ? "" : "|") + next))
				.subscribe(System.out::println);
		System.out.println("************************************************");
		Observable.range(1, 50).window(2, 3)
				.flatMapSingle(obs -> obs.reduce("", (total, next) -> total + (total.equals("") ? "" : "|") + next))
				.subscribe(System.out::println);
	}
}