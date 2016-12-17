package shapes; 

public class Circle extends Shape { 
   private double radius;  
   
   public Circle(double r) { 
      super("Circle"); 
      radius = r; 
   } 
   
   @Override 
   public double getArea() { 
      return radius*radius*Math.Pi; 
   } 
   
}
      