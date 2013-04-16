import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import cph.business.Currency;
import cph.business.ExchangeRate;


public class CurrencyTest {
	
	Currency currency;
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery(); 

	@Test
	public void testToEuros() {
		double expectedAmount = 75;
		String expectedUnits = "EUR";
		Currency expectedResult = new Currency(expectedAmount, expectedUnits);
		
		currency = new Currency(100, "USD");
		
		final ExchangeRate converter = context.mock(ExchangeRate.class);
		
		context.checking(new Expectations() {{
			oneOf(converter).getRate("USD", "EUR"); will(returnValue(0.75));
		}});
		
		Currency result = currency.toEuros(converter);
		
		assertNotNull(result);
		assertTrue(result.equals(expectedResult));
	}

}
