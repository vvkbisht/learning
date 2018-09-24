package org.ion.tutorial.learn.buffering.type;

import java.util.HashSet;

import io.reactivex.Observable;

public class FixedSizeBuffering {
	public static void main(String[] args) {
		Observable.range(1, 50).buffer(8).subscribe(System.out::println);
		System.out.println("****************************************************");

		Observable.range(1, 50).buffer(8, HashSet::new).subscribe(System.out::println);
		System.out.println("****************************************************");
		Observable.range(1, 10).buffer(2, 3) // buffer 2 emissions but skip 3 before the next buffer starts
				.subscribe(System.out::println);
		System.out.println("****************************************************");
		Observable.range(1, 10)
		.buffer(2, 1) //If skip is less than count, you can get some interesting rolling buffers
		.filter(c -> c.size() == 2).subscribe(System.out::println);
	}
}