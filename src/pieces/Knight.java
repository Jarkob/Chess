package pieces;

import models.Move;
import models.Tile;

/**
 * represents a knight
 * @author jakobbussas
 *
 */
public class Knight extends Piece
{
	/**
	 * creates new knight
	 * @param tile the tile on which the knight stands
	 * @param color the color of the knight
	 */
	public Knight(Tile tile, boolean color)
	{
		super(tile, color);
	}

	@Override
	public boolean isMoveLegal(Move move)
	{
		if((((int) move.getNewTile().getX() == (int) move.getOldTile().getX() + 1 || (int) move.getNewTile().getX() == (int) move.getOldTile().getX() - 1) && (move.getNewTile().getY() == move.getOldTile().getY() + 2 || move.getNewTile().getY() == move.getOldTile().getY() - 2))
				|| ((move.getNewTile().getY() == move.getOldTile().getY() + 1 || move.getNewTile().getY() == move.getOldTile().getY() - 1) && (move.getNewTile().getX() == move.getOldTile().getX() + 2 || move.getNewTile().getX() == move.getOldTile().getX() - 2))) {
			return move.isLegal();
		}
		return false;
	}
}
