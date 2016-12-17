package shapes; 

public abstract class Shapes { 
   private String name; 
   
   public Shapes(String name) { 
      this.name = name; 
   } 
   
   public abstract double getArea(); 
   public abstract double getPrimeter(); 
   
}