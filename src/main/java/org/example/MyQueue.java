package org.example;

//import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> {

    private Node<T> first;
    private Node<T> last;
    int size = 0;

    //------------------- add
    void add(T e) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.setNext(newNode);
    }

    //----------------- peek
    public T peek() {
        final Node<T> f = first;
        if (f == null) {
           return null;
        }
           // throw new NoSuchElementException();
        return f.getValue();
    }

    //-------------- poll
    private T unlinkFirst(Node<T> f) {
        // assert f == first && f != null;
        final T element = f.getValue();
        final Node<T> next = f.getNext();
        f.setValue(null);
        f.setNext(null);
        first = next;
        if (next == null)
            last = null;
        else
            next.setPrev(null);
        return element;
    }
    public T poll() {
        final Node<T> f = first;
        if (f == null) {
            return null;
        }
           // throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    //clear
    //--------- clear
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.getNext();
            x.setValue(null);
            x.setNext(null);
            x.setPrev(null);
            x = next;
        }
        first = last = null;
        size = 0;
    }

    //size
    //---------------- size
    public int size() {
        if (first == null) {
            return 0;
        }

        int count = 1;
        Node<T> last = first;
        while (last.getNext() != null) {
            last = last.getNext();
            count++;
        }

        return count;
    }

}
