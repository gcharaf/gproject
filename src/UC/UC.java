/**
 * 
 */
package UC;

import UC.UI.MainScreen;


/**
 * @author Charaf
 *
 */
public class UC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Testing for the screen
		MainScreen ms = new MainScreen("Unit Control", 600, 400);
		System.out.println(ms.toString());
		
	}

}


