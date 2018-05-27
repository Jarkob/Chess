package game;

import models.Game;

public class App
{
	public static void main(String[] args) {
		// TODO:
		// en passant
		// trade pawns
		// rochade
		// check mate
		// move only legal if king isn't threatened afterwards
		
		// primitive implementation: game ends when king is taken
		Game testGame = new Game(1);
		System.out.printf(testGame.getBoard().toString());
	}
}
