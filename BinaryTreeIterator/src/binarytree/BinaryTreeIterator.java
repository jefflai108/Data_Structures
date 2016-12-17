package binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeIterator implements Iterable<Integer> {
	private Node root;
	private class Node{
		private Integer key;
		private Node left, right;
		public Node(Integer k){
			key = k;
		}
		@Override
		public String toString(){
			StringBuilder s = new StringBuilder();
			s.append("Node:{");
			if(left != null){
				s.append(left.key+",");
			}else{
				s.append("null,");
			}
			s.append(key+",");
			if(right != null){
				s.append(right.key);
			}else{
				s.append("null");
			}
			s.append("}");
			return s.toString();
		}
	}
	/**
	 *           2
	 *       /       \
	 *    7            50
	 *  /  \             \
	 * 20    6              9
	 *     /  \           /
	 *    5   11         4 
	 *  /
	 */
	//20,5,11,6,7,4,9,50,2
	//preorder: 2,7,20,6,5,11,50,9,4
	//inOrder: 20,7,5,6,11,2,50,4,9,
	
	private void create(){
		root = new Node(2);
		root.left = new Node(7);
		root.left.left = new Node (20);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		//root.left.right.left.left = new Node(55);
		root.left.right.right = new Node(11);
		
		root.right = new Node(50);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);
	}
	public BinaryTreeIterator(){
		create();
	}
	public void preOrder(){
		preOrder(root);
	}
	
	private void preOrder(Node r){
		if(r==null) return;
		System.out.print(r.key+",");
		preOrder(r.left);
		preOrder(r.right);
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	private void inOrder(Node r){
		if(r==null) return;
		inOrder(r.left);
		System.out.print(r.key+",");
		inOrder(r.right);
	}
	
	public void postOrder(){
		postOrder(root);
	}
	
	private void postOrder(Node r){
		if(r==null) return;
		postOrder(r.left);
		postOrder(r.right);
		System.out.print(r.key+",");
	}
	
	public int size(){
		return size(root);
	}
	/**
	 *           2
	 *       /       \
	 *    7            50
	 *  /  \             \
	 * 20    6              9
	 *     /  \           /
	 *    5   11         4
	 *    
	 *  
	 */
	//2,7,50,20,6,9,5,11,4
	
	public boolean is_mirror(Node r1,Node r2){
		if(r1==null && r2!=null) return false;
		if(r2==null && r1!=null) return false;
		if(r1 == null && r2==null) return true;
		
		return r1.key == r2.key &&
				is_mirror(r1.left, r2.right)
				&& is_mirror(r1.right, r2.left);
		
	}
	
	public Node mirror(Node r){
		if(r==null) return null;
		Node t = r.left;
		r.left = r.right;
		r.right = t;
		mirror(r.left);
		mirror(r.right);
		return r;
	}
	
	public void levelOrder(){
		if(root == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node t = q.poll();
			System.out.print(t.key+",");
			if(t.left!= null) q.add(t.left);
			if(t.right!= null) q.add(t.right);
		}
	}
	
	public int height(){
		return height(root);
	}
	private int height(Node r){
		if(r == null) return -1;
		return 1 + Math.max(height(r.left), height(r.right));
	}
	private int size(Node r){
		if(r==null) return 0;
		return 1 + size(r.left) + size(r.right);
	}
	public int sum(){
		return sum(root);
	}
	private int sum(Node r){
		
		if(r ==null) return 0;
		return r.key + sum(r.left) + sum(r.right);
	}
	
	public int diameter(){
		return diameter(root);
	}
	private int diameter(Node r){
		if(r==null) return 0;
		int d1 = diameter(r.right);
		int d2 = diameter(r.left);
		int d3 = 1 + height(r.left) + 1 + height(r.right);
		return Math.max(Math.max(d1, d2), d3);
	}
	
	public void path(Integer key){
		path(root,key);
	}
	
	private boolean path(Node r, Integer key){
		if(r==null) return false;
		if(path(r.left,key)||path(r.right,key)||
				r.key.equals(key))
		{
			System.out.print(r.key+"->");
			return true;
		}else return false;
		
	}
	
	
	@Override
	public Iterator iterator() {	
		return new TreeIterator();
	}
	/*
	 * Inorder iteator of a binary tree
	 * 
	 */
	private class TreeIterator implements Iterator<Integer>{
		private Node cur = root;
		private Stack<Node> s;
		public TreeIterator(){
			s = new Stack<>();
			if(root != null){
				s.push(root);
			}
			Node t = s.peek();
			while(t.left!=null){
				t = t.left;
				s.push(t);
			}
		}
		@Override
		public boolean hasNext() {
			return !s.isEmpty();
		}
		/**
		 *           2
		 *       /       \
		 *    7            50
		 *  /  \             \
		 * 20    6              9
		 *     /  \           /
		 *    5   11         4
		 *    
		 *  
		 */
		@Override
		public Integer next() {
			Node t = s.pop();
			if(t.right != null){
				s.push(t.right);
				Node m = s.peek();
				while(m.left!=null){
					m = m.left;
					s.push(m);
				}
			}
			return t.key;
		}
		
	}
	
	
}
