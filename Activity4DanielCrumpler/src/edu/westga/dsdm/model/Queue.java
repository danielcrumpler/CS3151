package edu.westga.dsdm.model;

import java.util.NoSuchElementException;

/**
 * The Interface Queue
 * 
 * @author CS3151
 * @param <E> type of queue elements
 */
public interface Queue<E> {

	/**
	 * Checks if this queue is empty
	 * 
	 * @pre none
	 * @post none
	 * @return true if this queue is empty
	 */
	boolean isEmpty();

	/**
	 * Gets the element at the head of this queue
	 * 
	 * @pre !isEmpty()
	 * @post none
	 * @return the element at the head of this queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	E peek();

	/**
	 * Removes and returns the element at the head of this queue
	 * 
	 * @pre !isEmpty()
	 * @post the element at the head has been removed
	 * @return the element that is removed from the head of this queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	E dequeue();

	/**
	 * Adds the element to the tail of this queue
	 * 
	 * @pre none
	 * @post the element has been added to the tail of this queue
	 * @param element the element to be added
	 */
	void enqueue(E element);

}
