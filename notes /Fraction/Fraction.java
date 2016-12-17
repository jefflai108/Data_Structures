package fraction; 

public class Fraction { 
protected int numerator; 
protected int denominator; 

public Fraction(int n, int d) { 
   int g = gcd(d, n); 
   numerator = n/g; 
   denominator = d/g; 
   if(denominator<0) { 
      denominator = Math.abs(denominator); 
      numerator *= -1; 
   } 
} 

@Override 
public int hashCode() { 
   return 37*numerator + denominator; 
}  

public Fraction(int n) {  
   this(n,1); 
}

public Fraction() { 
   this(0, 1); 
} 

@Override 
public String toString() { 
   if (numerator == 0) return "0"; 
   else if (denominator == 1) 
      return Integer.toString(numerator); 
   else 
      return numerator + "/" + denominator; 
} 
private int gcd(int a, int b) { 
   a = Math.abs(a); 
   b = Math.abs(b);    
   if (a<b) { 
      int t = a; 
      a = b; 
      b = t; 
   } 
   if (b == 0) return a; 
   return gcd(b, a%b); 
}

public Fraction add(Fraction other) { 
   Fraction f = new Fraction(
      numerator * other.denominator + 
      denominator * other.numerator, 
      denominator * other.denominator
      );
   return f; 
} 

@Override 
public boolean equals(Object other) { 
   if (other = this) return true; 
   if (!(other instanceOf Fraction)) return false; 
   Fraction f = (Fraction) other; 
   return numerator == f.numerator 
   &&
   denominator == f.denominator; 
} 

public boolean compareTo(Fraction other) { 
   Fraction f = this.sub(other); 
   if (numerator < 0) return -1; 
   else if (numerator > 0) return 1; 
   else return 0; 
} 

public Fraction mult(Fraction other) { 
   Fraction f = new Fraction( 
      numerator*other.numerator, 
      denominator*other.denominator
      ); 
   return f; 
} 
} 

public static void main(String[] args) { 
   Fraction f1 = new Fraction(3,4); 
   Fraction f2 = new Fraction(2,3);
   Fraction f3 = f1.add(f2); 
   //f1 + f2 // operator overloading, not good  
   Fraction f4 = f1.mult(f2); 
   System.out.println(f1 + "+" + f2 + "=" + f3);
   System.out.println(f1 + "*" + f2 + "=" + f4);  
   if (f1.equals(f2)) { 
      System.out.println("equal"); 
   } else { 
      System.out.println("not equal"); 
   } 
   
   MixedFraction m1 = new MixedFraction(2, 3, 4); 
   MixedFraction m1 = new MixedFraction(2, 3, 4); 
   Fraction f1 = m1.add(m2);   
   System.out.println(m3); 
   
}