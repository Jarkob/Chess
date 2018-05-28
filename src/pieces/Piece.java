package pieces;

import models.Move;
import models.Tile;

/**
 * represents an abstraction for a piece
 * @author jakobbussas
 *
 */
public abstract class Piece {
	/**
	 * creates new piece
	 * @param tile the tile on which the piece stands
	 * @param color the color of the piece
	 */
	public Piece(Tile tile, boolean color) {
		this.tile = tile;
		this.tile.setPiece(this);
		this.color = color;
	}

	/**
	 * the tile on which the piece stands
	 */
	protected Tile tile;
	
	/**
	 * the color of the piece
	 */
	protected boolean color;
	
	/**
	 * get the tile
	 * @return the tile
	 */
	public Tile getTile()
	{
		return tile;
	}
	
	/**
	 * set the tile
	 * @param tile the tile
	 */
	public void setTile(Tile tile)
	{
		this.tile = tile;
	}
	
	/**
	 * get the color of the piece
	 * @return true for white, false for black
	 */
	public boolean isColor()
	{
		return color;
	}
	
	/**
	 * set the color of the piece
	 * @param color true for white, false for black
	 */
	public void setColor(boolean color)
	{
		this.color = color;
	}
	
	/**
	 * check if a move for a specific piece is legal
	 * @param move the move
	 * @return if the move is legal
	 */
	public abstract boolean isMoveLegal(Move move);
	
	@Override
	public String toString()
	{
		return (this.isColor() ? "w" : "b") + this.getClass().toString().split("\\.")[this.getClass().toString().split("\\.").length - 1].substring(0, 1);
	}
}
