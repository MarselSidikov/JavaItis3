package ru.itis.lists;

import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {
    private static class Node {
        private int value;
        private Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }

    }

    private class LinkedListIterator implements Iterator<Integer> {

        private Node current;

        LinkedListIterator(Node current) {
            this.current = current;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Integer next() {
            int temp = current.value;
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

    public Iterator<Integer> iterator() {
        return new LinkedListIterator(top);
    }

    public int getCount() {
        return count;
    }

    public void add(int value) {
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

    public int get(int index) {
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
