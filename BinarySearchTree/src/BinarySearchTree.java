
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root; 
	private class Node { 
		private Key key; 
		private Value value; 
		private Node left, right; 
		public Node(Key key, Value value) { 
			this.key = key; 
			this.value = value; 
		}
	}
	BinarySearchTree() { 
		root = null;
	}
	BinarySearchTree(Node r) { 
		this.root = r; 
	}
	public void insert(Key k, Value v) { 
		root = insert(root, k, v);
	}
	public Node insert(Node r, Key k, Value v) { 
		if (r == null) return new Node(k,v);
		int cmp = r.key.compareTo(k);
		if (cmp < 0) { r.right = insert(r.right, k, v);}
		else if (cmp > 0) { r.left = insert(r.right, k, v);}
		else r.value = v; // if the key already exists, replace the value
		return r; 
	}
	public Value get(Key key) { 
		return get(root, key);
	}
	public Value get(Node r, Key key) { 
		if (r == null) return null;
		int cmp = r.key.compareTo(key);
		if (cmp < 0) { return get(r.right, key); }
		else if (cmp > 0) { return get(r.left, key); }
		else return r.value; 
	}
	public Node delete(Key key) { 
		return delete(root, key);
	}
	public Node delete(Node r, Key key) { 
		if (r == null) return null; 
		int cmp = key.compareTo(r.key); 
		if (cmp < 0) r.left = delete(r.left, key); 
		else if (cmp > 0) r.right = delete(r.right, key);
		else { 
			if (r.right == null) return r.left; 
			if (r.left == null) return r.right; 
			Node t = r;
			r = min(t.right); 
			r.right = delmin(t.right); 
			r.left = t.left; 
		}
		return r; 
	}
	
}
