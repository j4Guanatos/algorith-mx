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
		
		Node<T> newNode = new Node<T>(data);
		
		if(tail!=null) {
			tail.next = newNode;
		}
		
		tail = newNode;
		
		if(head == null) {
			head = newNode;
		}
	}
	
	public T dequeue() {
		
		if(head == null) {
			tail = null;
			System.err.println("Queue is Empty");
			return null;
		}
		
		T data = head.data;
		head = head.next;
		
		return data;
	}
	
	public void print() {
		
		Node<T> queue = head;
		
		while(queue != null) {
			System.out.print(queue.data + " ");
			queue = queue.next;
		}
		System.out.println();
	}
}
