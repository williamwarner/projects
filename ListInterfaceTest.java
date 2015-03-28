package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListInterfaceTest {

	private ListInterface<String> list;
	private ListInterface<Integer> tits;
	
	@Before
	public void setup(){
          list = new RecursiveList<String>();
          tits = new RecursiveList<Integer>();
          ListInterface<String> l2 = new RecursiveList<String>();
	}
	
	@Test (timeout = 500)
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
		list.insertFirst("world");
		assertEquals(2, list.size());
		list.insertFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
	}
	@Test (timeout = 500)
	public void testIndexBasedAddRemove() {
		tits.insertFirst(1);
		assertEquals(1, (int)tits.removeLast());
		tits.insertFirst(2);
		tits.insertFirst(3);
		tits.insertFirst(4);
		tits.insertFirst(5);
		assertEquals("", 4, tits.size());
		assertEquals(5, (int)tits.getFirst());
		assertEquals(3, (int)tits.get(2));
		assertEquals(2, (int)tits.removeLast());
		tits.insertLast(2);
		assertEquals("", 4, tits.size());
		assertEquals(2, (int)tits.removeLast());
		assertEquals("", 3, tits.size());
		assertEquals(3, (int)tits.removeAt(2));
		assertEquals(5, (int)tits.removeFirst());
		assertEquals("", 1, tits.size());
		assertEquals(4, (int)tits.getFirst());
		assertEquals(4, (int)tits.getLast());
		assertEquals(4, (int)tits.get(0));
		assertEquals(4, (int)tits.removeAt(0));
		assertTrue(tits.isEmpty());
	}
	@Test (timeout = 500)
	public void testElementBasedAddRemove() {
		tits.insertLast(1);
		tits.insertLast(2);
		tits.insertLast(3);
		tits.insertLast(4);
		tits.insertAt(4,5);
		assertEquals(0, tits.indexOf(1));
		assertEquals(1, (int)tits.get(0));
		assertEquals(2, (int)tits.get(1));
		assertEquals(3, (int)tits.get(2));
		assertEquals(4, (int)tits.get(3));
		assertEquals(5, (int)tits.getLast());
		assertEquals(4, (int)tits.indexOf(5));
		assertTrue(tits.remove(5));
		assertFalse(tits.remove(5));
		assertEquals(-1, (int)tits.indexOf(5));
		assertEquals(4, (int)tits.getLast());
		tits.insertLast(6);
		assertEquals(6, (int)tits.getLast());
		tits.insertAt(4,5);
		assertEquals(4, (int)tits.indexOf(5));
		assertEquals("", 6, tits.size());
		
		ListIterator<Integer> test = (ListIterator<Integer>) tits.iterator();
		int count = 1;
		while(test.hasNext()){
			assertEquals(count, (int)test.next());
			count++;
		}
	}
	@Test (timeout = 500, expected=IllegalStateException.class)
	public void BorkThatShizzle() {
		tits.insertLast(1);
		tits.insertLast(2);
		tits.removeLast();
		tits.removeLast();
		tits.removeLast();
		
	}
	@Test (timeout = 500, expected=NullPointerException.class)
	public void BorkThat() {
		Integer elem = null;
		tits.insertFirst(elem);
		
	}
	@Test (timeout = 500, expected=IndexOutOfBoundsException.class)
	public void Borker() {
		Integer elem = 2;
		tits.insertFirst(elem);
		tits.get(-1);
		
	}
}
