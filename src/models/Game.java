package models;

import java.util.Scanner;

import game.UI;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

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
		
		// add board to ui test
		UI ui = new UI(this, this.board);
	}
	
	/**
	 * runs the game
	 * if this method is left, the game stops
	 * @param args run arguments (currently unused)
	 */
	public void run(String[] args) {
		System.out.printf("Chess - by Jakob Bussas%n%n");
		
		Scanner sc = new Scanner(System.in);
		boolean player = true;
		String input;
		char[] inputChars;
		Move move = null;
		
		while(true) {
			// print board
			System.out.printf("%n%n%n%n%n%n%n%n%n%n%n");
			System.out.printf(this.getBoard().toString());
			
			// get move input
			// while input is invalid
			while(true) {
				System.out.println((player ? "White" : "Black") + ": ");
				input = sc.nextLine();
				input = input.toLowerCase();
				inputChars = input.toCharArray();
				// check input
				if(this.isInputValid(inputChars)) {
					try {
						move = Move.create(
								this.board.getTiles().get(new Tuple<Character, Integer>(inputChars[0], Character.getNumericValue(inputChars[1]))),
								this.board.getTiles().get(new Tuple<Character, Integer>(inputChars[3], Character.getNumericValue(inputChars[4])))
								);
						
						if(move != null) {
							if(move.getOldTile().getPiece().isColor() != player) {
								System.out.println("It is the turn of player " + (player ? "White" : "Black"));
							} else {
								if(move.getOldTile().getPiece().isMoveLegal(move)) {
									// check if game is over
									if(move.getNewTile().getPiece() != null && move.getNewTile().getPiece() instanceof King) {
										System.out.println("Player " + (player ? "White" : "Black") + " won!");
										System.out.println("(Press enter to continue.)");
										System.in.read();
										sc.close();
										return;
									}
									move.execute();
									break;
								} else {
									System.out.println("Invalid move: " + move);
								}
							}
						}
					} catch (Exception e) {
						System.out.println("Invalid move: " + move);
						e.printStackTrace();
					}
				}
			}
			
			player ^= true;
		}
	}
	
	private boolean player;
	
	private int id;

	private Board board;

	/**
	 * get the player
	 * @return the player
	 */
	public boolean getPlayer()
	{
		return this.player;
	}
	
	/**
	 * set the player
	 * @param player the player
	 */
	public void setPlayer(boolean player)
	{
		this.player = player;
	}
	
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
	
	/**
	 * check if input is valid
	 * @param inputChars the input as array of chars
	 * @return if input is valid
	 */
	public boolean isInputValid(char[] inputChars) {
		if(inputChars.length != 5) {
			System.out.println("Wrong input format, input needs to be 5 characters long.");
			return false;
		} else if((int) inputChars[0] < 97 || (int) inputChars[0] > 104) {
			System.out.println("First input character needs to be a, b, c, d, e, f, g or h.");
			return false;
		} else if(Character.isDigit(inputChars[1]) && (Character.getNumericValue(inputChars[1]) < 1 || Character.getNumericValue(inputChars[1]) > 8)) {
			System.out.println("Second input character needs to be a number between 1 and 8 (inclusive).");
			return false;
		} else if(inputChars[2] != ';') {
			System.out.println("Third input character needs to be ;");
			return false;
		} else if((int) inputChars[3] < 97 || (int) inputChars[3] > 104) {
			System.out.println("Forth input character needs to be a, b, c, d, e, f, g or h.");
			return false;
		} else if(Character.isDigit(inputChars[1]) && (Character.getNumericValue(inputChars[4]) < 1 || Character.getNumericValue(inputChars[4]) > 8)) {
			System.out.println("Fifth input character needs to be a number between 1 and 8 (inclusive).");
			return false;
		} else {
			return true;
		}
	}
}
