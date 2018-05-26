package models;

import pieces.Piece;

public class Tile
{
	public Tile(char x, int y, boolean color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	private char x;
	private int y;
	private boolean color;
	private Piece piece;
	
	public char getX()
	{
		return x;
	}
	public void setX(char x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public boolean isColor()
	{
		return color;
	}
	public void setColor(boolean color)
	{
		this.color = color;
	}
	public Piece getPiece()
	{
		return piece;
	}
	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}
	
	// TODO: update for display of occupying piece
	@Override
	public String toString()
	{
		return this.color ? "W" : "B";
//		return new String() + this.x + this.y;
	}
}
