package models;

public class Move
{
	public Move(Tile oldTile, Tile newTile) {
		this.oldTile = oldTile;
		this.newTile = newTile;
	}
	
	private Tile oldTile;
	private Tile newTile;
	
	public Tile getOldTile()
	{
		return oldTile;
	}
	public void setOldTile(Tile oldTile)
	{
		this.oldTile = oldTile;
	}
	public Tile getNewTile()
	{
		return newTile;
	}
	public void setNewTile(Tile newTile)
	{
		this.newTile = newTile;
	}
	
	public void execute() {
		newTile.setPiece(oldTile.getPiece());
		oldTile.setPiece(null);
	}
}
