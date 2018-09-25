package org.ion.tutorial.learn.exercise.model;

import lombok.Builder;

public class TickerData {
	private String symbol;
	private String tradeType;
	private long volume;
	private long price;

	public TickerData(String symbol, String tradeType, long volume, long price) {
		super();
		this.symbol = symbol;
		this.tradeType = tradeType;
		this.volume = volume;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	/*public static class TickerDataBuilder {
		
		private TickerData;
		
		pub;ic TickerDataBuilder()
		private String symbol;
		private String tradeType;
		private long volume;
		private long price;

		public TickerData build(TickerDataBuilder builder) {
			return new TickerData(builder.symbol, builder.tradeType, builder.volume, builder.price);
		}
		
		public TickerDataBuilder symbol(String symbol) {
			return this.symbol=symbol
		}
	}*/
}
