package tests;
import static org.junit.Assert.*;
import infixtoposix.InToPost;

import org.junit.Test;

public class PublicTests {

	@Test
	public void test1() {
		String input = "1+2*3/3";
		InToPost<String> output = new InToPost<String>(input);
		assertTrue((output.convertToPost()).equals("123*3/+"));
	}
	
	@Test
	public void test2() {
		String input = "(15/5)+(10-3)";
		InToPost<String> output = new InToPost<String>(input);
		assertTrue((output.convertToPost()).equals("155/103-+"));
	}
	
	@Test
	public void test3() {
		String input = "1+2*4/5-7+3/6";
		InToPost<String> output = new InToPost<String>(input);
		assertTrue((output.convertToPost()).equals("124*5/+7-36/+"));
	}
	
	@Test
	public void test4() {
		String input = "(4+8)*(6-5)/((3-2)*(2+2))";
		InToPost<String> output = new InToPost<String>(input);
		assertTrue((output.convertToPost()).equals("48+65-*32-22+*/"));
	}
	
	@Test
	public void test5() {
		String input = "(300+23)*(43-21)/(84+7)";
		InToPost<String> output = new InToPost<String>(input);
		assertTrue((output.convertToPost()).equals("30023+4321-*847+/"));
	}
	
	@Test
	public void test6() {
		String input = "(+)*(-)/(*)";
		InToPost<String> output = new InToPost<String>(input);
		assertTrue((output.convertToPost()).equals("+-**/"));
	}

}
