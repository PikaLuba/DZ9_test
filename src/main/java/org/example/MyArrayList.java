package org.example;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.StringJoiner;

public class MyArrayList<T> {
    private static final int INIT_SIZE = 8;

    private Object[] data;

    private int index;

    public MyArrayList() {
        data = new Object[INIT_SIZE];
    }

    private void resizeIfNeed() {
        if (index == data.length) {
            System.out.println("Resize happened, index: " + index + ", data.length: " + data.length);
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;

        }
    }

    public void add(T value) {
        resizeIfNeed();
        data[index] = value;
        index++;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }

    public T get(int i) {
        checkElementIndex(i);
        return (T) data[i];
    }

    public int size() {
        return index;
    }

    public void clear() {
        int newSize = size();//data.length;
        for (int i = 0; i < newSize; i++) {
            data[i] = null;
        }
        newSize = 0;
        index = newSize;
    }

    private void shiftToLeft(int ind) {
        int newSize = size();//data.length;
        newSize--;

        if (newSize <= 0) {
            return;
        }
        if (newSize != ind) {
            System.arraycopy(data, ind + 1, data, ind, newSize - ind);
        }
        data[newSize] = null;
        index = newSize;

    }

    public T remove(int ind) {
        checkElementIndex(ind);
        Object o = null;
        if ((ind < data.length) && (index >= 0)) {
                o = get(ind);
                shiftToLeft(ind);
        }
            return (T) o;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < index; i++) {
            result.add(data[i].toString());
        }

        return "[" + result + "]";
    }
}