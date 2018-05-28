package pieces;

import models.Move;
import models.Tile;
import models.Tuple;

/**
 * represents a queen
 * @author jakobbussas
 *
 */
public class Queen extends Piece
{
	/**
	 * creates new queen
	 * @param tile the tile on which the queen stands
	 * @param color the color of the queen
	 */
	public Queen(Tile tile, boolean color)
	{
		super(tile, color);
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
		// diagonal move
		else if(Math.abs(move.getNewTile().getX() - move.getOldTile().getX()) == Math.abs(move.getNewTile().getY() - move.getOldTile().getY())) {
			// all inbetween fields need to be empty
			if(move.getOldTile().getX() < move.getNewTile().getX() && move.getOldTile().getY() < move.getNewTile().getY()) {
				// move to upper right
				for(int i = 1; i < move.getNewTile().getX() - move.getOldTile().getX(); i++) {
					if(this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>((char)((int) move.getOldTile().getX() + i), move.getOldTile().getY() + i)).getPiece() != null) {
						return false;
					}
				}
			} else if(move.getOldTile().getX() < move.getNewTile().getX() && move.getOldTile().getY() > move.getNewTile().getY()) {
				// move to lower right
				for(int i = 1; i < move.getNewTile().getX() - move.getOldTile().getX(); i++) {
					if(this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>((char)((int) move.getOldTile().getX() + i), move.getOldTile().getY() - i)).getPiece() != null) {
						return false;
					}
				}
			} else if(move.getOldTile().getX() > move.getNewTile().getX() && move.getOldTile().getY() > move.getNewTile().getY()) {
				// move to lower left
				for(int i = 1; i < move.getNewTile().getX() - move.getOldTile().getX(); i++) {
					if(this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>((char)((int) move.getOldTile().getX() - i), move.getOldTile().getY() - i)).getPiece() != null) {
						return false;
					}
				}
			} else if(move.getOldTile().getX() > move.getNewTile().getX() && move.getOldTile().getY() < move.getNewTile().getY()) {
				// move to upper left
				for(int i = 1; i < move.getNewTile().getX() - move.getOldTile().getX(); i++) {
					if(this.getTile().getBoard().getTiles().get(new Tuple<Character, Integer>((char)((int) move.getOldTile().getX() - i), move.getOldTile().getY() + i)).getPiece() != null) {
						return false;
					}
				}
			}
			
			// take or not
			return move.isLegal();
		}
		return false;
	}
}
