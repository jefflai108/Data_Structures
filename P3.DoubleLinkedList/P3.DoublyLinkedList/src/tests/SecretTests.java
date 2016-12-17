package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import listClasses.BasicDoubleLinkedList;
import listClasses.SortedDoubleLinkedList;
import org.junit.Test;


public class SecretTests {

	
	@Test
	public void test1() {
		/* Removing all elements using retrieveFirstElement */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("Zebra").addToEnd("Bear").addToEnd("Dove");	
		String answer = "", dataRetrieved;
		while ((dataRetrieved = blist.retrieveFirstElement()) != null) {
			answer += dataRetrieved;
		}
		answer += blist.getFirst();
		answer += blist.getLast();
		
		assertEquals(answer, "ZebraBearDovenullnull");
	}
	
	@Test
	public void test2() {
		/* Removing all elements using retrieveLastElement */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("Tom").addToEnd("Albert").addToEnd("Luisa");
		String answer ="", dataRetrieved;
		while ((dataRetrieved = blist.retrieveLastElement()) != null) {
			answer += dataRetrieved;
		}
		answer += blist.getFirst();
		answer += blist.getLast();
			
		assertEquals(answer, "LuisaAlbertTomnullnull");
	}
	
	@Test
	public void test3() {
		/* Removing elements from empty list */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		String answer ="", dataRetrieved;
		while ((dataRetrieved = blist.retrieveLastElement()) != null) {
			answer += dataRetrieved;
		}
		answer += blist.getFirst();
		answer += blist.getLast();
		
		assertEquals(answer, "nullnull");
	}
	
	@Test
	public void test4() {
		/* Adding elements alternating between front and end */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		blist.addToFront("Jose").addToEnd("Mary").addToFront("Peter").addToEnd("Luke");
		
		assertEquals(listContents(blist), "PeterJoseMaryLuke");
	}

	@Test
	public void test5() {
		/* Removing elements using remove (removing 1 element at the beginning) */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("2").addToEnd("1");
		blist.remove("2", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals("1", listContents(blist));
	}
	
	@Test
	public void test6() {
		/* Removing elements using remove (removing 1 element at the end) */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("2").addToEnd("1");
		blist.remove("1", String.CASE_INSENSITIVE_ORDER);
	
		assertEquals("2", listContents(blist));
	}
	
	@Test
	public void test7() {
		/* Removing elements using remove (removing more than 1 element at the beginning) */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("2").addToEnd("2").addToEnd("3").addToEnd("4").addToEnd("5");
		blist.remove("2", String.CASE_INSENSITIVE_ORDER);
		blist.remove("3", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals("45", listContents(blist));
	}
	
	@Test
	public void test8() {
		/* Removing elements using remove (removing more than 1 element at the end) */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("1").addToEnd("2").addToEnd("4").addToEnd("3").addToEnd("3");
		blist.remove("3", String.CASE_INSENSITIVE_ORDER);
		blist.remove("4", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals("12", listContents(blist));
	}
	
	@Test
	public void test9() {
		/* Removing elements using remove (alternating elements) */
		BasicDoubleLinkedList<String> blist = new BasicDoubleLinkedList<String>();
		
		blist.addToEnd("1").addToEnd("2").addToEnd("1").addToEnd("2").addToEnd("1");
		blist.remove("2", String.CASE_INSENSITIVE_ORDER);
		
		assertEquals("111", listContents(blist));
	}
	
	private static String listContents(BasicDoubleLinkedList<String> list) {
		String answer = "";
		for (String entry : list) {
			answer += entry;
		}
		return answer;
	}
	
	private static String listContentsIntegers(BasicDoubleLinkedList<Integer> list) {
		String answer = "";
		for (Integer entry : list) {
			answer += entry + "";
		}
		return answer;
	}	
}
