package edu.westga.dsdm.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * The Class LinkedListStack
 * 
 * @author CS3151
 * @param <E> type of the stack elements
 */
public class ArrayStack<E> implements Stack<E> {
	private E[] stack;
	private int size;
	
	/**
	 * Instantiates a new ArrayStack
	 * 
	 * @pre none
	 * @post none
	 */
	public ArrayStack() {
		this.stack = this.getTypeSafeArray(100); 
		this.size = 0;	
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.stack[this.size - 1];
	}

	@Override
	public E pop() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		E topElement = this.stack[this.size - 1];
		this.size--;
		return topElement;
	}

	@Override
	public void push(E element) {
		if (this.size == this.stack.length) {
			this.resize();
		}
		this.stack[this.size] = element;
		this.size++;
	}

	@SafeVarargs
	private E[] getTypeSafeArray(int length, E... array) {
		return Arrays.copyOf(array, length);
	}
	
	private void resize() {
		this.stack = Arrays.copyOf(this.stack, 2 * this.stack.length);
	}
}
