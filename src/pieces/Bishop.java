package pieces;

import models.Move;
import models.Tile;

public class Bishop extends Piece {

	public Bishop(Tile tile, String color)
	{
		super(tile, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isMoveLegal(Move move) {
		// TODO
		return false;
	}
}
