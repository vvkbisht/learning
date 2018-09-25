package org.ion.tutorial.learn.exercise.service.impl;

import java.util.concurrent.TimeUnit;

import org.ion.tutorial.learn.exercise.model.TickerData;
import org.ion.tutorial.learn.exercise.service.TickerService;

import io.reactivex.Observable;

public class TickerServiceImpl implements TickerService {

	@Override
	public Observable<TickerData> getTickerPrice(String sym) {
		// TODO Auto-generated method stub
		return Observable.timer(1, TimeUnit.SECONDS)
				.flatMap(x -> Observable.fromCallable(() -> new TickerData("GOO","BUY",10000,12)))
				.repeat();
	}

}
