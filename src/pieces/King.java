package pieces;

import models.Move;
import models.Rochade;
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
		this.wasMoved = false;
	}
	
	private boolean wasMoved;
	
	/**
	 * get if king was moved
	 * @return if king was moved
	 */
	public boolean wasMoved()
	{
		return this.wasMoved;
	}
	
	/**
	 * set if king was moved
	 * @param wasMoved if king was moved
	 */
	public void setWasMoved(boolean wasMoved)
	{
		this.wasMoved = wasMoved;
	}

	@Override
	public boolean isMoveLegal(Move move)
	{
		if((Math.abs((int) move.getOldTile().getX() - (int) move.getNewTile().getX()) == 1) || (Math.abs(move.getOldTile().getY() - move.getNewTile().getY()) == 1)) {
			// TODO: is tile threatened
			return move.isLegal();
		} else if(move instanceof Rochade) {
			// check if rook was not moved before
			if(this.color) {
				if(((Rochade) move).isLeftSide()) {
					// get board TODO
				} else {
					
				}
			} else {
				if(((Rochade) move).isLeftSide()) {
					
				} else {
					
				}
			}
			// check if king was not moved before
			// check if tiles are free
		}
		return false;
	}
}
