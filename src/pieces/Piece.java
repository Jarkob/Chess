package pieces;

import models.Move;
import models.Tile;

public abstract class Piece {
	public Piece(Tile tile, boolean color) {
		this.tile = tile;
		this.tile.setPiece(this);
		this.color = color;
	}

	protected Tile tile;
	protected boolean color;
	
	public Tile getTile()
	{
		return tile;
	}
	public void setTile(Tile tile)
	{
		this.tile = tile;
	}
	public boolean isColor()
	{
		return color;
	}
	public void setColor(boolean color)
	{
		this.color = color;
	}
	
	public abstract boolean isMoveLegal(Move move);
}
