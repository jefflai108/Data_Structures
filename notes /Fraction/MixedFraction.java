package fraction; 

public class MixedFraction extends Fractino { 
   public MixedFraction(int i, int n, int d) { 
      super(i*d+n, d); 
   }
   
   @Override 
   public String toString() { 
      int i = numerator / denominator; 
      int n = numerator % denominator; 
      int d = denominator; 
      return ""; 
   }  
    
}  