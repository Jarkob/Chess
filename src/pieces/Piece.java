package pieces;

import models.Move;
import models.Tile;

public abstract class Piece {
	public Piece(Tile tile, String color) {
		this.tile = tile;
		this.tile.setPiece(this);
		this.color = color;
	}

	protected Tile tile;
	protected String color;
	
	public Tile getTile()
	{
		return tile;
	}
	public void setTile(Tile tile)
	{
		this.tile = tile;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public abstract boolean isMoveLegal(Move move);
}
