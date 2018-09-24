package org.ion.tutorial.learn.backpressure.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class FlowableDemo {
	public static void main(String[] args) {
		//ObservableWithoutScheduler();
		//ObservableWithScheduler();
		Flowable();
	}

	private static void ObservableWithoutScheduler() {
		Observable.range(1, 999_999_999).map(MyItem::new).subscribe(myItem -> {
			sleep(50);
			System.out.println("Received MyItem " + myItem.id);
		});

	}

	private static void ObservableWithScheduler() {
		Observable.range(1, 999999999).map(MyItem::new).observeOn(Schedulers.io()).subscribe(myItem -> {
			sleep(50);
			System.out.println("Received MyItem " + myItem.id);
		});
		sleep(Long.MAX_VALUE);
	}

	private static void Flowable() {
		Flowable.range(1, 999999999).map(MyItem::new).observeOn(Schedulers.io()).subscribe(myItem -> {
			sleep(50);
			System.out.println("Received MyItem " + myItem.id);
		});
		sleep(Long.MAX_VALUE);
	}

	static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static final class MyItem {
		final int id;

		MyItem(int id) {
			this.id = id;
			System.out.println("Constructing MyItem " + id);
		}
	}
}