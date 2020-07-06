package edu.westga.cs3151.the8puzzle.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * The Class Position
 * 
 * @author Daniel Crumpler
 */
public class PuzzleSolver {

	private static final String ZERO = "0";
	private String curr;
	private String goal;
	private LinkedList<String> openList;
	private Map<String, Integer> depthMap;
	private Map<String, String> heirarchyMap;
	private int nodes = 0;
	private int limit = 100;
	private int unique = -1;
	private int newValue;
	private int blank;
	private String currState;
	private boolean solution = false;
	private Queue<Move> queue;
	private Stack<String> stack;

	/**
	 * Add Root to Breadth-First Search.
	 * 
	 * @param board the board
	 */
	public PuzzleSolver(Board board) {
		this.queue = new LinkedList<Move>();
		this.stack = new Stack<String>();
		this.openList = new LinkedList<String>();
		this.depthMap = new HashMap<String, Integer>();
		this.heirarchyMap = new HashMap<String, String>();
		this.convertBoard(board);
		this.goal = "123456780";
		this.addToOpenList(this.curr, null);
		this.doSearch();
		this.printSolution(this.currState);
	}

	private void convertBoard(Board board) {
		String theBoard = "";
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				Position pos = new Position(row, col);
				theBoard += board.getTile(pos);
			}
		}
		this.curr = theBoard;
	}

	/**
	 * Retrieves the open list and removes the default node. Checks if current state
	 * is a goal state.
	 */
	private void doSearch() {
		while (!this.openList.isEmpty()) {
			this.currState = this.openList.removeFirst();
			if (this.currState.equals(this.goal)) {
				this.solution = true;
				this.printSolution(this.currState);
				break;
			}
			if (this.depthMap.get(this.currState) == this.limit) {
				this.solution = false;
				this.printSolution(this.currState);
				break;
			} else {
				this.blank = this.currState.indexOf(ZERO);
				this.whileChecks();
			}
		}
		if (this.solution) {
			System.out.println("Solution found");
		} else {
			System.out.println("Solution cannot be found");
		}

	}

	private void whileChecks() {
		while (this.blank != 0 && this.blank != 3 && this.blank != 6) {
			String nextState = this.currState.substring(0, this.blank - 1) + ZERO
					+ this.currState.charAt(this.blank - 1) + this.currState.substring(this.blank + 1);
			this.addToOpenList(nextState, this.currState);
			this.nodes++;
			break;
		}
		while (this.blank != 0 && this.blank != 1 && this.blank != 2) {
			String nextState = this.currState.substring(0, this.blank - 3) + ZERO
					+ this.currState.substring(this.blank - 2, this.blank) + this.currState.charAt(this.blank - 3)
					+ this.currState.substring(this.blank + 1);
			this.addToOpenList(nextState, this.currState);
			this.nodes++;
			break;
		}
		while (this.blank != 2 && this.blank != 5 && this.blank != 8) {
			String nextState = this.currState.substring(0, this.blank) + this.currState.charAt(this.blank + 1) + ZERO
					+ this.currState.substring(this.blank + 2);
			this.addToOpenList(nextState, this.currState);
			this.nodes++;
			break;
		}
		while (this.blank != 6 && this.blank != 7 && this.blank != 8) {
			String nextState = this.currState.substring(0, this.blank)
					+ this.currState.substring(this.blank + 3, this.blank + 4)
					+ this.currState.substring(this.blank + 1, this.blank + 3) + ZERO
					+ this.currState.substring(this.blank + 4);

			this.addToOpenList(nextState, this.currState);
			this.nodes++;
			break;
		}
	}

	/**
	 * Adds to the list, checks the depth with the new state and puts old state into
	 * history.
	 * 
	 * @precondition none
	 * @postcondition added a state to the list
	 * 
	 * @param newState the new level at which the state was discovered
	 * @param oldState the old level at which the state was discovered
	 */
	private void addToOpenList(String newState, String oldState) {
		if (!this.depthMap.containsKey(newState)) {
			this.newValue = oldState == null ? 0 : this.depthMap.get(oldState) + 1;
			this.unique++;
			this.depthMap.put(newState, this.newValue);
			this.openList.add(newState);
			this.heirarchyMap.put(newState, oldState);
		}

	}

	private void printSolution(String currState) {
		if (this.solution) {
			System.out.println("Solution found in " + this.depthMap.get(currState) + " step(s)");
			System.out.println("Node generated: " + nodes);
			System.out.println("Unique Node generated: " + unique);
		} else {

			System.out.println("Solution not found!");
			System.out.println("Depth Limit Reached!");
			System.out.println("Node generated: " + nodes);
			System.out.println("Unique Node generated: " + unique);
		}

		String traceState = currState;
		this.convertStringToMoves(traceState);
		while (traceState != null) {
			System.out.println(traceState + " at " + this.depthMap.get(traceState));
			try {
				for (int i = 0; i < 9; i++) {
					System.out.print(" " + String.valueOf(traceState.charAt(i)) + " ");
					if ((i + 1) % 3 == 0) {
						System.out.println();

					}
				}
			} catch (NullPointerException e) {
			}
			traceState = this.heirarchyMap.get(traceState);
		}

	}

	private void convertStringToMoves(String traceState) {
		Stack<String> stack = new Stack<String>();
		String output = "";
		while (traceState != null) {
			try {
				for (int i = 0; i < 9; i++) {
					output += String.valueOf(traceState.charAt(i) + ",");
				}
				stack.add(output);
			} catch (NullPointerException e) {
			}
			traceState = this.heirarchyMap.get(traceState);
			output = "";
		}
		Stack<String> stack2 = new Stack<String>();
		for (String string : stack) {
			stack2.add(string);
		}
		this.stack = stack2;
	}
	
	/**
	 * Gets the queue to be traced
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the queue
	 */
	public Queue<Move> getQueue() {
		return this.queue;
	}

	/**
	 * Gets the stack to be traced
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the stack
	 */
	public Stack<String> getStack() {
		return this.stack;
	}
}
