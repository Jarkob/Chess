package game;

import models.Board;
import models.Tuple;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
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
		
		// fill board with pieces
		// deploy pawns
		for(int i = 97; i < 105; i++) {
			this.board.getTiles().get(new Tuple<Character, Integer>((char) i, 2)).setPiece(
					new Pawn(this.board.getTiles().get(new Tuple<Character, Integer>((char) i, 2)), true));
			this.board.getTiles().get(new Tuple<Character, Integer>((char) i, 7)).setPiece(
					new Pawn(this.board.getTiles().get(new Tuple<Character, Integer>((char) i, 7)), false));
		}
		// deploy rooks
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 97, 1)).setPiece(
				new Rook(this.board.getTiles().get(new Tuple<Character, Integer>((char) 97, 1)), true));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 104, 1)).setPiece(
				new Rook(this.board.getTiles().get(new Tuple<Character, Integer>((char) 104, 1)), true));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 97, 8)).setPiece(
				new Rook(this.board.getTiles().get(new Tuple<Character, Integer>((char) 97, 8)), false));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 104, 8)).setPiece(
				new Rook(this.board.getTiles().get(new Tuple<Character, Integer>((char) 104, 8)), false));
		// deploy knights
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 98, 1)).setPiece(
				new Knight(this.board.getTiles().get(new Tuple<Character, Integer>((char) 98, 1)), true));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 103, 1)).setPiece(
				new Knight(this.board.getTiles().get(new Tuple<Character, Integer>((char) 103, 1)), true));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 98, 8)).setPiece(
				new Knight(this.board.getTiles().get(new Tuple<Character, Integer>((char) 98, 8)), false));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 103, 8)).setPiece(
				new Knight(this.board.getTiles().get(new Tuple<Character, Integer>((char) 103, 8)), false));
		// deploy bishops
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 99, 1)).setPiece(
				new Bishop(this.board.getTiles().get(new Tuple<Character, Integer>((char) 99, 1)), true));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 102, 1)).setPiece(
				new Bishop(this.board.getTiles().get(new Tuple<Character, Integer>((char) 102, 1)), true));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 99, 8)).setPiece(
				new Bishop(this.board.getTiles().get(new Tuple<Character, Integer>((char) 99, 8)), false));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 102, 8)).setPiece(
				new Bishop(this.board.getTiles().get(new Tuple<Character, Integer>((char) 102, 8)), false));
		// deploy queens
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 100, 1)).setPiece(
				new Queen(this.board.getTiles().get(new Tuple<Character, Integer>((char) 100, 1)), true));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 100, 8)).setPiece(
				new Queen(this.board.getTiles().get(new Tuple<Character, Integer>((char) 100, 8)), false));
		// deploy kings
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 101, 1)).setPiece(
				new King(this.board.getTiles().get(new Tuple<Character, Integer>((char) 101, 1)), true));
		this.board.getTiles().get(new Tuple<Character, Integer>((char) 101, 8)).setPiece(
				new King(this.board.getTiles().get(new Tuple<Character, Integer>((char) 101, 8)), false));
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
