package models;

import java.util.Hashtable;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

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
	
	/**
	 * fills board with pieces
	 */
	public void fill() {
		// deploy pawns
		for(int i = 97; i < 105; i++) {
			this.tiles.get(new Tuple<Character, Integer>((char) i, 2)).setPiece(
					new Pawn(this.tiles.get(new Tuple<Character, Integer>((char) i, 2)), true));
			this.tiles.get(new Tuple<Character, Integer>((char) i, 7)).setPiece(
					new Pawn(this.tiles.get(new Tuple<Character, Integer>((char) i, 7)), false));
		}
		// deploy rooks
		this.tiles.get(new Tuple<Character, Integer>((char) 97, 1)).setPiece(
				new Rook(this.tiles.get(new Tuple<Character, Integer>((char) 97, 1)), true));
		this.tiles.get(new Tuple<Character, Integer>((char) 104, 1)).setPiece(
				new Rook(this.tiles.get(new Tuple<Character, Integer>((char) 104, 1)), true));
		this.tiles.get(new Tuple<Character, Integer>((char) 97, 8)).setPiece(
				new Rook(this.tiles.get(new Tuple<Character, Integer>((char) 97, 8)), false));
		this.tiles.get(new Tuple<Character, Integer>((char) 104, 8)).setPiece(
				new Rook(this.tiles.get(new Tuple<Character, Integer>((char) 104, 8)), false));
		// deploy knights
		this.tiles.get(new Tuple<Character, Integer>((char) 98, 1)).setPiece(
				new Knight(this.tiles.get(new Tuple<Character, Integer>((char) 98, 1)), true));
		this.tiles.get(new Tuple<Character, Integer>((char) 103, 1)).setPiece(
				new Knight(this.tiles.get(new Tuple<Character, Integer>((char) 103, 1)), true));
		this.tiles.get(new Tuple<Character, Integer>((char) 98, 8)).setPiece(
				new Knight(this.tiles.get(new Tuple<Character, Integer>((char) 98, 8)), false));
		this.tiles.get(new Tuple<Character, Integer>((char) 103, 8)).setPiece(
				new Knight(this.tiles.get(new Tuple<Character, Integer>((char) 103, 8)), false));
		// deploy bishops
		this.tiles.get(new Tuple<Character, Integer>((char) 99, 1)).setPiece(
				new Bishop(this.tiles.get(new Tuple<Character, Integer>((char) 99, 1)), true));
		this.tiles.get(new Tuple<Character, Integer>((char) 102, 1)).setPiece(
				new Bishop(this.tiles.get(new Tuple<Character, Integer>((char) 102, 1)), true));
		this.tiles.get(new Tuple<Character, Integer>((char) 99, 8)).setPiece(
				new Bishop(this.tiles.get(new Tuple<Character, Integer>((char) 99, 8)), false));
		this.tiles.get(new Tuple<Character, Integer>((char) 102, 8)).setPiece(
				new Bishop(this.tiles.get(new Tuple<Character, Integer>((char) 102, 8)), false));
		// deploy queens
		this.tiles.get(new Tuple<Character, Integer>((char) 100, 1)).setPiece(
				new Queen(this.tiles.get(new Tuple<Character, Integer>((char) 100, 1)), true));
		this.tiles.get(new Tuple<Character, Integer>((char) 100, 8)).setPiece(
				new Queen(this.tiles.get(new Tuple<Character, Integer>((char) 100, 8)), false));
		// deploy kings
		this.tiles.get(new Tuple<Character, Integer>((char) 101, 1)).setPiece(
				new King(this.tiles.get(new Tuple<Character, Integer>((char) 101, 1)), true));
		this.tiles.get(new Tuple<Character, Integer>((char) 101, 8)).setPiece(
				new King(this.tiles.get(new Tuple<Character, Integer>((char) 101, 8)), false));
	}
	
	/**
	 * empties board
	 */
	public void empty() {
		for(int y = 1; y < 9; y++) {
			for(int x = 97; x < 105; x++) {
				this.tiles.get(new Tuple<Character, Integer>((char) x, y)).setPiece(null);
			}
		}
	}
	
	private int id;
	private Hashtable<Tuple<Character, Integer>, Tile> tiles;
	private Move lastMove;
	
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
	 * get the last move
	 * @return the last move
	 */
	public Move getLastMove()
	{
		return this.lastMove;
	}
	
	/**
	 * set the last move
	 * @param lastMove the last move
	 */
	public void setLastMove(Move lastMove)
	{
		this.lastMove = lastMove;
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
