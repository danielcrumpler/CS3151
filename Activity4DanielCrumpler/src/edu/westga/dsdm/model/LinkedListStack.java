package edu.westga.dsdm.model;

import java.util.Iterator;

/**
 * The Class LinkedListStack
 * 
 * @author CS3151
 * @param <E> type of the stack elements
 */
public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
	private SinglyLinkedList<E> stack;
	
	/**
	 * Instantiates a new LinkedListStack
	 * 
	 * @pre none
	 * @post none
	 */
	public LinkedListStack() {
		this.stack = new SinglyLinkedList<E>();
	}
	
	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	@Override
	public E peek() {
		return this.stack.getHead();
	}

	@Override
	public E pop() {
		return this.stack.removeHead();
	}

	@Override
	public void push(E element) {
		this.stack.addHead(element);
	}

	@Override
	public Iterator<E> iterator() {
		return this.stack.iterator();
	}

}
