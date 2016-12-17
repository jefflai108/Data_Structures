package infixtoposix;

import java.util.Iterator;
import java.util.NoSuchElementException;

//import loopbag.Bag.Node;

public class LinkedStack<T> implements Stack<T> {
    private int N = 0;
    private Node first;

    private class Node {
        private T data;
        private Node next;

        Node(T item) {
            data = item;
            next = null;
        }
    }

    LinkedStack() {
        first = null;
    }

    public void push(T item) {
        Node oldfirst = first;
        first = new Node(item);
        first.next = oldfirst;
        N++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T pop() {
        if (isEmpty()) return null;
        T t = first.data;
        first = first.next;
        return t;
    }

    public int size() {
        return N;
    }

    public T peek() {
        if (isEmpty()) return null;
        return first.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator(first);
    }

    private class StackIterator implements Iterator<T> {
        private Node current = null;

        public StackIterator(Node first) {
            Node current = first;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public T next() {
            current = current.next;
            return current.data;
        }

    }
}