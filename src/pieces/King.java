package pieces;

import models.Move;
import models.Tile;

public class King extends Piece
{
	public King(Tile tile, boolean color)
	{
		super(tile, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveLegal(Move move)
	{
		if((Math.abs((int) move.getOldTile().getX() - (int) move.getNewTile().getX()) == 1) && (Math.abs(move.getOldTile().getY() - move.getNewTile().getY()) == 1)) {
			// TODO: is tile threatened
			return move.isLegal();
		}
		return false;
	}
}
