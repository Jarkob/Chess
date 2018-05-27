package game;

import models.Game;

/**
 * main class from which the program launches
 * @author jakobbussas
 *
 */
public class App
{
	/**
	 * launches the program
	 * @param args runtime arguments (currently unused)
	 */
	public static void main(String[] args) {
		Game testGame = new Game(1);
		testGame.run(args);
	}
}
