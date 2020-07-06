package edu.westga.cs3151.project3.model;

/**
 * Class BinaryNode
 * 
 * @author Daniel Crumpler
 */
public class BinaryNode {
	private String value;
	private BinaryNode parent;
	private BinaryNode left;
	private BinaryNode right;

	/**
	 * Instantiates a new node
	 * @param value value
	 */
	public BinaryNode(String value) {
		this.setValue(value);
		this.setParent(null);
		this.setLeft(null);
		this.setRight(null);
	}

	/**
	 * Gets the value
	 * 
	 * @return value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Sets the value for the node
	 * 
	 * @precondition value != null && !value.isEmpty
	 * @postcondition getValue() == value
	 * 
	 * @param value value to be set
	 */
	public void setValue(String value) {
		if (value == null) {
			throw new IllegalArgumentException("value cannot be null");
		}
		if (value.isEmpty()) {
			throw new IllegalArgumentException("value cannot be empty");
		}
		this.value = value;
	}
	
	/**
	 * Gets the parent node
	 * 
	 * @return parent node
	 */
	public BinaryNode getParent() {
		return this.parent;
	}
	
	/**
	 * Sets the parent node
	 *
	 * @precondition none
	 * @postcondition getParent() == right
	 * 
	 * @param parent parent node to be set
	 */
	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}

	/**
	 * Gets the left node
	 * 
	 * @return left node
	 */
	public BinaryNode getLeft() {
		return this.left;
	}

	/**
	 * Sets the left node
	 *
	 * @precondition none
	 * @postcondition getLeft() == right
	 * 
	 * @param left left node to be set
	 */
	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	/**
	 * Gets the right node
	 * 
	 * @return right node
	 */
	public BinaryNode getRight() {
		return this.right;
	}

	/**
	 * Sets the right node
	 *
	 * @precondition none
	 * @postcondition getRight() == right
	 * 
	 * @param right right node to be set
	 */
	public void setRight(BinaryNode right) {
		this.right = right;
	}
}