package org.ion.tutorial.learn.exercise.service;


import org.ion.tutorial.learn.exercise.model.TickerData;

import io.reactivex.Observable;

public interface TickerService {
	
	public  Observable<TickerData> getTickerPrice(String sym);

}
