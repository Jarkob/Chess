package pieces;

import models.Move;
import models.Tile;
import models.Tuple;

public class Rook extends Piece
{
	public Rook(Tile tile, boolean color)
	{
		super(tile, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveLegal(Move move)
	{
		// vertical move
		if(move.getOldTile().getX() == move.getNewTile().getX()) {
			// between tiles need to be empty
			for(int i = Math.min(move.getOldTile().getY(), move.getNewTile().getY()) + 1; i < Math.max(move.getNewTile().getY(), move.getOldTile().getY()); i++) {
				if(this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>(this.getTile().getX(), i)).getPiece() != null) {
					return false;
				}
			}
			
			// take or not take
			return move.getNewTile().getPiece() == null || move.getNewTile().getPiece().isColor() == !this.isColor();
		}
		// horizontal move
		else if(move.getOldTile().getY() == move.getNewTile().getY()) {
			// between tiles need to be empty
			for(int i = Math.min((int) move.getOldTile().getX(), (int) move.getNewTile().getX()) + 1; i < Math.max((int) move.getNewTile().getX(), (int) move.getOldTile().getX()); i++) {
				if(this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>((char) i, this.getTile().getY())).getPiece() != null) {
					return false;
				}
			}
			
			// take or not take
			return move.getNewTile().getPiece() == null || move.getNewTile().getPiece().isColor() == !this.isColor();
		}
		return false;
	}
}
