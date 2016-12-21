package ru.itis.lists;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private class Node {
        private T value;
        private Node next;
        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node current;

        LinkedListIterator(Node current) {
            this.current = current;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T temp = current.value;
            current = current.next;
            return temp;
        }
    }
    private Node top;
    private Node last;

    private int count;

    public LinkedList() {
        top = null;
        last = null;
        count = 0;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator(top);
    }

    public int getCount() {
        return count;
    }

    public void add(T value) {
        if (count == 0) {
            top = new Node(value);
            last = top;
            count = 1;
        } else {
            last.next = new Node(value);
            last = last.next;
            count++;
        }
    }

    // void add(int value, int index), void addFirst(int value)

    public T get(int index) {
        Node current = top;
        for (int i = 0; i < count; i++) {
            if (i == index) {
                return current.value;
            }
            current = current.next;
        }

        throw new IndexOutOfBoundsException();
    }

}
