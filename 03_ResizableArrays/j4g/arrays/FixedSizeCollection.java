package j4g.arrays;

public class FixedSizeCollection<T> {
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
}