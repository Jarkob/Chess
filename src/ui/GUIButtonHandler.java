package ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import models.Move;
import models.Tuple;
import pieces.King;

/**
 * ActionListener for a Tile represented by a JButton
 * @author jakobbussas
 *
 */
public class GUIButtonHandler implements ActionListener
{
	/**
	 * creates new UIButtonHandler instance
	 * @param ui reference to the ui it belongs to
	 * @param x the x coordinate of the button
	 * @param y the y coordinate of the button
	 */
	public GUIButtonHandler(GUI ui, char x, int y) {
		this.ui = ui;
		this.x = x;
		this.y = y;
		
		this.icon = new ImageIcon(GUIButtonHandler.class.getResource("/chess-board.png"));
		Image image = this.icon.getImage();
		image = image.getScaledInstance(40,  40, Image.SCALE_SMOOTH);
		this.icon = new ImageIcon(image);
	}
	
	private GUI ui;
	private ImageIcon icon;
	
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
		if(!this.ui.isFrozen()) {
			if(this.ui.getFrom() != null) {
				this.ui.setTo(this.ui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)));
				// check if move is valid
				Move move = Move.create(this.ui.getFrom(), this.ui.getTo());
				
				if(move != null) {
					if(move.getOldTile().getPiece().isColor() != this.ui.isPlayer()) {
						// show error in gui
						JOptionPane.showOptionDialog(
								this.ui.getFrame(),
								"It is the turn of player " + (this.ui.isPlayer() ? "White" : "Black"), "Wrong player",
								JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
								new Object[] {"OK"}, "OK");
					} else {
						if(move.getOldTile().getPiece().isMoveLegal(move)) {
							// check if game is over
							if(move.getNewTile().getPiece() != null && move.getNewTile().getPiece() instanceof King) {
								this.ui.freeze();
								// show win message in gui
								JOptionPane.showOptionDialog(
										this.ui.getFrame(),
						                "Player " + (this.ui.isPlayer() ? "White" : "Black") + " won!", "Game over",
						                JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
						                new Object[] {"OK"}, "OK");
							}
							move.execute();
							this.ui.setPlayer(!this.ui.isPlayer());
						} else {
							this.ui.setTo(null);
							// show error in gui
							JOptionPane.showOptionDialog(
									this.ui.getFrame(),
									move, "Invalid move",
									JOptionPane.ERROR_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
									new Object[] {"OK"}, "OK");
						}
					}
				} else {
					JOptionPane.showOptionDialog(
							this.ui.getFrame(),
							"Move = null", "Error",
							JOptionPane.ERROR_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
							new Object[] {"OK"}, "OK");
				}
				this.ui.setFrom(null);
				this.ui.setTo(null);
			} else {
				if(this.ui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)).getPiece() != null) {
					this.ui.setFrom(this.ui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)));
				} else {
					
					JOptionPane.showOptionDialog(
							this.ui.getFrame(),
							"Please select a piece to move", "Error",
							JOptionPane.ERROR_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
							new Object[] {"OK"}, "OK");
				}
			}
		}
    }
}
