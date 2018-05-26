package models;

public class Game
{
	public Game(int id) {
		this.id = id;
		this.board = new Board(id);
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
