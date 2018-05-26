package pieces;

import models.Move;
import models.Tile;

public class Queen extends Piece
{
	public Queen(Tile tile, boolean color)
	{
		super(tile, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveLegal(Move move)
	{
		// TODO Auto-generated method stub
		return false;
	}
}
