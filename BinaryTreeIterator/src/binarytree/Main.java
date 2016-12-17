package binarytree;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		BinaryTreeIterator bt = new BinaryTreeIterator();
		
		
		System.out.println("\n inOrder traversal:");
		bt.inOrder();
		System.out.println("\n inOrder Iterator:");
		Iterator<Integer> iter = bt.iterator();
		while(iter.hasNext()){
			Integer i = iter.next();
			System.out.print(i+",");
		}
		
		System.out.println("\n inOrder Iterator:");
		for(Integer i:bt){
			System.out.print(i+",");
		}
		
}

}
