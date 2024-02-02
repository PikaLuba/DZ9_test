package org.example;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyStack<T> {
/*
Написати свій клас MyStack як аналог класу Stack, який працює за принципом LIFO (last-in-first-out).

Можна робити за допомогою Node або використати масив.

Методи

push(Object value) додає елемент в кінець
remove(int index) видаляє елемент за індексом
clear() очищає колекцію
size() повертає розмір колекції
peek() повертає перший елемент стеку
pop() повертає перший елемент стеку та видаляє його з колекції
 */
    private Node<T> first;
    private Node<T> last;
    int size = 0;

    //---------------- push
    private void linkLast(T e) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.setPrev(newNode);
    }
    public void push(T e) {
        linkLast(e);
    }

    //------------------ peek
    public T peek() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.getValue();
    }

    //---------------------pop
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

    public T pop() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
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
            first = next;
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
            Node<T> x = first;
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
