package edu.westga.cs3151.project3.model;

/**
 * Class BinaryNode
 * 
 * @author Daniel Crumpler
 */
public class BinaryNode {
	private String value;
	private String type;
	private BinaryNode parent;
	private BinaryNode left;
	private BinaryNode right;

	/**
	 * Instantiates a new node
	 * @param value the value
	 * @param type the type
	 */
	public BinaryNode(String value, String type) {
		this.setValue(value);
		this.setType(type);
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
	 * Gets the type
	 * 
	 * @return type type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the type for the node
	 * 
	 * @precondition type != null && !type.isEmpty
	 * @postcondition getType() == type
	 * 
	 * @param type type to be set
	 */
	public void setType(String type) {
		if (type == null) {
			throw new IllegalArgumentException("type cannot be null");
		}
		if (type.isEmpty()) {
			throw new IllegalArgumentException("type cannot be empty");
		}
		this.type = type;
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