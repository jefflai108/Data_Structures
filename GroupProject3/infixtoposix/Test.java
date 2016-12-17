package infixtoposix;

public class Test {
    public static void main(String[] args) {
        String input = "((4+8)*(6-5))/((3-2)*(2+2))";
        InToPost<String> output = new InToPost<String>(input);
        System.out.println(output.convertToPost());
        
//        String input = "1+2*4/5-7+3/6";
//        InToPost<String> output = new InToPost<String>(input);
//        System.out.println(output.convertToPost());
//        48+65-*32-22+*/
    }
}
