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
	 * @param valueRoot  value of the root
	 */

	public BinaryTree(String valueRoot) {
		if (valueRoot == null) {
			throw new IllegalArgumentException("the value of the root cannot be null");
		}
		if (valueRoot.isEmpty()) {
			throw new IllegalArgumentException("the value of the root cannot be empty");
		}
		this.root = new BinaryNode(valueRoot);
	}

	/**
	 * Adds a new node with the specified value as a left child of the specified
	 * node. If parentNode has already a left child, then the left child of
	 * parentNode becomes the left child of the new node.
	 * 
	 * @precondition node != null && value != null
	 * 
	 * @param value      the value of the new node to be added
	 * @param parentNode the parent of the new node
	 */
	public void addAsLeftChildOf(String value, BinaryNode parentNode) {
		if (parentNode == null) {
			throw new IllegalArgumentException("node can not be null");
		}
		if (value == null) {
			throw new IllegalArgumentException("value can not be null");
		}
		BinaryNode newNode = new BinaryNode(value);
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
	 * @param parentNode the parent of the new node
	 */
	public void addAsRightChildOf(String value, BinaryNode parentNode) {
		if (parentNode == null) {
			throw new IllegalArgumentException("node cannot be null");
		}
		if (value == null) {
			throw new IllegalArgumentException("value cannot be null");
		}
		BinaryNode newNode = new BinaryNode(value);
		newNode.setParent(parentNode);
		newNode.setRight(parentNode.getRight());
		parentNode.setRight(newNode);
		if (newNode.getRight() != null) {
			newNode.getRight().setParent(newNode);
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
			return this.curr.getLeft();
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
			return this.curr.getRight();
		}
	}
}
