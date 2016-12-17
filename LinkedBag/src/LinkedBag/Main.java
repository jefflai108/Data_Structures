package LinkedBag;

public class Main {

	public static void main(String[] args) {
		LinkedBag<Integer> bag = new LinkedBag<>(); 		
		for(int i=1; i<=5; i++) bag.insert(i);
		System.out.println("Size: " + bag.size());
	}
}
