package map;

import java.util.Objects;

public class DoublyLinkedList<T> {

    static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<T> getNodeByValue(T value) {
        Node<T> current = head;
        while(current != null) {
            if (Objects.equals(current.value, value)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public int size() {
        return this.size;
    }

    public T insertAtEnd(T value) {
        Node<T> newItem = new Node<>(value);

        if (this.head == null) {
            this.head = this.tail = newItem;
        } else {
            this.tail.next = newItem;
            newItem.prev = this.tail;
            this.tail = newItem;
            this.tail.next = null;
        }

        this.size++;

        return value;
    }

    public T removeByValue(T value) {
        var found = this.getNodeByValue(value);

        if (found == null) {
            return null;
        }

        this.size--;

        if (found.prev == null && found.next == null) {
            this.head = this.tail = null;
            return found.value;
        }

        if (found.prev == null) {
            this.head = found.next;
            this.head.prev = null;
            return found.value;
        }

        if (found.next == null) {
            this.tail = found.prev;
            this.tail.next = null;
            return found.value;
        }

        var oldPrev = found.prev;
        var oldNext = found.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;

        return found.value;
    }

    public T getByValue(T value) {
        var found = this.getNodeByValue(value);

        if (found == null) {
            return null;
        }

        return found.value;
    }

    public T getFirst() {
        if (this.head == null) {
            return null;
        }

        return this.head.value;
    }

    public T getLast() {
        if (this.tail == null) {
            return null;
        }

        return this.tail.value;
    }

}
