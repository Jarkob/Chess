package models;

import java.util.Hashtable;

public class Board
{
	public Board(int id) {
		this.id = id;
		this.tiles = new Hashtable<Tuple<Character, Integer>, Tile>();
		boolean colorIndex = false;
		for(int y = 1; y < 9; y++) {
			for(int x = 97; x < 105; x++) {
				this.tiles.put(new Tuple<Character, Integer>((char) x, y), new Tile((char) x, y, colorIndex)).setBoard(this);
				colorIndex ^= true;
			}
			colorIndex ^= true;
		}
	}
	
	private int id;
	private Hashtable<Tuple<Character, Integer>, Tile> tiles;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Hashtable<Tuple<Character, Integer>, Tile> getTiles()
	{
		return tiles;
	}
	public void setTiles(Hashtable<Tuple<Character, Integer>, Tile> tiles)
	{
		this.tiles = tiles;
	}
	
	@Override
	public String toString()
	{
		String stringValue = "";
		for(int y = 8; y > 0; y--) {
			for(int x = 97; x < 105; x++) {
				stringValue += this.getTiles().get(new Tuple<Character, Integer>((char) x, y));
			}
			stringValue += "%n";
		}
		return stringValue;
	}
}
