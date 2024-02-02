package org.example;

//import java.util.LinkedList;

public class MyLinkedList<T> {
    private Node<T> head; // first
    private Node<T> last;
    int size = 0;

    //----------- add
    public void add(T item) {
        Node<T> newNode = new Node<>();
        newNode.setValue(item);

        if (head == null) {
            head = newNode;
            last = newNode;
            newNode.setPrev(null);
            newNode.setNext(null);

        } else {
            last = head;
            while (last.getNext() != null) {
                last = last.getNext();
              }

            last.setNext(newNode);
            newNode.setPrev(last);
            newNode.setNext(null);
            last = newNode;
        }
    }

    //---------------- size
    public int size() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        Node<T> last = head;
        while (last.getNext() != null) {
            last = last.getNext();
            count++;
        }

        return count;
    }

    //------ get
    public T get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size());
        }

        Node<T> search = head;
        for (int i = 0; i < index; i++) {
            search = search.getNext();

            if (search == null) {
                throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size());
            }
        }

        return search.getValue();
    }

    //--------- clear
    public void clear() {
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.getNext();
            x.setValue(null);
            x.setNext(null);
            x.setPrev(null);
            x = next;
        }
        head = last = null;
        size = 0;
    }

    //------- remove
    public T remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }

    T unlink(Node<T> x) {
        // assert x != null;
        final T element = x.getValue();
        final Node<T> next = x.getNext();
        final Node<T> prev = x.getPrev();

        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
            x.setPrev(null);
        }

        if (next == null) {
            last = prev;
        } else {
            next.setPrev(prev);
            x.setNext(null);
        }

        x.setValue(null);
     //   size--;
        return element;
    }

    Node<T> node(int index) {
        // assert isElementIndex(index);
        size = size();
        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++)
                x = x.getNext();
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.getPrev();
            return x;
        }
    }

}

