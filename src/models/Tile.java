package models;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import game.IconMapper;
import pieces.Piece;

/**
 * represents a single tile on a board
 * @author jakobbussas
 *
 */
public class Tile
{
	/**
	 * creates new tile
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param color the color
	 */
	public Tile(char x, int y, boolean color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	private char x;
	private int y;
	private boolean color;
	private Board board;
	private Piece piece;
	private JButton button;
	
	/**
	 * get x coordinate
	 * @return the x coordinate
	 */
	public char getX()
	{
		return x;
	}
	
	/**
	 * set x coordinate
	 * @param x the x coordinate
	 */
	public void setX(char x)
	{
		this.x = x;
	}
	
	/**
	 * get y coordinate
	 * @return the y coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * set y coordinate
	 * @param y the y coordinate
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * check the color of the tile
	 * @return true for white, false for black
	 */
	public boolean isColor()
	{
		return color;
	}
	
	/**
	 * set color
	 * @param color true for white, false for black
	 */
	public void setColor(boolean color)
	{
		this.color = color;
	}
	
	/**
	 * get the board
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * set the board
	 * @param board the board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * get the occupying piece if exists
	 * @return the occupying piece
	 */
	public Piece getPiece()
	{
		return piece;
	}
	
	/**
	 * set the occupying piece
	 * @param piece the occupying piece
	 */
	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}
	
	/**
	 * get the button
	 * @return the button
	 */
	public JButton getButton()
	{
		return this.button;
	}
	
	/**
	 * set the button
	 * @param button the button
	 */
	public void setButton(JButton button)
	{
		this.button = button;
	}
	
	/**
	 * updates the button after moves
	 */
	public void updateButton() {
		if(this.piece != null) {
			// TODO: resizing shouldn't be necessary
			ImageIcon icon = new ImageIcon(
					Tile.class.getResource("/" + IconMapper.pieceToIcon(this.piece)));
			Image image = icon.getImage();
			Image newImage = image.getScaledInstance(40,  40, Image.SCALE_SMOOTH);
			icon = new ImageIcon(newImage);
			button.setIcon(icon);
		} else {
			this.button.setIcon(null);
		}
		this.button.repaint();
	}
	
	/**
	 * check if tile is equal to
	 * @param other tile
	 * @return if tiles are equal
	 */
	@Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tile)){
            return false;
        }

        Tile other_ = (Tile) other;

        return other_.getX() == this.getX() && other_.getY() == this.getY();
    }
	
	/**
	 * format as string
	 * @return formatted string
	 */
	@Override
	public String toString()
	{
		return this.getPiece() == null ? "  " : this.getPiece().toString();
	}
}
