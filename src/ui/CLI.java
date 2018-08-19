package ui;

import java.util.Scanner;

import models.Board;
import models.Move;
import models.Tuple;
import pieces.King;

/**
 * class for command line interface
 * @author jakobbussas
 *
 */
public class CLI
{
	/**
	 * creates a new CLI instance
	 * @param board the board of the game
	 */
	public CLI(Board board) {
		this.board = board;
	}
	
	/**
	 * runs the game
	 * if this method is left, the game stops
	 * @param args run arguments (currently unused)
	 */
	public void run(String[] args)
	{
		System.out.printf("Chess - by Jakob Bussas%n%n");
		
		Scanner sc = new Scanner(System.in);
		this.player = true;
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
									// check if promotion
									// TODO
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
