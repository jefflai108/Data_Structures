package binarytree;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private Node root;
	private int N; // size
	private String output;
	private int level = 0;

	/*
	 * Constructor
	 */
	public BinaryTree() {
	    
	}
	
	private class Node {
		private int key;
		private Node left, right;
		
		/*
		 * Constructor
		 */
		
		public Node (int key) {
			this.key = key;
			left = null;
			right = null;
		}
	}
	
	/*
	 * Add nodes to the binary search tree. The first key should be the root.
	 * The key of one node should larger than all keys on its left, and smaller than all keys on its right.
	 * Examples: keys = [6, 5, 1, 0, 10, 8, 9, 4, 2]
	 * Tree should look like this:
	 *          6
	 *         / \
	 *        5  10
	 *       /   /
	 *      1   8
	 *     / \   \
	 *    0   4   9
	 *       /
	 *      2
	 */
	public void addNodes(int[] keys){
		for (int i = 0; i < keys.length; i++) {
		    root = add(root, keys[i]);
		}
	}
	
	private Node add(Node r, int key) {
        if (r == null) {
            return new Node(key);
        }
        if (key < r.key) {
            r.left = add(r.left, key);
        } else if (key > r.key) {
            r.right = add(r.right, key);
        } else {
            r.key = key;
        }
        return r; 
    }
	
	/*
	 * For tree of the previous example, the output of preOrder method should be:
	 * 6 5 1 0 4 2 10 8 9
	 */
	public String preOrder() {
	    output = "";
	    String temp = preOrder(root);
//	    System.out.println(temp.length());
		return temp.substring(0, temp.length()-1);
	}
	
	private String preOrder(Node r) {
	    if (r == null) return "";
	    return output + r.key + " " + preOrder(r.left) + preOrder(r.right);
	}

	/*
	 * For tree of the previous example, the output of inOrder method should be:
	 * 0 1 2 4 5 6 8 9 10
	 */
	public String inOrder() {
	    output = "";
	    String temp = inOrder(root);
//      System.out.println(temp.length());
        return temp.substring(0, temp.length()-1);
	}
	
	private String inOrder(Node r) {
	    if (r == null) return "";
        return output + inOrder(r.left) + r.key + " " + inOrder(r.right);
	}
	/*
	 * For tree of the previous example, the output of postOrder method should be:
	 * 0 2 4 1 5 9 8 10 6
	 */
	public String postOrder() {
	    output = "";
        String temp = postOrder(root);
//      System.out.println(temp.length());
        return temp.substring(0, temp.length()-1);
	}
	
	private String postOrder(Node r) {
	    if (r == null) return "";
        return output + postOrder(r.left) + postOrder(r.right) + r.key + " ";
	}
	/*
	 * For tree of the previous example, the output of levelOrder method should be:
	 * 6 5 10 1 8 0 4 9 2
	 */
	public String levelOrder() {
	    output = "";
	    String temp = level();
//	    System.out.println(temp.length());
	    return temp.substring(0, temp.length()-1);
	}
	
	private String level() {
	    if (root == null) return "";
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node t = q.poll();
            output = output + t.key + " ";
            if (t.left != null) {
                q.offer(t.left);
            }
            if (t.right != null) {
                q.offer(t.right);
            }
        }
        return output;
	}
	
	/*
	 * Return number of tree levels. For the tree of the previous example, the result should be 5. 
	 */
	public int numOfLevels() {
		return height(root) + 1;
	}
	
	private int height(Node r) {
	    if (r == null) return -1;
	    return Math.max(height(r.left), height(r.right)) + 1;
    }
	
	public int numLevel(int value) { 
	    return numLevel(root, value);
	}
	
	private int numLevel(Node r, int value) { 
	    if (r == null) return 0; 
	    if (r.key == value) return 1; 
	    if (r.key < value) return 1 + numLevel(r.right, value);
	    else return 1 + numLevel(r.left, value);
	}

    /*
	 * Return all nodes in the given level. The root is level 1.
	 * For the tree of the previous example, given 4, should return:
	 * 0 4 9
	 */
	public String nodesInLevel(int level) {
        String s = "";
        if (root == null) return s; 
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) { 
            Node t = q.poll(); 
            int temp = numLevel(root, t.key); 
            if (temp == level) s = s + t.key + " ";
            if (t.left != null) q.offer(t.left);
            if (t.right != null) q.offer(t.right);
        }
        return s.substring(0, s.length()-1); 
    }
	
    /*
     * Return all nodes in the given level. The root is level 1.
     * For the tree of the previous example, given 4, should return: 3
     */
    public int numOfNodesInLevel(int level) {
        int count = 0; 
        if (root == null) return 0; 
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) { 
            Node t = q.poll(); 
            int temp = numLevel(root, t.key); 
            if (temp == level) count++;
            if (t.left != null) q.offer(t.left);
            if (t.right != null) q.offer(t.right);
        }
        return count; 
    }
	
	/*
	 * Given a value, return the tree node with the key of that value. 
	 * Return null if cannot find such node.
	 */
	public Node findNode (int value) {
		return findNode(root, value);
	}
	
	private Node findNode(Node r, int value) {
	    if (r == null) return null;
	    if (value == r.key) return r;
	    else if (value > r.key) return findNode(r.right, value);
	    else return findNode(r.left, value);
	}
	/*
	 * Return the path from the given node to the node with key of the given value. 
	 * Return empty string if cannot find such path.
	 */
	public String path(Node node, int value) {
	    if (findNode(node, value) == null) return "";
	    String temp = path2(node, value, "");
	    return temp.substring(0, temp.length());
	}
	
	private String path2(Node r, int value, String s) {
	    if (r == null) return s;
	    if (r.key == value) return s + r.key;
	    else if (r.key < value) {
	        return s + r.key + " " + path2(r.right, value, s);
	    } else {
	        return s + r.key + " " + path2(r.left, value, s);
	    }
	    
	}
	
	public static void main(String[] args) {
	    int[] example1 = {6, 5, 1, 0, 10, 8, 9, 4, 2};
	    BinaryTree tree1 = new BinaryTree();
        tree1.addNodes(example1);
//        assertEquals("6 5 1 4", tree1.path(tree1.findNode(6), 4));
//        System.out.println(tree1.numOfNodesInLevel(2));
        System.out.println(tree1.nodesInLevel(1));
       

	}
}
