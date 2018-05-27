package pieces;

import models.Move;
import models.Tile;
import models.Tuple;

public class Pawn extends Piece
{
	public Pawn(Tile tile, boolean color)
	{
		super(tile, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveLegal(Move move)
	{
		// don't take
		if(move.getNewTile().getX() == move.getOldTile().getX()) {
			// white
			if(this.isColor()) {
				if(move.getNewTile().getY() - move.getOldTile().getY() == 1 && this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece() == null) {
					return true;
				}
				// first move
				else if(move.getNewTile().getY() - move.getOldTile().getY() == 2
						&& this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece() == null
						&& this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY() - 1)).getPiece() == null) {
					return true;
				}
			}
			// black
			else {
				if(move.getOldTile().getY() - move.getNewTile().getY() == 1 && this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece() == null) {
					return true;
				}
				// first move
				else if(move.getOldTile().getY() - move.getNewTile().getY() == 2
						&& this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece() == null
						&& this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY() + 1)).getPiece() == null) {
					return true;
				}
			}
		}
		// take
		// TODO en passant
		else if(((int) move.getNewTile().getX()) == ((int) move.getOldTile().getX() + 1) || ((int) move.getNewTile().getX() == (int) move.getOldTile().getX() - 1)) {
			// check direction of movement
			if(this.isColor()) {
				if(move.getNewTile().getY() - move.getOldTile().getY() == 1) {
					if(!this.tile.getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece().isColor()) {
						return true;
					}
				}
			} else {
				if(move.getOldTile().getY() - move.getNewTile().getY() == 1) {
					if(this.tile.getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece().isColor()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
