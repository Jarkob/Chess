package pieces;

import models.Move;
import models.Tile;

public class Knight extends Piece
{
	public Knight(Tile tile, boolean color)
	{
		super(tile, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveLegal(Move move)
	{
		if((((int) move.getNewTile().getX() == (int) move.getOldTile().getX() + 1 || (int) move.getNewTile().getX() == (int) move.getOldTile().getX() - 1) && (move.getNewTile().getY() == move.getOldTile().getY() + 2 || move.getNewTile().getY() == move.getOldTile().getY() - 2))
				|| ((move.getNewTile().getY() == move.getOldTile().getY() + 1 || move.getNewTile().getY() == move.getOldTile().getY() - 1) && (move.getNewTile().getX() == move.getOldTile().getX() + 2 || move.getNewTile().getX() == move.getOldTile().getX() - 2))) {
			if(move.getNewTile().getPiece() == null) {
				return true;
			} else if(move.getNewTile().getPiece().isColor() == !this.isColor()) {
				return true;
			}
		}
		return false;
	}
}
