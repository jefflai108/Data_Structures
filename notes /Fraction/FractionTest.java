package test; 

import static org.junit.Assert.*; 

public class FractionTest { 

   @Test 
   public void testConstructor1() { 
      Fraction f1 = new Fraction(5,10); 
      String resultString = f1.toString(); 
      String answer = "1/2"; 
      assertEquals(result, answer); 
   } 
   
   @Test 
   public void testgcd() { 
      Fraction f1 = new Fraction(-500, -1000); 
      String result = f1.toString(); 
      String answer = "1/2"; 
      assertEqauls(result, answer); 
   } 
} 