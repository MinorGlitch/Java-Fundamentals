package linkedListTraversal;

import java.util.Iterator;
import java.util.List;

public class MyLinkedList<T> implements Iterable<T> {
    private int count;
    private ListNode<T> head;
    private ListNode<T> first;

    public void Add(T element) {

        ListNode<T> currentNode = new ListNode<>(element);

        if (this.count == 0) {
            this.head = currentNode;
            this.first = currentNode;
        } else {
            this.head.nextNode = currentNode;
            currentNode.prevNode = this.head;
            this.head = currentNode;
        }

        this.count++;
    }

    public void remove(T item) {

        ListNode<T> currentNode = this.first;

        if (this.count == 1) {
            this.head = this.first = null;
            this.count = 0;
            return;
        }

        while (currentNode.nextNode != null) {
            if (currentNode.value.equals(item)) {
                if (currentNode.prevNode != null) {
                    currentNode.prevNode.nextNode = currentNode.nextNode;
                } else {
                    this.first = this.first.nextNode;
                    this.first.prevNode = null;
                }

                if (currentNode.nextNode != null) {
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                } else {
                    currentNode.prevNode.nextNode = null;
                }

                this.count--;
                return;
            }

            currentNode = currentNode.nextNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public int size() {
        return this.count;
    }

    private class ListNode<T> {
        public T value;
        public ListNode<T> nextNode;
        public ListNode<T> prevNode;

        public ListNode(T value) {
            this.value = value;
        }
    }

    private final class ListIterator implements Iterator<T> {
        private ListNode<T> currentNode = first;

        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T returnVal = currentNode.value;
                currentNode = currentNode.nextNode;
                return returnVal;
            }

            return null;
        }
    }
}
