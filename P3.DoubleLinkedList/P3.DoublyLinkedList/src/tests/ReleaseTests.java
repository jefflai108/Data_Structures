package tests;

import static org.junit.Assert.*;
import listClasses.BasicDoubleLinkedList;


import listClasses.SortedDoubleLinkedList;

import org.junit.Test;

public class ReleaseTests {

	@Test
	public void test1() {
		/* Adding elements to the end */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("Zebra").addToEnd("Bear").addToEnd("Dove");
		String answer = "";
		for (String entry : blist) {
			answer += entry;
		}
		
		assertEquals(answer, "ZebraBearDove");
	}

	@Test
	public void test2() {
		/* Adding elements to BasicDoubleLinkedList */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("Zebra").addToEnd("Bear").addToEnd("Dove");
		String answer = blist.getFirst() + blist.getLast();
		
		assertEquals(answer, "ZebraDove");
	}
	
	@Test
	public void test3() {
		/* Removing first two element */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("Zebra").addToEnd("Bear").addToEnd("Dove");	
		String answer = blist.retrieveFirstElement();
		answer += blist.retrieveFirstElement();
			
		assertEquals(answer, "ZebraBear");
	}
	
	@Test
	public void test4() {
		/* Removing last two elements */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("Tom").addToEnd("Albert").addToEnd("Luisa");
		String answer = blist.retrieveLastElement();
		answer += blist.retrieveLastElement();
		
		assertEquals(answer, "LuisaAlbert");
	}
	
	@Test
	public void test5() {
		/* Adding elements to the front end */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToFront("Toyota").addToFront("Honda").addToFront("Nissan");
		String answer = "";
		for (String entry : blist) {
			answer += entry;
		}
		
		assertEquals(answer, "NissanHondaToyota");
	}
	
	@Test
	public void test6() {
		/* Removing elements using remove (inner elements removed) */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("3").addToEnd("2").addToEnd("0").addToEnd("2").addToEnd("1");
		blist.remove("2", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals("301", listContents(blist));
	}
	
	@Test
	public void test7() {
		/* Testing getSize */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("8").addToEnd("2").addToEnd("0").addToEnd("1");
		assertEquals(blist.getSize(), 4);
	}
	
	@Test
	public void test8() {
		/* Adding elements to sorted list */
		SortedDoubleLinkedList<String> slist = new SortedDoubleLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		String answer = "";
		
		slist.add("Albert").add("Peter").add("Carlos");
		answer += listContents(slist);
		answer += slist.getSize();
		
		assertEquals(answer, "AlbertCarlosPeter3");
	}
	
	@Test
	public void test9() {
		/* Removing elements from sorted list */
		SortedDoubleLinkedList<String> slist = new SortedDoubleLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		
		slist.add("Cat").add("Dog").add("Elephant");
		slist.remove("Dog");
		
		assertEquals("CatElephant", listContents(slist));
	}
	
	private static String listContents(BasicDoubleLinkedList<String> list) {
		String answer = "";
		for (String entry : list) {
			answer += entry;
		}
		return answer;
	}
}
