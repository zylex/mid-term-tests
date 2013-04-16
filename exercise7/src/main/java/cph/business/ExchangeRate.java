package cph.business;

public interface ExchangeRate {
	double getRate(String inputCurrency, String outputCurrency);
}
