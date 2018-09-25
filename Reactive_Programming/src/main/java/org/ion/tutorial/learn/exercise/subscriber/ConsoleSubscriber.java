package org.ion.tutorial.learn.exercise.subscriber;

import java.time.Instant;

import org.ion.tutorial.learn.exercise.model.TickerData;

import io.reactivex.observers.ResourceObserver;

public class ConsoleSubscriber extends ResourceObserver<TickerData> {

	@Override
	public void onComplete() {
		System.out.println("complete");

	}

	@Override
	public void onError(Throwable arg0) {
		System.out.println(arg0);

	}

	@Override
	public void onNext(TickerData arg0) {
		System.out.println(Instant.now() + "  " + arg0.getSymbol() + "  " + arg0.getTradeType() + "  "
				+ arg0.getVolume() + "  " + arg0.getPrice());

	}
}
