package mx.cs.datastructures;

/**
 * Queue implementation using Array
 * 
 * @param <T>
 */
public class Queue<T> {
	
	private int capacity;
	private T[] array;
	private int headIndex = 0;
	private int tailIndex = 0;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		 array = (T[])new Object[capacity];
	}
	
	public void enqueue(T value) {
		if(tailIndex < capacity) {
			array[tailIndex] = value;
			tailIndex++;
		}
		else {
			System.err.println("Queue is Full");
		}
	}
	
	public T dequeue() {
		T value = null;
		if(headIndex != tailIndex) {
			value = array[headIndex];
			array[headIndex] = null;
			headIndex++;
		} else {
			System.err.println("Queue is Empty");
		}
		
		return value;
	}
	
	public void print() {
		System.out.println();
		for(int i=0; i<capacity; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
}
