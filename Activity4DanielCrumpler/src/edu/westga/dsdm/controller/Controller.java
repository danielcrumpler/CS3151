package edu.westga.dsdm.controller;

import edu.westga.dsdm.model.ArrayQueue;
import edu.westga.dsdm.model.ArrayStack;
import edu.westga.dsdm.model.LinkedListQueue;
import edu.westga.dsdm.model.LinkedListStack;
import edu.westga.dsdm.model.Queue;
import edu.westga.dsdm.model.Stack;

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
		this.testStack();
		this.testQueue();
	}

	private void testStack() {
		Stack<Integer> aStack = new LinkedListStack<Integer>();

		for (int i = 1; i <= 10; i++) {
			aStack.push(i);
			if (i % 2 == 0) {
				aStack.pop();
			}
		}

		System.out.println();
		System.out.print("Stack content from top to bottom: ");
		while (!aStack.isEmpty()) {
			System.out.print(" " + aStack.pop());
		}
	}
	
	private void testQueue() {
		Queue<Integer> aQueue = new LinkedListQueue<Integer>();

		for (int i = 1; i <= 10; i++) {
			aQueue.enqueue(i);
			if (i % 2 == 0) {
				aQueue.dequeue();
			}
		}

		System.out.println();
		System.out.print("Queue content from head to tail: ");
		while (!aQueue.isEmpty()) {
			System.out.print(" " + aQueue.dequeue());
		}
	}
}
