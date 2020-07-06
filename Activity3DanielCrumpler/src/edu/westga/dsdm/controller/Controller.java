package edu.westga.dsdm.controller;

import java.util.Iterator;
import java.util.Scanner;

import edu.westga.dsdm.model.SinglyLinkedList;
import edu.westga.dsdm.model.SinglyLinkedList.ForwardIterator;

/**
 * The Class Controller
 * 
 * @author CS3151
 */
public class Controller {

	/**
	 * Runs the application
	 */
	public void run() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();

		try (Scanner input = new Scanner(System.in)) {
			String item = "dummy";
			while (!item.isEmpty()) {
				System.out.print("Enter the next list item: ");
				item = input.nextLine();
				if (!item.isEmpty()) {
					list.addHead(item);
				}
			}
		}

		this.printList(list);
		this.traverseListForward(list);
		this.traverseListBackward(list);
	}
	
	private <E> void printList(Iterable<E> list) {
		System.out.println("List content: ");
		for (E currString : list) {
			System.out.println(currString);
		}
	}
	
	private <E> void traverseListForward(SinglyLinkedList<E> list) {
		System.out.println("List content from head to tail: ");
//		Iterator<E> iter = list.iterator();
//		SinglyLinkedList<E>.ForwardIterator iter = list.new ForwardIterator();
		Iterator<E> iter = list.new ForwardIterator();
		while (iter.hasNext()) {
			E currString = iter.next();
			System.out.println(currString);
		}
	}
	
	private <E> void traverseListBackward(SinglyLinkedList<E> list) {
		System.out.println("List content from tail to head: ");
		Iterator<E> iter = list.new BackwardIterator();
		while (iter.hasNext()) {
			E currString = iter.next();
			System.out.println(currString);
		}
	}
}
