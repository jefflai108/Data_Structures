package shapes; 

public class Main { 

   public static void main(String[] args) { 
      Shapes[] shapes = new Shape[3]; 
      shapes[0] = new Rectangle(10,20); 
      shapes[1] = new Circle(10);
      shapes[2] = new Square(10); 
      ArrayList<Shape> ar = new ArrayList<>();
       
      for (Shape s: shapes) { 
         System.out.println(s.getName()); 
         System.out.println(s.getArea()); 
         System.out.println(s.getPrimeter()); 
      } 
    } 
} 