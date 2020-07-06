package edu.westga.dsdm.calculator;

/**
 * The Class Add
 * 
 * @author CS3151
 */
public class Add {

	/**
	 * Adds the command line arguments
	 * 
	 * @param args operands of the add operation
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java Add operand [operand]...");
			return;
		}
		
		double result = 0;
		for (int i = 0; i < args.length; i++) {
			result += Double.parseDouble(args[i]);
		}
		
		System.out.println(result);
	}

}
