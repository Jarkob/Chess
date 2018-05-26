package pieces;

import models.Move;
import models.Tile;
import models.Tuple;

public class Bishop extends Piece {

	public Bishop(Tile tile, boolean color)
	{
		super(tile, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isMoveLegal(Move move)
	{
		if(Math.abs(move.getNewTile().getX() - move.getOldTile().getX()) == Math.abs(move.getNewTile().getY() - move.getOldTile().getY())) {
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
			if(this.tile.getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece() == null) {
				return true;
			} else {
				if(this.tile.getBoard().getTiles().get(new Tuple<Character, Integer>(move.getNewTile().getX(), move.getNewTile().getY())).getPiece().isColor() == !this.isColor()) {
					return true;
				}
			}
		}
		return false;
	}
}
