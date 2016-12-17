package LinkedBag;

import org.w3c.dom.Node;

public class LinkedBag<E> implements Iterable<E> {
	private int N; // number of items
	private Node head; 
	
	private Node { 
		E data;
		Node next; 
		Node(E item) { 
			data = item; 
		}
		Node(E item, Node r) { 
			data = item; 
			next = r; 
		}
	};
	public LinkedBag() { 
		head = null; 
		N = 0; 
	}
	public void insert(E item) { 
		head = new Node(item, head); 
		N++; 
	}
	public int size() { return N; } 
	public boolean isEmpty() { return N==0; }
	public boolean contains(E item) { 
		Node cur = head; 
		while(cur != null) { 
			if(cur.data.equals(item)) return true; 
			cur = cur.next;
		}
		return false; 
	}
	
	public E get(int index) { 

		if (index >= N) return null; 
		Node cur = head; 
		for (int i=0; i<index; i++) { 
			cur = cur.next; 
			System.out.println("I am working");
		}
		return cur.data; 
		
	}
	
	@Override 
	public Iterator<E> iterator() { 
		return new BagIterator(); 
	}
	
	private class BagIterator implements Iterator<E> { 
		Node current = head; 
		@Override 
		public boolean hasNext() { 
			if (current.next != null) 
			return current != null; 
		}
		
		@Override 
		public E next() { 
			if (!hasNext()) { 
				throw new NoSuchElementException(); 
			}
			E t = current.data;
			current = current.next;
			return t; 
		}
		
		
	}
	 
	public void join(LinkedBag<E> l) { 
		for(int i=0; i<l.size(); i++) { 
			insert(l.get(i)); 
		}
		
	}
	
}
