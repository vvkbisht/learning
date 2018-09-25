package org.ion.tutorial.learn.exercise.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class TickerUtil {

	public static double getRandomNumberBetweenRange(double min, double max) {
		Random r = new Random();
		return r.doubles(min, (max)).limit(1).findFirst().getAsDouble();
	}
	
	public static double getPrecisionedValue(double value, int precision) {
		return  BigDecimal.valueOf(value)
		    .setScale(precision, RoundingMode.CEILING)
		    .doubleValue();
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
		System.out.println(getRandomNumberBetweenRange(103.2343,104.8873) + "   "+getPrecisionedValue(getRandomNumberBetweenRange(103.2343,104.8873),2));
		}
	}
}
