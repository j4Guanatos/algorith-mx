package mx.cs.datastructures;

/**
 * Queue implementation using Linked List
 * 
 * @param <T>
 */
public class Queue2<T> {
	
	//Node class
	private static class Node<T> {
		private T data;
		private Node<T> next;
		private Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> head;
	private Node<T> tail;
	
	//Get the value in the head
	public T peek() {
		return this.head.data;
	}
	
	public void enqueue(T data) {
		
		Node<T> node = new Node<T>(data);
		
		if(tail!=null) {
			tail.next = node;
		}
		
		tail = node;
		if(head == null) {
			head = node;
		}
	}
	
	public T dequeue() {
		T data = head.data;
		head = head.next;
		
		if(head == null) {
			tail = null;
		}
		
		return data;
	}
	
	public void print() {
		
		Node<T> queue = head;
		
		while(queue != null) {
			System.out.print(queue.data + " ");
			queue = queue.next;
		}
	}
	
}
