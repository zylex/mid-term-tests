package genlistx.tests;

import static org.junit.Assert.*;
import genlistx.GenListX;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SizeIsZeroTests {
	
	private GenListX testList;

	@Before
	public void setUp() throws Exception {
		testList = new GenListX();
		assertTrue(testList.size() == 0);
	}

	@Test
	public void testAddObject_successfullyAdded() {
		testList.add(0, "Object");
		assertTrue(testList.size() > 0);
		Object obj = testList.get(0);
		assertTrue(obj instanceof String);
		String str = (String) obj;
		assertTrue(str.equals("Object"));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddObject_indexOutOfBounds() {
		testList.add(1, new Object());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testFetchObject_indexOutOfBounds_sizeWasZero() {
		testList.get(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveObject_indexOutOfBounds_sizeWasZero() {
		testList.remove(0);
	}
}
