package edu.westga.cs3151.project3.model;

import java.util.ArrayList;

/**
 * BinaryTree
 *
 * @author CS3151
 */
public class BinaryTree {

	private BinaryNode root;
	private BinaryNode curr = null;

	/**
	 * Instantiates a new binary tree with three nodes: The root of the new tree has
	 * two children where the root has the specified value valueRoot, the left child
	 * of root has the specified value valueLeft, and the right child of root has
	 * the specified value valueRight.
	 * 
	 * @precondition valueRoot != null
	 * 
	 * @param valueRoot value of the root
	 * @param type      the type of node
	 */

	public BinaryTree(String valueRoot, String type) {
		if (valueRoot == null) {
			throw new IllegalArgumentException("the value of the root cannot be null");
		}
		if (valueRoot.isEmpty()) {
			throw new IllegalArgumentException("the value of the root cannot be empty");
		}
		this.root = new BinaryNode(valueRoot, type);
		this.curr = this.root;
	}

	/**
	 * Adds the user defined question and animal to the Binary Tree
	 * 
	 * @precondition questionValue != null && animalValue != null
	 * 
	 * @param questionValue the value of the question node to be added
	 * @param animalValue   the value of the animal node to be added
	 * @param bool          the value of if the question is the animal
	 */
	public void addNewQuestion(String questionValue, String animalValue, Boolean bool) {
		if (questionValue == null) {
			throw new IllegalArgumentException("question value cannot be null");
		}
		if (animalValue == null) {
			throw new IllegalArgumentException("animal value cannot be null");
		}

		String currValue = this.curr.getValue();
		String currType = this.curr.getType();

		this.curr.setType("Question");
		this.curr.setValue(questionValue);

		if (bool) {
			this.curr.setLeft(new BinaryNode("Is your animal a " + animalValue + "?", "Animal"));
			this.curr.setRight(new BinaryNode(currValue, currType));
			this.curr.getLeft().setParent(this.curr);
			this.curr.getRight().setParent(this.curr);
		} else if (!bool) {
			this.curr.setLeft(new BinaryNode(currValue, currType));
			this.curr.setRight(new BinaryNode("Is your animal a " + animalValue + "?", "Animal"));
			this.curr.getLeft().setParent(this.curr);
			this.curr.getRight().setParent(this.curr);
		} else {
			throw new IllegalArgumentException("Something Went Wrong");
		}
	}

	/**
	 * Adds a new node with the specified value as a left child of the specified
	 * node. If parentNode has already a left child, then the left child of
	 * parentNode becomes the left child of the new node.
	 *
	 * @precondition node != null && value != null
	 * @param value      the value of the new node to be added
	 * @param type       the type of the new node to be added
	 * @param parentNode the parent of the new node
	 */
	public void addAsLeftChildOf(String value, String type, BinaryNode parentNode) {
		if (parentNode == null) {
			throw new IllegalArgumentException("node can not be null");
		}
		if (value == null) {
			throw new IllegalArgumentException("value can not be null");
		}

		BinaryNode newNode = new BinaryNode(value, type);
		newNode.setParent(parentNode);
		newNode.setLeft(parentNode.getLeft());
		parentNode.setLeft(newNode);
		if (newNode.getLeft() != null) {
			newNode.getLeft().setParent(newNode);
		}
	}

	/**
	 * Adds a new node with the specified value as a right child of the specified
	 * node. If parentNode has already a right child, then the right child of
	 * parentNode becomes the right child of the new node.
	 *
	 * @precondition node != null && value != null
	 * @param value      the value of the new node to be added
	 * @param type       the type of the new node to be added
	 * @param parentNode the parent of the new node
	 */
	public void addAsRightChildOf(String value, String type, BinaryNode parentNode) {
		if (parentNode == null) {
			throw new IllegalArgumentException("node cannot be null");
		}
		if (value == null) {
			throw new IllegalArgumentException("value cannot be null");
		}

		BinaryNode newNode = new BinaryNode(value, type);
		newNode.setParent(parentNode);
		newNode.setRight(parentNode.getRight());
		parentNode.setRight(newNode);
		if (newNode.getRight() != null) {
			newNode.getRight().setParent(newNode);
		}
	}

	/**
	 * Reset current
	 */
	public void resetCurrent() {
		this.curr = this.root;
	}

	/**
	 * Gets the left node
	 * 
	 * @return left node
	 */
	public BinaryNode getLeft() {
		if (this.curr.getLeft() != null) {
			this.curr = this.curr.getLeft();
		}
		return this.curr;
	}

	/**
	 * Gets the right node
	 * 
	 * @return right node
	 */
	public BinaryNode getRight() {
		if (this.curr.getRight() != null) {
			this.curr = this.curr.getRight();
		}
		return this.curr;
	}

	/**
	 * Gets the root node
	 * 
	 * @return root node
	 */
	public BinaryNode getRoot() {
		return this.root;
	}

	/**
	 * Gets the current node
	 * 
	 * @return current node
	 */
	public BinaryNode getCurrent() {
		return this.curr;
	}

	/**
	 * Sets the current node
	 *
	 * @precondition none
	 * @postcondition getRight() == right
	 * 
	 * @param node the node to be set
	 * 
	 */
	public void setCurrent(BinaryNode node) {
		if (node == null) {
			throw new IllegalArgumentException("current cannot be null");
		}
		this.curr = node;
	}

	/**
	 * Traverses the tree
	 * 
	 * @param node a node to traverse
	 * @return value and type of node
	 */
	public String traverseTree(BinaryNode node) {
		String list = "";
		if (node != null) {
			list += node.getValue();
			list += System.lineSeparator();
			list += node.getType();
			list += System.lineSeparator();
			list += this.traverseTree(node.getLeft());
			list += this.traverseTree(node.getRight());
		}
		return list;
	}
	
	public void recursiveLoad(ArrayList<BinaryNode> list) {
		boolean leftOrRight =  true;
		for (BinaryNode listItem : list) {
			if (leftOrRight) {
				this.curr.setLeft(listItem);
			} else {
				this.curr.setRight(listItem);
			}
		}
	}
}
