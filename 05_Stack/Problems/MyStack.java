/**
 * Created by Miriam_Lee on 17-Jan-17.
 */
package Problems;

class StackFrame<T> {
    T data;
    StackFrame next;

    StackFrame(T data, StackFrame<T> next) {
        this.data = data;
        this.next = next;
    }
}

class StackUnderflowException extends Throwable {
}


public class MyStack<T> {

    StackFrame<T> head;

    public MyStack() {
        head = null;
    }

    public void push(T item) {
        StackFrame<T> frame = new StackFrame<T>(item, head);
        head = frame;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T peek() throws StackUnderflowException {
        if (head == null) throw new StackUnderflowException();
        T item = head.data;
        return item;
    }

    public T pop() throws StackUnderflowException {
        if (head == null) throw new StackUnderflowException();
        T item = head.data;
        head = head.next;
        return item;
    }
}
