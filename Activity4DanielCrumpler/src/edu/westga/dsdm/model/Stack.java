package edu.westga.dsdm.model;

import java.util.NoSuchElementException;

/**
 * The Interface Stack
 * 
 * @author CS3151
 * @param <E> type of stack elements
 */
public interface Stack<E> {

	/**
	 * Checks if this stack is empty
	 * 
	 * @pre none
	 * @post none
	 * @return true if this stack is empty
	 */
	boolean isEmpty();

	/**
	 * Gets the element at the top of this stack
	 * 
	 * @pre !isEmpty()
	 * @post none
	 * @return the element at the top of this stack
	 * @throws NoSuchElementException if this stack is empty
	 */
	E peek();

	/**
	 * Removes and returns the element at the top of this stack
	 * 
	 * @pre !isEmpty()
	 * @post the element at the top has been removed
	 * @return the element that is removed from the top of this stack
	 * @throws NoSuchElementException if this stack is empty
	 */
	E pop();

	/**
	 * Adds the element to the top of this stack
	 * 
	 * @pre none
	 * @post peek().equals(element)
	 * @param element the element to be added
	 */
	void push(E element);

}
