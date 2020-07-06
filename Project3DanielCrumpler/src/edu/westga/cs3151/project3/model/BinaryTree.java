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

	/**
	 * Performs the adding method of new nodes to a tree for a load.
	 * 
	 * @param list ArrayList of nodes to be added to tree
	 */
	public void loadList(ArrayList<BinaryNode> list) {
		boolean right = false;
		boolean stepUp = false;
		for (BinaryNode listItem : list) {
			if (right && stepUp) {
				this.curr = this.curr.getParent();
				this.formRight(listItem);
				if (listItem.getType().equals("Animal")) {
					stepUp = true;
					right = true;
				} else {
					stepUp = false;
					right = this.ifQuestionIsRight();
				}
			} else if (right && !stepUp) {
				this.formRight(listItem);
				if (listItem.getType().equals("Animal")) {
					stepUp = true;
					right = true;
				} else {
					right = this.ifQuestionIsRight();
				}
			} else if (!right && !stepUp) {
				this.formLeft(listItem);
				if (listItem.getType().equals("Animal")) {
					right = true;
				} else {
					this.curr = this.curr.getLeft();
				}
			} else {
				throw new IllegalArgumentException("Problem Importing");
			}
		}
	}

	private boolean ifQuestionIsRight() {
		boolean right;
		this.curr = this.curr.getRight();
		right = false;
		return right;
	}

	private void formLeft(BinaryNode listItem) {
		this.curr.setLeft(listItem);
		this.curr.getLeft().setParent(this.curr);
	}

	private void formRight(BinaryNode listItem) {
		this.curr.setRight(listItem);
		this.curr.getRight().setParent(this.curr);
	}
}
