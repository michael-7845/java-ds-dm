package ds.stack;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinkedStackTest {
	
	private LinkedStack<Integer> s;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.s = new LinkedStack<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLinkedStack() {
		assertEquals(0, s.length);
		assertEquals(null, s.top);
	}

	@Test
	public void testInit() {
		s.push(1);
		s.init();
		assertEquals(0, s.length);
		assertEquals(null, s.top);
	}

	@Test
	public void testClear() {
		s.push(1);
		s.clear();
		assertEquals(0, s.length);
		assertEquals(null, s.top);
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, s.isEmpty());
		s.push(1);
		s.push(2);
		assertEquals(false, s.isEmpty());
		s.clear();
		assertEquals(true, s.isEmpty());
	}

	@Test
	public void testGetTop() {
		s.push(1);
		Assert.assertEquals((Integer)1, s.getTop());
		s.push(2);
		assertEquals((Integer)2, s.getTop());
	}

	@Test
	public void testPush() {
		s.push(1);
		s.push(2);
		s.push(3);
		for(int i=3; i>0; i--) {
			assertEquals((Integer)i, s.pop());
		}
	}

	@Test
	public void testPop() {
		s.push(1);
		s.push(2);
		s.push(3);
		for(int i=3; i>0; i--) {
			Integer value = s.pop();
			System.out.println(value);
			assertEquals((Integer)i, value);
		}
	}

	@Test
	public void testLength() {
		s.push(1);
		System.out.println(s.top.value);
		System.out.println(s.length);
		assertEquals(1, s.length());
		s.push(2);
		assertEquals(2, s.length());
	}

}
