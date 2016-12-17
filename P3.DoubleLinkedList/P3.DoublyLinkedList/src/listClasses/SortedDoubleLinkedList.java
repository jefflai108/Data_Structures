package listClasses;

import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator<T> comparator;
	/*
	 * Creates an empty list that is associated with the specified comparator by 
	 * calling super class constructor
	 * 
	 * @param comparator 
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> comparator) { 
		super();
		this.comparator = comparator; 
	}
	/*
	 * Inserts the specified element at the correct position in the sorted list by traversing 
	 * the list only once. 
	 * Notice the method could insert the same element several times and it doesn't 
	 * call any of the super class methods.
	 * 
	 * @param data element
	 * @return reference to current object.
	 */
	public SortedDoubleLinkedList<T> add(T element) { 
		if (size == 0) { // empty list 
			head = new Node(element); 
			tail = head;
			size++;
			return this; 
		} 
		Node current = head; 
		while (current != null && comparator.compare(current.data, element) < 0) { 
			current = current.next; // iterator through the list 
		}
		if (current == null) { // add to the end  
			Node oldtail = tail; 
			tail = new Node(element); 
			oldtail.next = tail; 
			tail.prev = oldtail; 
			size++; 
			return this; 
		}
		if (current.prev == null) { // add in front
			Node oldhead = head; 
			head = new Node(element); 
			head.next = oldhead;
			oldhead.prev = head; 
			size++;
			return this; 	
		}
		// add in between head and tail 
		Node behind = current.prev; 
		Node ahead = current; 
		Node temp = new Node(element);
		behind.next = temp; 
		temp.prev = behind; 
		temp.next = ahead; 
		ahead.prev = temp;
		size++; 
		return this; 
	}
	/*
	 * Implements the remove operation by calling the super class remove method.
	 * 
	 * @param targetData 
	 * @return reference to current object
	 */
	public SortedDoubleLinkedList<T> remove(T targetData) { 
		super.remove(targetData, comparator);
		return this; 
	}
	/*
	 * An UnsupportedOperationException will be generated with the message 
	 * "Invalid operation for sorted list." if the method is called.
	 * 
	 * @param data element
	 * @return reference to current object
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) { 
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	/*
	 * An UnsupportedOperationException will be generated with the message 
	 * "Invalid operation for sorted list." if the method is called.
	 * 
	 * @param data element
	 * @return reference to current object
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) { 
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	/*
	 * Merges two SortedLinkedLists and returns reference to the current list with 
	 * all the elements of the list passed as the parameter. 
	 * 
	 * @param list 
	 * @return reference to current object
	 */
	public SortedDoubleLinkedList<T> merge(SortedDoubleLinkedList<T> list) { 
		Node current1 = list.head; 
		Node current2 = this.head; 
		
		if (current1 == null) { 
			return this;
		}
		if (current2 == null) { 
			this.head = list.head;
			current2 = this.head;
			while (current1.next != null) { 
				current2.next = current1.next; 
				current2.next.prev = current2;  
				current2 = current2.next; 
				current1 = current1.next; 
			}
			this.tail = list.tail; 
			size = size + list.size;
			return this; 
		}
		//if both lists are not empty, pick the smaller node from both lists
		if (comparator.compare(current1.data, current2.data) < 0) { 
			Node oldhead = head; 
			Node temp = new Node(current1.data); 
			head = temp;
			head.next = oldhead; 
			oldhead.prev = head;
			current1 = current1.next;
		} else {
			current2 = current2.next; 
		}
		// walk through l1 and l2, every time pick the smaller node
		while (current1 != null && current2 != null) {
			if (comparator.compare(current1.data, current2.data) < 0) { 
				Node behind = current2.prev; 
				Node temp = new Node(current1.data); 
				behind.next = temp; 
				temp.prev = behind; 
				temp.next = current2;
				current2.prev = temp;
				current1 = current1.next;
			} else {
				current2 = current2.next;
			} 
		}
		// check if current1 has reached the end of list 
		if (current1 != null) { 
			tail.next = current1; 
			current1.prev = tail; 
			tail = list.tail; 
		}	
		size = size + list.size;
		return this; 
	}
}
 