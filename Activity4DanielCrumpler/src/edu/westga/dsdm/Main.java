package edu.westga.dsdm;

import edu.westga.dsdm.controller.Controller;
import edu.westga.dsdm.snowflake.SnowflakeQueueApp;
import edu.westga.dsdm.snowflake.SnowflakeStackApp;

/**
 * The Class Main
 * 
 * The entry point into the application
 * 
 * @author CS3151
 */
public class Main {

	/**
	 * Entry point into the application
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.run();
		
		SnowflakeStackApp world1 = new SnowflakeStackApp(); 
		SnowflakeQueueApp world2 = new SnowflakeQueueApp();
		world1.setVisible(true); 
		world1.run();
		world2.setVisible(true); 
		world2.run();
	}
}
