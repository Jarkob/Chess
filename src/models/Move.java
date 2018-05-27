package models;

public class Move
{
	public static Move create(Tile oldTile, Tile newTile) throws Exception {
		if(oldTile != newTile) {
			return new Move(oldTile, newTile);
		}
		
		throw new Exception("Tiles for a move have to be different.");
	}
	
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
	
	public boolean isLegal() {
		return this.oldTile.getPiece() != null && this.newTile.getPiece().isColor() == !this.oldTile.getPiece().isColor();
	}
	
	public void execute() {
		newTile.setPiece(oldTile.getPiece());
		oldTile.setPiece(null);
	}

	@Override
	public String toString()
	{
		return "Move [oldTile=" + oldTile.getX() + oldTile.getY() + ", newTile=" + newTile.getX() + newTile.getY() + "]";
	}
}
