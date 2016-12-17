package list;

/**
 * Please the read the methods' descriptions below. You have to implement 3
 * methods for the linked list class.
 * 
 * This project will be done in groups. A group shouldn't have more than 3
 * members. Write the group member names here.
 * 1) William Shyr
 * 2) Cheng-I Lai 
 * 3)
 * 
 * 
 * Notes:
 * 1) You have to implement 3 methods of a linked list.
 * 2) addToEnd and addArray methods are already provided to help you write 
 * some test cases in the main method
 * 3) You have to submit the project before the end of the class
 * 4) You are free to add fields and/or methods to classes
 * 
 * @author Dept of Computer Science, UMCP
 *
 */
public class MyLinkedList {

	private Node first;
	private int length;

	// Inner class for Node definition
	class Node {
		int data;
		Node next;

		public Node(int d, Node n) {
			data = d;
			next = n;
		}
	}

	/**
	 * ALREADY IMPLEMENTED: Adds the the specified element to the end of the list
	 * 
	 * @param element
	 *            - the element to be inserted at the end of the current list
	 */
	public void addToEnd(int element) {
		Node newNode = new Node(element, null);
		length++;

		// If list is empty, so first node will be the new one
		if (first == null) {
			first = newNode;
		} else {
			// Getting the last node to insert the newNode after it
			Node travel = first;
			while (travel.next != null) {
				travel = travel.next;
			}
			travel.next = newNode;
		}
	}

	/**
	 * ALREADY IMPLEMENTED: Inserts the specified array elements at the end of the current list
	 * 
	 * @param array
	 *            - contains the elements to be inserted
	 */
	public void addArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			addToEnd(array[i]);
		}
	}

	/**
	 * Checks whether the list has two consecutive duplicate numbers or not.
	 * Example, a list containing {4, 2, 2, 1} is right, where another list
	 * containing {1, 2, -1, 2} doesn't have that criterion even it has two 2's
	 * but they are not consecutive.
	 * 
	 * @return true if found, false otherwise
	 */
	public boolean hasConsecutiveDuplicate() {
		// TODO: Your implementation goes here (you need to change the next
		// return statement)
		Node current = first; 
		while (current != null && current.next != null) { 
			if (current.data == current.next.data) return true; 
			current = current.next; 
		}
		return false;
	}

	/**
	 * Searches for the specified integer inside the list
	 * 
	 * @param element
	 *            - the element to be searched
	 * @return an integer that represents the index (0 based) of the element if found, -1
	 *         otherwise
	 */
	public int indexOf(int element) {
		// TODO: Your implementation goes here (you need to change the next
		// return statement)
		Node current = first; 
		int index = 0; 
		while (current != null) { 
			if(current.data == element) return index; 
			current = current.next; 
			index++; 
		}
		return -1;
	}

	/**
	 * Appends the specified list to the current list. Example, if a list
	 * containing {4, 5, 6} is to be appended after another list containing {1,
	 * 2, 3}. The latter will contain {1, 2, 3, 4, 5, 6}. IMPORTANT: DON'T USE
	 * ADD METHOD AT ALL.
	 * 
	 * @param other
	 *            - the list to be appended after the current list
	 */
	public void append(MyLinkedList other) {
		// TODO: Your implementation goes here
		Node current = first; 
		while (current != null && current.next != null) current = current.next; 
		current.next = other.first; 
		length += other.length; 
	}

	public static void main(String[] args) {
		// Just for testing hasConsecutiveDuplicate()
		MyLinkedList list1 = new MyLinkedList();
		list1.addArray(new int[] { 1 });

		MyLinkedList list2 = new MyLinkedList();
		list2.addArray(new int[] { 4, 2, 2, 1 });

		MyLinkedList list3 = new MyLinkedList();
		list3.addArray(new int[] { -1, 2, 0, 2 });

		list2.append(list3);
		
		System.out.println("Expected is false, result = "
				+ list1.hasConsecutiveDuplicate());
		System.out.println("Expected is true, result = "
				+ list2.hasConsecutiveDuplicate());
		System.out.println("Expected is false, result = "
				+ list3.hasConsecutiveDuplicate());

		System.out.println("Expected is 4, result = "
				+ list2.indexOf(-1));

		// TODO: You can test your linked list here for the remaining methods
		// (OPTIONAL)

	}

}
