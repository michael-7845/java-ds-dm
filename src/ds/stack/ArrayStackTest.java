package ds.stack;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayStackTest {
	
	private ArrayStack<Integer> s;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.s = new ArrayStack<Integer>(Integer.class, 10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testArrayStack() {
		Assert.assertEquals(s.length, 0);
		Assert.assertEquals(s.maxsize, 10);
		Assert.assertEquals(s.top, -1);
	}

	@Test
	public void testInit() {
		s.init();
		Assert.assertEquals(s.length, 0);
		Assert.assertEquals(s.maxsize, 10);
		Assert.assertEquals(s.top, -1);
	}

	@Test
	public void testClear() {
		s.clear();
		Assert.assertEquals(s.length, 0);
		Assert.assertEquals(s.maxsize, 10);
		Assert.assertEquals(s.top, -1);
	}

	@Test
	public void testIsEmpty() {
		Assert.assertEquals(true, s.isEmpty());
		s.push(1);
		s.push(2);
		Assert.assertEquals(false, s.isEmpty());
		s.clear();
		Assert.assertEquals(true, s.isEmpty());
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
//		System.out.println(s.data.length);
//		for(int i: s.data) {
//			System.out.println(i);
//		}
		assertArrayEquals(new Integer[]{1,2,3,null,null,null,null,null,null,null}, s.data);
	}

	@Test
	public void testPop() {
		s.push(1);
		s.push(2);
		s.push(3);
		assertEquals((Integer)3, s.pop());
	}

	@Test
	public void testLength() {
		s.push(1);
		assertEquals(1, s.length());
		s.push(2);
		assertEquals(2, s.length());
	}

}
