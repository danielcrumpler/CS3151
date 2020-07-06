package edu.westga.cs3151.project3.model;

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
	 * Adds a new node with the specified value as a left child of the specified
	 * node. If parentNode has already a left child, then the left child of
	 * parentNode becomes the left child of the new node.
	 * 
	 * @precondition node != null && value != null
	 * 
	 * @param value      the value of the new node to be added
	 * @param type       the type of new node to be added
	 * @param parentNode the parent of the new node
	 */
	public void addAsLeftChildOf(String value, String type, BinaryNode parentNode) {
		if (parentNode == null) {
			throw new IllegalArgumentException("node can not be null");
		}
		if (value == null) {
			throw new IllegalArgumentException("value can not be null");
		}
		if (type == null) {
			throw new IllegalArgumentException("type can not be null");
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
	 * Adds a new node with the specified value as a left child of the specified
	 * node. If parentNode has already a left child, then the left child of
	 * parentNode becomes the left child of the new node.
	 * 
	 * @precondition node != null && value != null
	 * 
	 * @param value      the value of the new node to be added
	 * @param type       the type of new node to be added
	 * @param parentNode the parent of the new node
	 */
	public void addAsRightChildOf(String value, String type, BinaryNode parentNode) {
		if (parentNode == null) {
			throw new IllegalArgumentException("node cannot be null");
		}
		if (value == null) {
			throw new IllegalArgumentException("value cannot be null");
		}
		if (type == null) {
			throw new IllegalArgumentException("type cannot be null");
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
		BinaryNode question = new BinaryNode(questionValue, "Question");
		BinaryNode animal = new BinaryNode("Is your animal a" + animalValue + "?", "Animal");
		BinaryNode curr = this.curr;
		BinaryNode parent = curr.getParent();

		question.setParent(parent);
		animal.setParent(question);
		curr.setParent(question);
		if (bool) {
			question.setLeft(animal);
			question.setRight(curr);
		} else {
			question.setLeft(curr);
			question.setRight(animal);
		}
		this.curr = question;
		this.resetRoot();
	}

	private void resetRoot() {
		if (this.curr.getParent() == null) {
			this.root = this.curr;
		} else {
			this.resetRoot();
		}
	}

	/**
	 * Gets the left node
	 * 
	 * @return left node
	 */
	public BinaryNode getLeft() {
		if (this.curr == null) {
			this.curr = this.root.getLeft();
			return this.curr;
		} else {
			this.curr = this.curr.getLeft();
			return this.curr;
		}
	}

	/**
	 * Gets the right node
	 * 
	 * @return right node
	 */
	public BinaryNode getRight() {
		if (this.curr == null) {
			this.curr = this.root.getRight();
			return this.curr;
		} else {
			this.curr = this.curr.getRight();
			return this.curr;
		}
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
}
