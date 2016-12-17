package linkedList;

public class LinkedList {
	// 300->200->100
	
	public static void print(Node r) {
		Node t = r;
		while (t != null) { 
			System.out.println(t.data+"->");
			t = t.next;
		}
		System.out.println("\n");
	}	
	public static void print2(Node r) { // recursive version 
		if (r == null) return; 
		System.out.println(r.data+"->");
		print2(r.next); 
	}	
	public static Node<Integer> Addtail(Node r, int item) { 
		Node cur = r; 
		if (r == null) { 
			return new Node(item); 
		}
		while (cur.next != null) { 
			cur = cur.next; 
		}
		cur.next = new Node(item); 
		return r; 
		
	}
	public static Node<Integer> delete(Node r, int v) { 
		if (r == null) return null; 
		if (r.data.equals(v)) { 
			r=r.next; 
			return r; 
		}
		Node<Integer> parent = r; 
		Node cur = r.next; 
		while (!cur.data.equals(v)) { 
			parent = cur; 
			cur = cur.next; 
			if (cur == null) break; 
		}
		if (cur != null) parent.next = cur.next; 
		return r; 
	}
	
	public static void main(String[] args) { 
		Node<Integer> head = new Node<>(300);
		Node n2 = new Node<>(100);
		Node<Integer> n1 = new Node<>(200, n2);
		head.next = n1; 
		
		print(head);
		print2(head);
		System.out.println("\n");
		Node<Integer> h = AddTail(head, 500); 
	}
}
