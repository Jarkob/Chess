package game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Board;
import models.Game;
import models.Tile;
import models.Tuple;

/**
 * class for user interface
 * @author jakobbussas
 * Icons made by Freepik[www.freepik.com] from www.flaticon.com 
 */
public class UI
{
	/**
	 * creates a new UI instance
	 * @param game the game
	 * @param board the board of the game
	 */
	public UI(Game game, Board board) {
		this.game = game;
		this.board = board;
		this.frame = new JFrame();
		JLabel label;
		boolean color = false;
		
		// add buttons and labels to ui
		for(int y = 8; y > 0; y--) {
			label = new JLabel("" + y);
			this.frame.add(label);
			for(int x = 97; x < 105; x++) {
				JButton button = new JButton();
				button.setBackground(color ? Color.BLACK : Color.WHITE);
				button.setOpaque(true);
				
				// add button logic
				board.getTiles().get(new Tuple<Character, Integer>((char) x, y)).setButton(button);
				
				board.getTiles().get(new Tuple<Character, Integer>((char) x, y)).updateButton();
//				button.setText(board.getTiles().get(new Tuple<Character, Integer>((char) x, y)).getPiece() != null
//						? board.getTiles().get(new Tuple<Character, Integer>((char) x, y)).getPiece().toString() : "");
				
				button.addActionListener(new UIButtonHandler(this, (char) x, y));
				
				frame.add(button);
				color ^= true;
			}
			color ^= true;
		}
		
		label = new JLabel();
		frame.add(label);
		
		for(int x = 97; x < 105; x++) {
			label = new JLabel("" + (char) x);
			frame.add(label);
		}
		
		// configurate frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(9, 9));
		frame.setVisible(true);
	}
	
	Game game;
	private Board board;
	private JFrame frame;
	public static Tile from;
	public static Tile to;
	public static boolean player;
	
	public Board getBoard()
	{
		return board;
	}
	public void setBoard(Board board)
	{
		this.board = board;
	}
	public JFrame getFrame()
	{
		return frame;
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
}
