package game;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import models.Board;
import models.Tile;
import models.Tuple;

/**
 * class for graphical user interface
 * @author jakobbussas
 * 
 */
public class UI
{
	/**
	 * creates a new UI instance
	 * @param board the board of the game
	 */
	public UI(Board board) {
		this.frozen = false;
		this.board = board;
		this.player = true;
		this.frame = new JFrame();
		JLabel label;
		boolean color = false;
		
		// add buttons and labels to ui
		for(int y = 8; y > 0; y--) {
			label = new JLabel("" + y);
			this.frame.add(label);
			for(int x = 97; x < 105; x++) {
				JButton button = new JButton();
				button.setBackground(color ? new Color(64, 64, 64) : new Color(192, 192, 192));
				button.setBorderPainted(false);
				button.setOpaque(true);
				
				// add button logic
				board.getTiles().get(new Tuple<Character, Integer>((char) x, y)).setButton(button);
				board.getTiles().get(new Tuple<Character, Integer>((char) x, y)).updateButton();
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
		
		// configure frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(9, 9));
	}
	
	/**
	 * runs the game
	 * @param args run arguments (currently unused)
	 */
	public void run(String[] args) {
		this.frame.setVisible(true);
	}
	
	private Board board;
	private JFrame frame;
	private boolean frozen;
	private Tile from;
	private Tile to;
	private boolean player;
	
	public Board getBoard()
	{
		return board;
	}
	public void setBoard(Board board)
	{
		this.board = board;
	}
	public Tile getFrom()
	{
		return from;
	}
	public void setFrom(Tile from)
	{
		this.from = from;
	}
	public Tile getTo()
	{
		return to;
	}
	public void setTo(Tile to)
	{
		this.to = to;
	}
	public boolean isPlayer()
	{
		return player;
	}
	public void setPlayer(boolean player)
	{
		this.player = player;
	}
	public JFrame getFrame()
	{
		return frame;
	}
	public void setFrame(JFrame frame)
	{
		this.frame = frame;
	}
	
	public boolean isFrozen() {
		return this.frozen;
	}
	
	/**
	 * freezes the game to avoid interaction between user and board
	 */
	public void freeze() {
		this.frozen = true;
	}
	
	/**
	 * defreezes the game to enable interaction between user and board
	 */
	public void defreeze() {
		this.frozen = false;
	}
}
