package edu.westga.dsdm.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;
import edu.westga.dsdm.model.LinkedListOperations;

class TestDoubly {

	@Test
	public void testAddHead() {
		LinkedListOperations<String> list = new DoublyLinkedList<String>();
		list.addHead("1");
		assertEquals("1", list.get(0));
		list.addHead("2");
		assertEquals("2", list.get(0));
		assertEquals("1", list.get(1));
	}
	
	@Test
	public void testAddTail() {
		LinkedListOperations<String> list = new DoublyLinkedList<String>();
		list.addTail("1");
		assertEquals("1", list.get(0));
		list.addTail("2");
		assertEquals("1", list.get(0));
		assertEquals("2", list.get(1));
	}
	
	@Test
	public void testRemoveHead() {
		LinkedListOperations<String> list = new DoublyLinkedList<String>();
		list.addTail("1");
		assertEquals("1", list.get(0));
		list.addTail("2");
		assertEquals("1", list.get(0));
		assertEquals("2", list.get(1));
		list.removeHead();
		assertEquals("2", list.get(0));
	}
	
	@Test
	public void testRemoveTail() {
		LinkedListOperations<String> list = new DoublyLinkedList<String>();
		list.addTail("1");
		assertEquals("1", list.get(0));
		list.addTail("2");
		assertEquals("1", list.get(0));
		assertEquals("2", list.get(1));
		list.removeTail();
		assertEquals("1", list.get(0));
	}
}
