package pieces;

import models.Move;
import models.Tile;

/**
 * represents a king
 * @author jakobbussas
 *
 */
public class King extends Piece
{
	/**
	 * creates new king
	 * @param tile the tile on which the king stands
	 * @param color the color of the king
	 */
	public King(Tile tile, boolean color)
	{
		super(tile, color);
	}

	@Override
	public boolean isMoveLegal(Move move)
	{
		if((Math.abs((int) move.getOldTile().getX() - (int) move.getNewTile().getX()) == 1) || (Math.abs(move.getOldTile().getY() - move.getNewTile().getY()) == 1)) {
			// TODO: is tile threatened
			return move.isLegal();
		}
		return false;
	}
}
