package ru.itis.interfaces;

// Вложенные классы
// вложенные классы - вложенные и внутренние
// вложенные - статичные
// внутренние - нестатичные вложенные
public class BagLinkedListImpl implements Bag {
    @Override
    public void put(int number) {
        if (head == null) {
            head = new Node(number);
            head.next = null;
        } else {
            Node newNode = new Node(number);
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public boolean isExist(int number) {
        Node current = head;
        while (current != null) {
            if (current.value == number) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;


}
