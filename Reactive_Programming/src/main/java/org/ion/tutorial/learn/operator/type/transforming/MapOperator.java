package org.ion.tutorial.learn.operator.type.transforming;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import io.reactivex.Observable;

public class MapOperator {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
		Observable.just("1/3/2016", "5/9/2016", "10/12/2016").map(s -> LocalDate.parse(s, dtf))
				.subscribe(i -> System.out.println("RECEIVED: " + i));
	}
}