package edu.westga.dsdm.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Class SinglyLinkedList
 * 
 * @author CS3151
 * @param <E> type of list elements
 */
public class SinglyLinkedList<E> implements Iterable<E> {

	private Node head;
	private Node tail;
	private int size;

	/**
	 * Creates a new singly-linked list
	 * 
	 * @pre none
	 * @post size() == 0
	 */
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Adds the specified element at the tail of this list
	 * 
	 * @pre none
	 * @post size() == size()@pre + 1 && getTail().equals(element)
	 * @param element the element to be added
	 */
	public void addTail(E element) {
		Node newNode = new Node(element);

		if (this.tail == null) {
			this.tail = newNode;
			return;
		}

		Node node = this.head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = newNode;
	}

	/**
	 * Adds the specified element at the head of this list
	 * 
	 * @pre none
	 * @post size() == size()@pre + 1 && getHead().equals(element)
	 * @param element the element to be added
	 */
	public void addHead(E element) {
		Node newNode = new Node(element);

		if (this.head == null) {
			this.head = newNode;
			return;
		}

		Node node = this.head;
		while (node.next != null) {
			node = node.next;
		}
	}

	/**
	 * Adds the element at the specified index in this list. Shifts existing
	 * elements at the specified and greater indices to the right.
	 * 
	 * @pre 0 <= index <= size()
	 * @post size() == size()@pre + 1 && get(index).equals(element)
	 * @param index   the index at which the element is to be inserted
	 * @param element the element to be inserted
	 * @throws IndexOutOfBoundsException if index < 0 or index > size()
	 */
	public void add(int index, E element) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		} 
		Node newNode = new Node(element);
		Node node = this.head;
		for (int idx = 0; idx < index; idx++) {
			node = node.next;
		}
		node.next = newNode;
		for (int idx = index; idx < this.size; idx++) {
			node = node.next;
		}
		
	}

	/**
	 * removes the element at the tail of this list
	 * 
	 * @pre size() > 0
	 * @post size() == size()@pre - 1
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeTail() {
		if (this.size() == 0) {
			throw new NoSuchElementException();
		}
		E item = this.tail.value;
		if (this.size == 1) {
			this.head = null;
		} else {
			Node node = this.head;
			while(node.next.next != null) {
				
			}
		}
		
		Node node = this.head;
		for (int idx = 0; idx < this.size - 1; idx++) {
			node = node.next;
		}
		return item;
	}

	/**
	 * Removes the element at the head of this list
	 *
	 * @pre size() > 0
	 * @post size() == size()@pre - 1
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeHead() {
		if (this.size() == 0) {
			throw new NoSuchElementException();
		}
		E item = this.head.value;
		this.head = this.head.next;
		return item;
	}

	/**
	 * Removes the element at the specified index. Shifts subsequent elements to the
	 * left.
	 * 
	 * @pre 0 <= index < size
	 * @post size() == size()@pre - 1
	 * @param index the index of the element to be removed
	 * @return the removed element
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public E remove(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = this.head;
		Node nodeToBeRemoved;
		for (int idx = 0; idx < index; idx++) {
			node = node.next;
		}
		return null;
	}

	/**
	 * Gets the element at the tail of this list
	 * 
	 * @pre none
	 * @post none
	 * @return the element at the tail of this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getTail() {
		return this.tail.value;
	}

	/**
	 * Gets the element at the head of this list
	 * 
	 * @pre none
	 * @post none
	 * @return the element at the head of this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getHead() {
		return this.head.value;
	}

	/**
	 * Gets the element at the specified index.
	 * 
	 * @pre 0 <= index < size
	 * @post none
	 * @param index the index of the element to be returned
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public E get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		} 
		
		Node node = this.head;
		for (int idx = 0; idx < index; idx++) {
			node = node.next;
		}	
		return node.value;
	}

	/**
	 * Gets the size.
	 * 
	 * @pre none
	 * @post none
	 * @return the number if elements in this list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Check if this list is empty.
	 * 
	 * @pre none
	 * @post none
	 * @return true if this list is empty
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ForwardIterator();
	}

	private final class Node {
		private E value;
		private Node next;

		private Node(E item) {
			this.value = item;
			this.next = null;
		}
	}

	/**
	 * Class ForwardIterator
	 * 
	 * @author CS3151
	 */
	public class ForwardIterator implements Iterator<E> {
		private Node nextNode;

		/**
		 * Instantiates a new forward iterator
		 */
		public ForwardIterator() {
			this.nextNode = SinglyLinkedList.this.head;
		}

		@Override
		public boolean hasNext() {
			return this.nextNode != null;
		}

		@Override
		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			E element = this.nextNode.value;
			this.nextNode = this.nextNode.next;
			return element;
		}
	}
	
	/**
	 * Class ForwardIterator
	 * 
	 * @author CS3151
	 */
	public class BackwardIterator implements Iterator<E> {
		private Node nextNode;

		/**
		 * Instantiates a new forward iterator
		 */
		public BackwardIterator() {
			this.nextNode = SinglyLinkedList.this.tail;
		}

		@Override
		public boolean hasNext() {
			return this.nextNode != null;
		}

		@Override
		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			E element = this.nextNode.value;
			this.nextNode = this.nextNode.next;
			return element;
		}
	}
}
