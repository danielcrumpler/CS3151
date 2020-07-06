package edu.westga.dsdm.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Class DoublyLinkedList
 * 
 * @author Daniel Crumpler
 * @param <E> type of list elements
 */
public class DoublyLinkedList<E> implements LinkedListOperations<E> {

	private Node head;
	private Node tail;
	private int size;

	/**
	 * Creates a new singly-linked list
	 * 
	 * @precondition none
	 * @postcondition size() == 0
	 */
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	private final class Node {
		private E value;
		private Node next;
		private Node previous;

		private Node(E item) {
			this.value = item;
			this.next = null;
			this.previous = null;
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
			this.nextNode = DoublyLinkedList.this.head;
		}

		@Override
		public boolean hasNext() {
			return this.nextNode != null;
		}

		@Override
		public E next() {
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
		private int nextIndex;

		/**
		 * Instantiates a new forward iterator
		 */
		public BackwardIterator() {
			this.nextIndex = DoublyLinkedList.this.size - 1;
		}

		@Override
		public boolean hasNext() {
			return this.nextIndex >= 0;
		}

		@Override
		public E next() {
			E element = DoublyLinkedList.this.get(this.nextIndex);
			this.nextIndex--;
			return element;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ForwardIterator();
	}

	@Override
	public void addTail(E element) {
		Node newNode = new Node(element);
		this.size++;
		
		if (this.head == null) {
			this.head = newNode;
			return;
		}

		Node node = this.head;
		while (node.previous != null) {
			node = node.next;
		}
		node.next = newNode;
		this.tail = newNode;
	}

	@Override
	public void addHead(E element) {
		Node newNode = new Node(element);
		this.size++;

		newNode.next = this.head;
		this.head = newNode;
	}

	@Override
	public void add(int index, E element) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}

		if (index == 0) {
			this.addHead(element);
			return;
		}

		Node newNode = new Node(element);
		this.size++;
		Node node = this.head;
		while (index > 1) {
			node = node.next;
			index--;
		}
		newNode.next = node.next;
		node.next = newNode;
	}

	@Override
	public E removeTail() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		
		if (this.size == 1) {
			return this.removeHead();
		}
		
		this.size--;
		Node node = this.head;
		while (node.next.next != null) {
			node = node.next;
		}
		E value = node.next.value;
		node.next = null;
		return value;
	}

	@Override
	public E removeHead() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}

		this.size--;
		E value = this.head.value;
		this.head = this.head.next;
		return value;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}

		if (index == 0) {
			return this.removeHead();
		}
		if (index == this.size - 1) {
			return this.removeTail();
		}

		this.size--;
		Node node = this.head;
		while (index > 1) {
			node = node.next;
			index--;
		}
		E value = node.next.value;
		node.next = node.next.next;
		return value;
	}

	@Override
	public E getTail() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		return this.tail.value;
	}

	@Override
	public E getHead() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		return this.head.value;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}

		Node node = this.head;
		while (index > 0) {
			node = node.next;
			index--;
		}
		return node.value;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public Iterator<E> getForwardIterator() {
		return new ForwardIterator();
	}

	@Override
	public Iterator<E> getBackwardIterator() {
		return new BackwardIterator();
	}
	
	private String outOfBoundsMessage(int index) {
		return "Index " + index + " out of bounds for list of size " + this.size;
	}
}
