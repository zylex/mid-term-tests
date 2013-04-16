package cph.business;

public class Currency {
	private String units;
	private double amount;

	public Currency(double amount, String units) {
		this.amount = amount;
		this.units = units;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Currency)) {
			return false;
		}
		Currency other = (Currency) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount)) {
			return false;
		}
		if (units == null) {
			if (other.units != null) {
				return false;
			}
		} else if (!units.equals(other.units)) {
			return false;
		}
		return true;
	}

	public Currency toEuros(ExchangeRate converter) {
		double rate = converter.getRate(units, "EUR");

		double eurAmount = amount * rate;

		Currency result = new Currency(eurAmount, "EUR");

		return result;
	}
}
