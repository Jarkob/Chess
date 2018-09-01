package game;

import models.Board;
import models.Move;
import ui.CLI;
import ui.GUI;

/**
 * class represents one game between two players
 * @author jakobbussas
 * 
 */
public class Game
{
	/**
	 * creates new Game instance
	 * @param id id of the game
	 */
	public Game(int id) {
		this.id = id;
		this.board = new Board(id);
		this.board.fill();
	}
	
	/**
	 * runs the game
	 * if this method is left, the game stops
	 * @param args first argument can be either gui or cli and determines the type of the interface
	 */
	public void run(String[] args) {
		if(args.length != 1) {
			System.out.println("The type of the interface (graphical or command line) needs to be specified");
			return;
		}
		if(args[0].equals("gui")) {
			GUI ui = new GUI(this.board);
			ui.run(args);
		} else if(args[0].equals("cli")) {
			CLI cli = new CLI(this.board);
			cli.run(args);
		} else {
			System.out.println("Unknown interface type: " + args[0]);
			System.out.println("Currently only gui and cli available");
			return;
		}
	}
	
	private int id;

	private Board board;
	
	/**
	 * get the id
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * set the id
	 * @param id the id
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * get the board
	 * @return the board
	 */
	public Board getBoard()
	{
		return board;
	}
	
	/**
	 * set the board
	 * @param board the board
	 */
	public void setBoard(Board board)
	{
		this.board = board;
	}
}
