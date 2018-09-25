package org.ion.tutorial.learn.exercise.client;

import org.ion.tutorial.learn.exercise.service.impl.TickerServiceImpl;
import org.ion.tutorial.learn.exercise.subscriber.ConsoleSubscriber;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		new TickerServiceImpl().getTickerPrice("sds")
		.blockingSubscribe(new ConsoleSubscriber());
	}
}
