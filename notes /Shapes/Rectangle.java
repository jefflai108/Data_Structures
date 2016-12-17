package shapes; 

public class Rectangle extends Shape { 
   private double height; 
   private double width; 
   
   public Rectangle(double h, double w) { 
      this.height = h; 
      this.width = w; 
   } 
   
   @Override 
   public double getArea() { 
      return height * width; 
   } 
   
}
      