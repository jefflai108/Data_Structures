package listClasses;

import java.util.Iterator;
import java.util.NoSuchElementException; 

public class BasicDoubleLinkedList<T> implements Iterable<T> { 
	protected Node head, tail; // head and tail reference 
	protected int size; // number of Nodes 
	
	/*
	 * Defines an empty linked list. No nodes are created.
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null; 
		size = 0; 
	}
	/*
	 * Node class that contains a data element and refernece to the next 
	 * and previous node. 
	 */
	protected class Node { 
		T data; 
		Node prev; 
		Node next; 
		public Node(T item) { 
			data = item; 
			prev = next = null; 
		}
	}
	/* 
	 * The method that returns an Iterator object. 
	 * 
	 * @return Iterator<data element>
	 */
	@Override
	public Iterator<T> iterator() {
		return new DoubleListIterator(); 
	}
	
	/*
	 * Iterator class
	 */
	private class DoubleListIterator implements Iterator<T> { 
        private int index;
        private Node current;
        DoubleListIterator(){
            current = head;
            index = 0;
        }
        
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            T item = current.data;
            current = current.next;
            index++;
            return item;
        }

        @Override
        public void remove() {
        	throw new UnsupportedOperationException("Not supported yet.");
        }
	}
	/* 
	 * Return the size of the list 
	 * 
	 * @return size
	 */
	public int getSize() { 
		return size; 
	}
	/* Adds element to the end of the list.  
	 * 
	 * @param data element 
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) { 
		if (size == 0) { // empty list 
			head = new Node(data); 
			tail = head;
			size++;
			return this; 
		} else return add(size, data); 
	}
	/* Adds element to the front of the list.  
	 * 
	 * @param data element 
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) { 
		return add(0, data);
	}
	/* Returns but does not remove the first element from the list. 
	 * If there are no elements the method returns null.
	 * 
	 * @return data element or null
	 */
	public T getFirst() { 
		if (size == 0) return null; 
		return head.data; 
	}
	/* Returns but does not remove the last element from the list. 
	 * If there are no elements the method returns null.
	 * 
	 * @return data element or null
	 */
	public T getLast() { 
		if (size == 0) return null; 
		return tail.data; 
	}
	/*
	 * Returns but does not remove the element at the index position in the list. 
	 * If there are no elements the method returns null. 
	 * 
	 * @param int index
	 * @return data element or null
	 */
	public T get(int index) { 
		if (size == 0 || index >= size || index < 0) return null; 
		Node current = head; 
		for (int i=0; i<index; i++) 
			current = current.next; 
		return current.data; 
	}
	/* Adds element at the index position in the list.  
	 * 
	 * @param int index
	 * @param data element 
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> add(int index, T data) { 
		if (index > size || index < 0) throw new NoSuchElementException("Index out of bound.");
		if (size == 0) { // empty list 
			head = new Node(data); 
			tail = head;
			size++;
			return this; 
		} 
		if (index == 0) { // add in front
			Node oldhead = head; 
			head = new Node(data); 
			head.next = oldhead;
			oldhead.prev = head; 
			size++;
			return this; 	
		}
		if (index == size) { // add to the end
			Node oldtail = tail; 
			tail = new Node(data);
			oldtail.next = tail;
			tail.prev = oldtail;
			size++;
			return this;
		}
		// add in between head and tail 
		Node current = head; 
		for (int i=0; i<index-1; i++)  
			current = current.next; 
		Node temp = new Node(data);
		Node ahead = current.next; 
		current.next = temp; 
		temp.prev = current; 
		temp.next = ahead; 
		ahead.prev = temp;
		size++; 
		return this; 
	}
	/*
	 * Removes and returns the element at the index position from the list (zero indexed). 
	 * If there are no elements the method returns null. 
	 * 
	 * @param int index
	 * @return data element or null
	 */
	public T retrieve(int index) { 
		if (size == 0 || index >= size || index < 0) return null; 
		if (index == 0) { // retrieve the first element 
			Node temp = head; 
			head = temp.next; 
			size--;
			return temp.data; 
		}
		if (index == size-1) { // retrieve the last element  
			Node temp = tail; 
			tail = temp.prev; 
			size--;
			return temp.data; 
		}
		// retrieve in between head and tail 
		Node current = head; 
		for (int i=0; i<index; i++) 
			current = current.next; 
		Node temp = current; 
		Node ahead = current.next; 
		Node behind = current.prev; 
		ahead.prev = behind; 
		behind.next = ahead; 
		size--;
		return temp.data; 
	}
	/*
	 * Removes and returns the first element from the list. If there are no elements the 
	 * method returns null. 
	 * 
	 * @return data element or null
	 */
	public T retrieveFirstElement() { 
		return retrieve(0); 
	}
	/*
	 * Removes and returns the last element from the list. If there are no elements the 
	 * method returns null. 
	 * 
	 * @return data element or null
	 */
	public T retrieveLastElement() { 
		return retrieve(size-1);
	}
	/* Removes ALL instances of targetData from the list by performing a 
	 * single traversal over the list. 
	 * 
	 * @param targetData
	 * @param comparator 
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) { 
		Node current = head; 
		while(current != null) { 
			if (comparator.compare(current.data, targetData) == 0) { 
				if (size == 1) { // only one node in the list 
					head = tail = null;
					size--;
					break;
				} 
				if (current.next == null) { // removing the tail
					tail = current.prev; 
					tail.next = null;
					size--; 
					break; 
				} 
				if (current.prev == null) { // removing the head
					head = current.next; 
					head.prev = null; 
					current = head; 
					size--;
					continue; 
				} else { // remove node between head and tail
					Node behind = current.prev; 
					Node ahead = current.next; 
					behind.next = ahead;
					ahead.prev = behind; 
					current = ahead; 
					size--;
					continue;
				}
			}
			current = current.next; 
		}
		return this; 
	}
	
}
	