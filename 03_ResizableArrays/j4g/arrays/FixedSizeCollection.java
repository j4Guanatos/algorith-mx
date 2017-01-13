package j4g.arrays;

import java.util.RandomAccess;

public class FixedSizeCollection<T> implements RandomAccess {
    private T[] elements;
    private int size = 0;

    public FixedSizeCollection(int maxSize) {
        elements = (T[]) new Object[maxSize];
    }

    public void add(T element) {
        elements[size++] = element;
    }

    public T removeLast() {
        T element = elements[--size];
        elements[size] = null;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return elements[index];
    }
}