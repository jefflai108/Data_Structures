package loopbag;

import java.util.Iterator;

public class Bag<E> implements LoopBag<E> {
    private int capacity;
    private Node<E> first;
    // private Node<E> current;
    private int N; // number of elements in the bag

    private class Node<E> {
        private E data;
        private Node<E> next;

        Node(E item) {
            data = item;
        }
    }

    /**
     * 
     * @param capacity
     *            Fixed size bag capacity
     */
    public Bag(int capacity) {
        first = null;
        N = 0;
        this.capacity = capacity;
    }

    @Override
    public void insert(E item) {
        if (isEmpty()) {
            first = new Node<E>(item);
            N++;
            return;
        }
        if (N == capacity) {
            first = first.next;
        }
        Node<E> current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<E>(item);
        if (N != capacity) N++;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public boolean contains(E item) {
        if (isEmpty())
            return false;
        Node<E> current = first;
        while (current != null) {
            if (current.data == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void union(LoopBag<E> lb) {
        Iterator<E> itr = lb.iterator();
//        capacity += lb.size();
        while (itr.hasNext()) {
            E element = itr.next();
            if (!contains(element)) {
                insert(element);                
            }
        }
    }
    
    public E get(int index)
    {
            Node<E> current = first;
            int i = 0;
            while(current != null && i < index){
                current = current.next;
                i++;
//                System.out.println("work");
            }
            return current.data;
    }
    
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < N; i++) {
            output += get(i);
            output += ",";
        }
        return output;
    }

    @Override
    public Iterator<E> iterator() {
        return new BagIterator(first);
    }
    /**
    *   The iterator implementation
    */
    private class BagIterator implements Iterator<E> { 
        private Node<E> current = null;
        public BagIterator(Node<E> first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;}
//        public void remove()      { System.out.println("to be implemented.");  }
        public E next() {
            if(!hasNext()) {return null;}
        E item = current.data;
            current = current.next; 
//            System.out.println("work");
            return item;
        }

    }

}
