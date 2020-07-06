package edu.westga.dsdm.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * The Class ArrayQueue
 * 
 * @author CS3151
 * @param <E> type of the queue elements
 */
public class ArrayQueue<E> implements Queue<E> {
	private E[] queue;
	private int headIndex;
	private int tailIndex;
	
	/**
	 * Instantiates a new LinkedListQueue
	 * 
	 * @pre none
	 * @post none
	 */
	public ArrayQueue() {
		this.queue = this.getTypeSafeArray(100);
		this.headIndex = -1;
		this.tailIndex = -1;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public E peek() {
		return null;
	}

	@Override
	public E dequeue() {
		return null;
	}

	@Override
	public void enqueue(E element) {
	}

	@SafeVarargs
	private E[] getTypeSafeArray(int length, E... array) {
		return Arrays.copyOf(array, length);
	}
	
	private void resize() {
		E[] newQueue = Arrays.copyOf(this.queue, 2 * this.queue.length);
		int index = 0;
		while (!this.isEmpty()) {
			newQueue[index] = this.dequeue();
			index++;
		}
		this.headIndex = 0;
		this.tailIndex = index - 1;
		this.queue = newQueue;
	}
}
