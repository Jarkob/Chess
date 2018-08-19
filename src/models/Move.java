package models;

import pieces.Pawn;

/**
 * move of a piece
 * @author jakobbussas
 *
 */
public class Move
{
	/**
	 * creates new move and validates that tiles are not equal
	 * @param oldTile the old tile
	 * @param newTile the new tile
	 * @return the move instance
	 */
	public static Move create(Tile oldTile, Tile newTile) {
		if(oldTile != newTile) {
			return new Move(oldTile, newTile);
		}
		
		System.out.println("Tiles for a move have to be different.");
		return null;
	}
	
	/**
	 * creates new move
	 * @param oldTile the old tile
	 * @param newTile the new tile
	 */
	public Move(Tile oldTile, Tile newTile) {
		this.oldTile = oldTile;
		this.newTile = newTile;
	}
	
	private Tile oldTile;
	private Tile newTile;
	
	/**
	 * get the old tile
	 * @return the old tile
	 */
	public Tile getOldTile()
	{
		return oldTile;
	}
	
	/**
	 * set the old tile
	 * @param oldTile the old tile
	 */
	public void setOldTile(Tile oldTile)
	{
		this.oldTile = oldTile;
	}
	
	/**
	 * get the new tile
	 * @return the new tile
	 */
	public Tile getNewTile()
	{
		return newTile;
	}
	
	/**
	 * set the new tile
	 * @param newTile the new tile
	 */
	public void setNewTile(Tile newTile)
	{
		this.newTile = newTile;
	}
	
	/**
	 * check if move is legal
	 * @return if move is legal
	 */
	public boolean isLegal() {
		return this.oldTile.getPiece() != null && (this.newTile.getPiece() == null || this.newTile.getPiece().isColor() == !this.oldTile.getPiece().isColor());
	}
	
	/**
	 * execute move
	 */
	public void execute() {
		newTile.setPiece(oldTile.getPiece());
		oldTile.setPiece(null);
		
		// update UI
		newTile.updateButton();
		oldTile.updateButton();
	}

	/**
	 * format move as string
	 */
	@Override
	public String toString()
	{
		return "Move [oldTile=" + oldTile.getX() + oldTile.getY() + ", newTile=" + newTile.getX() + newTile.getY() + "]";
	}
}
