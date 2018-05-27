package models;

import java.util.Hashtable;

/**
 * represents a chess board
 * @author jakobbussas
 *
 */
public class Board
{
	/**
	 * creates a new board
	 * @param id the id
	 */
	public Board(int id) {
		this.id = id;
		this.tiles = new Hashtable<Tuple<Character, Integer>, Tile>();
		boolean colorIndex = false;
		for(int y = 1; y < 9; y++) {
			for(int x = 97; x < 105; x++) {
				this.tiles.put(new Tuple<Character, Integer>((char) x, y), new Tile((char) x, y, colorIndex));
				this.tiles.get(new Tuple<Character, Integer>((char) x, y)).setBoard(this);
				colorIndex ^= true;
			}
			colorIndex ^= true;
		}
	}
	
	private int id;
	private Hashtable<Tuple<Character, Integer>, Tile> tiles;
	
	/**
	 * get the id
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * set the id
	 * @param id the id
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * get the tiles
	 * @return the tiles
	 */
	public Hashtable<Tuple<Character, Integer>, Tile> getTiles()
	{
		return tiles;
	}
	
	/**
	 * set the tiles
	 * @param tiles the tiles
	 */
	public void setTiles(Hashtable<Tuple<Character, Integer>, Tile> tiles)
	{
		this.tiles = tiles;
	}
	
	/**
	 * formats the board as a string to print
	 */
	@Override
	public String toString()
	{
		String stringValue = "   -----------------------%n";
		for(int y = 8; y > 0; y--) {
			stringValue += y + " |";
			for(int x = 97; x < 105; x++) {
				stringValue += this.getTiles().get(new Tuple<Character, Integer>((char) x, y)) + "|";
			}
			stringValue += "%n   -----------------------%n";
		}
		return stringValue += "    a  b  c  d  e  f  g  h%n";
	}
}
