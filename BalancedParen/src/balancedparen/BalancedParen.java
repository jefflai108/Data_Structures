package balancedparen;
import java.util.Stack;

public class BalancedParen {
	public static boolean isBalanced(String s) { 
		Stack<Character> st = new Stack<>(); 
		for(int i=0; i<s.length(); i++) { 
			char c = s.charAt(i);
			if (c == '(') st.push(c);
			else if (c == ')') { 
				if (st.isEmpty()) return false; 
				st.pop();
			}
		}
		if (st.isEmpty()) return true; 
		else return false; 		
	}
	
	public static void main(String[] args) { 
		String s = "()()()())))))))"; 
		if (isBalanced(s)) System.out.println("Balanced");
		else System.out.println("Not Balanced");
	}
}
