package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Move;
import models.Tuple;
import pieces.King;

public class UIButtonHandler implements ActionListener
{
	public UIButtonHandler(UI ui, char x, int y) {
		this.ui = ui;
		this.x = x;
		this.y = y;
	}
	
	private UI ui;
	private char x;
	private int y;

    public char getX()
	{
		return x;
	}

	public void setX(char x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void actionPerformed(ActionEvent e) {
		if(UI.from != null) {
			UI.to = this.ui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y));
			// check if move is valid
			Move move = Move.create(UI.from, UI.to);
			
			if(move != null) {
				if(move.getOldTile().getPiece().isColor() != this.ui.game.getPlayer()) {// TODO wrong player at beginning
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
			UI.from = this.ui.getBoard().getTiles().get(new Tuple<Character, Integer>(this.x, this.y));
		}
    }
}
