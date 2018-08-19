package ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import models.Move;
import models.Tuple;
import pieces.King;
import pieces.Pawn;

/**
 * ActionListener for a Tile represented by a JButton
 * @author jakobbussas
 *
 */
public class GUIButtonHandler implements ActionListener
{
	/**
	 * creates new GUIButtonHandler instance
	 * @param gui reference to the gui it belongs to
	 * @param x the x coordinate of the button
	 * @param y the y coordinate of the button
	 */
	public GUIButtonHandler(GUI gui, char x, int y) {
		this.gui = gui;
		this.x = x;
		this.y = y;
		
		this.icon = new ImageIcon(GUIButtonHandler.class.getResource("/chess-board.png"));
		Image image = this.icon.getImage();
		image = image.getScaledInstance(40,  40, Image.SCALE_SMOOTH);
		this.icon = new ImageIcon(image);
	}
	
	private GUI gui;
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
		if(!this.gui.isFrozen()) {
			if(this.gui.getFrom() != null) {
				this.gui.setTo(this.gui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)));
				// check if move is valid
				Move move = Move.create(this.gui.getFrom(), this.gui.getTo());
				
				if(move != null) {
					if(move.getOldTile().getPiece().isColor() != this.gui.isPlayer()) {
						// show error in gui
						JOptionPane.showOptionDialog(
								this.gui.getFrame(),
								"It is the turn of player " + (this.gui.isPlayer() ? "White" : "Black"), "Wrong player",
								JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
								new Object[] {"OK"}, "OK");
					} else {
						if(move.getOldTile().getPiece().isMoveLegal(move)) {
							// check if game is over
							if(move.getNewTile().getPiece() != null && move.getNewTile().getPiece() instanceof King) {
								this.gui.freeze();
								// show win message in gui
								JOptionPane.showOptionDialog(
										this.gui.getFrame(),
						                "Player " + (this.gui.isPlayer() ? "White" : "Black") + " won!", "Game over",
						                JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
						                new Object[] {"OK"}, "OK");
							}
							move.execute();
							// check if promotion
							// TODO
							if(move.getNewTile().getPiece().getClass().getName().contains("Pawn")) {
								Pawn pawn = (Pawn) move.getNewTile().getPiece();
								if(pawn.promotion(move)) {
									// show promotion dialog
									String[] promotions = {"Queen", "Bishop", "Knight", "Rook"};
									JComboBox comboBox = new JComboBox(promotions);
									JOptionPane optionPane = new JOptionPane(
											"Select the piece you wish your pawn to be promoted to:",
											JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION,
											null, new Object[] {}, null);
									optionPane.add(comboBox);
									JDialog dialog = new JDialog();
							        dialog.getContentPane().add(optionPane);
							        dialog.pack();
							        dialog.setVisible(true);
								}
							}
							this.gui.setPlayer(!this.gui.isPlayer());
						} else {
							this.gui.setTo(null);
							// show error in gui
							JOptionPane.showOptionDialog(
									this.gui.getFrame(),
									move, "Invalid move",
									JOptionPane.ERROR_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
									new Object[] {"OK"}, "OK");
						}
					}
				} else {
					JOptionPane.showOptionDialog(
							this.gui.getFrame(),
							"Move = null", "Error",
							JOptionPane.ERROR_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
							new Object[] {"OK"}, "OK");
				}
				// reset from and to
				this.gui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.gui.getFrom().getX(), this.gui.getFrom().getY())).updateButton();
				this.gui.setFrom(null);
				this.gui.setTo(null);
			} else {
				if(this.gui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)).getPiece() != null) {
					this.gui.setFrom(this.gui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)));
					// highlight tile
					if(this.gui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)).isColor()) {
						this.gui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)).getButton().setBackground(new Color(145, 145, 255));
					} else {
						this.gui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)).getButton().setBackground(new Color(55, 55, 145));
					}
					this.gui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y)).getButton().repaint();
				} else {
					JOptionPane.showOptionDialog(
							this.gui.getFrame(),
							"Please select a piece to move", "Error",
							JOptionPane.ERROR_MESSAGE, JOptionPane.QUESTION_MESSAGE, this.icon,
							new Object[] {"OK"}, "OK");
				}
			}
		}
    }
}
