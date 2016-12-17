package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import listClasses.BasicDoubleLinkedList;
import listClasses.SortedDoubleLinkedList;

public class StudentTests {

	@Test
	public void test() {
			SortedDoubleLinkedList<String> blist = new SortedDoubleLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
			blist.add("a").add("a").add("a").add("b").add("pieceofShit");
			blist.remove("a");
			blist.remove("b");
			blist.addToFront("shit");
			System.out.println(blist.getSize());
			for (String entry : blist) {
				System.out.print(entry + " ");
			}
			//System.out.println(answer);
			
			//assertEquals(answer, "ZebraBearDovenullnull");
	}

}
