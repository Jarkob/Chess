package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Move;
import models.Tuple;
import pieces.King;

/**
 * ActionListener for a Tile represented by a JButton
 * @author jakobbussas
 *
 */
public class UIButtonHandler implements ActionListener
{
	/**
	 * creates new UIButtonHandler instance
	 * @param ui reference to the ui it belongs to
	 * @param x the x coordinate of the button
	 * @param y the y coordinate of the button
	 */
	public UIButtonHandler(UI ui, char x, int y) {
		this.ui = ui;
		this.x = x;
		this.y = y;
	}
	
	private UI ui;
	
	// coordinates are only needed for actionPerformed method
	private char x;
	private int y;

	/**
	 * get the x coordinate of the button
	 * @return the x coordinate
	 */
    public char getX()
	{
		return x;
	}

    /**
     * set the x coordinate of the button
     * @param x the x coordinate
     */
	public void setX(char x)
	{
		this.x = x;
	}

	/**
	 * get the y coordinate of the button
	 * @return the y coordinate
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * set the y coordinate of the button
	 * @param y the y coordinate
	 */
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	 * handle the action
	 * saves two clicked tiles, stores them and tries to perform a move
	 */
	public void actionPerformed(ActionEvent e) {
		if(UI.from != null) {
			UI.to = this.ui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y));
			// check if move is valid
			Move move = Move.create(UI.from, UI.to);
			
			if(move != null) {
				if(move.getOldTile().getPiece().isColor() != this.ui.game.getPlayer()) {
					System.out.println("It is the turn of player " + (this.ui.game.getPlayer() ? "White" : "Black"));
				} else {
					if(move.getOldTile().getPiece().isMoveLegal(move)) {
						// check if game is over
						if(move.getNewTile().getPiece() != null && move.getNewTile().getPiece() instanceof King) {
							System.out.println("Player " + (this.ui.game.getPlayer() ? "White" : "Black") + " won!");
							System.out.println("(Press enter to continue.)");
						}
						move.execute();
						this.ui.game.setPlayer(!this.ui.game.getPlayer());
					} else {
						UI.to = null;
						System.out.println("Invalid move: " + move);
					}
				}
			} else {
				System.out.println("Move = null");
			}
			UI.from = null;
			UI.to = null;
		} else {
			if(this.ui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)).getPiece() != null) {
				UI.from = this.ui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y));
			} else {
				System.out.println("Please select a piece to move");
			}
		}
    }
}
