package models;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

// could be prettier although it will never change
public class Game
{
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
				new King(this.board.getTiles().get(new Tuple<Character, Integer>((char) 101, 8)), true));
	}
	
	public void run(String[] args) {
		System.out.println("Started");
		
		System.out.printf(this.getBoard().toString());
	}
	
	private int id;
	private Board board;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Board getBoard()
	{
		return board;
	}
	public void setBoard(Board board)
	{
		this.board = board;
	}
}
