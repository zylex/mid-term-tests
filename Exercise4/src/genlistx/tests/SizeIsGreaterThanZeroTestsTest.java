package genlistx.tests;

import static org.junit.Assert.*;
import genlistx.GenListX;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SizeIsGreaterThanZeroTestsTest {

	private GenListX testList;
	
	@Before
	public void setUp() throws Exception {
		testList = new GenListX();
		testList.add("Object 1");
		testList.add("Object 2");
		testList.add("Object 3");
		assertTrue(testList.size() == 3);
	}

	@Test
	public void testAddObject_successfullyAdded() throws Exception {
		testList.add(2, "Another Object");
		assertTrue(testList.size() == 4);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddObject_indexOutOfBounds() {
		testList.add(-1, new Object());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveObject_indexOutOfBounds() {
		testList.remove(-1);
	}
	
	@Test
	public void testRemoveObject_successfullyRemoved_sizeWasGreaterThanOne() {
		testList.remove(0);
		assertTrue(testList.size() == 2);
	}
	
	@Test
	public void testRemoveObject_successfullyRemoved_sizeWasOne() {
		testList.remove(2);
		testList.remove(1);
		assertTrue(testList.size() == 1);
		Object obj = testList.remove(0);
		assertTrue(obj instanceof String);
		String str = (String) obj;
		assertTrue(str.equals("Object 1"));
		assertTrue(testList.size() == 0);
	}
	
	@Test
	public void testFetchObject_returnedObject_sizeIsGreaterThanOne() {
		assertTrue(testList.size() > 1);
		Object obj = testList.get(2);
		assertTrue(obj instanceof String);
		String str = (String) obj;
		assertTrue(str.equals("Object 3"));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testFetchObject_indexOutOfBounds_sizeWasGreaterThanZero() {
		assertTrue(testList.size() > 1);
		testList.get(-1);
	}
	

}
