package pieces;

import models.Move;
import models.Tile;
import models.Tuple;

/**
 * represents a pawn
 * @author jakobbussas
 *
 */
public class Pawn extends Piece
{
	/**
	 * creates a new pawn
	 * @param tile the tile on which the pawn stands
	 * @param color the color of the pawn
	 */
	public Pawn(Tile tile, boolean color)
	{
		super(tile, color);
	}
	
	/**
	 * check if a pawn is promoted after a move
	 * @param move
	 * @return
	 */
	public boolean promotion(Move move)
	{
		if(this.color) {
			if(move.getNewTile().getY() == 8) {
				return true;
			}
		} else {
			if(move.getNewTile().getY() == 1) {
				return true;
			}
		}
		return false;
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
						&& move.getOldTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece() == null
						&& move.getOldTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY() - 1)).getPiece() == null
						&& move.getOldTile().getY() == 2) {
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
						&& move.getOldTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece() == null
						&& move.getOldTile().getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY() + 1)).getPiece() == null
						&& move.getOldTile().getY() == 7) {
					return true;
				}
			}
		}
		// take
		// TODO en passant
//		else if((((int) move.getNewTile().getX()) == ((int) move.getOldTile().getX() + 1) || ((int) move.getNewTile().getX() == (int) move.getOldTile().getX() - 1)) && move.getNewTile().getPiece() != null) {
//			// check direction of movement
//			if(Math.abs(move.getOldTile().getY() - move.getNewTile().getY()) == 1) {
//				if(this.tile.getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece().isColor() != this.isColor()) {
//					return true;
//				}
//			}
//		}
		
		
		return false;
	}
}
