package edu.westga.dsdm.model;

import java.util.Iterator;

/**
 * The Class LinkedListQueue
 * 
 * @author CS3151
 * @param <E> type of the queue elements
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {
	private SinglyLinkedList<E> queue;
	
	/**
	 * Instantiates a new LinkedListQueue
	 * 
	 * @pre none
	 * @post none
	 */
	public LinkedListQueue() {
		this.queue = new SinglyLinkedList<E>();
	}
	
	@Override
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	@Override
	public E peek() {
		return this.queue.getHead();
	}

	@Override
	public E dequeue() {
		return this.queue.removeHead();
	}

	@Override
	public void enqueue(E element) {
		this.queue.addTail(element);
	}

	@Override
	public Iterator<E> iterator() {
		return this.queue.iterator();
	}
}
