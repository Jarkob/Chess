package models;

import pieces.Pawn;

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
