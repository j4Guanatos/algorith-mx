package j4g.arrays;

public class ResizableCollection<T> {

    private static final int INITIAL_SIZE = 4;
    private T[] elements;
    private int size = 0;

    public ResizableCollection() {
        elements = buildGenericArray(INITIAL_SIZE);
    }

    public static <T> T[] buildGenericArray(int size) {
        return (T[]) new Object[size];
    }

    public void add(T element) {
        if (size == elements.length) resizeTo(elements.length * 2);
        elements[size++] = element;
    }

    public T removeLast() {
        T element = elements[--size];
        elements[size] = null;
        if (size > 0 && size == elements.length / 4) resizeTo(elements.length / 2);
        return element;
    }

    private void resizeTo(int newSize) {
        T[] newArray = buildGenericArray(newSize);
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false;
    }
}
