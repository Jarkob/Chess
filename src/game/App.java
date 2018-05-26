package game;

import models.Game;

public class App
{
	public static void main(String[] args) {
		Game testGame = new Game(1);
		System.out.printf(testGame.getBoard().toString());
	}
}
