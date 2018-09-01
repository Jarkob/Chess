package models;

public class Rochade extends Move
{

	public Rochade(Tile oldTile, Tile newTile, boolean sideLeft)
	{
		super(oldTile, newTile);
		
		
	}
	
	private boolean sideLeft;
	
	public boolean isLeftSide()
	{
		return this.sideLeft;
	}
	
	public void setSideLeft(boolean sideLeft)
	{
		this.sideLeft = sideLeft;
	}
	
	public 

	@Override
	public void execute() {
		// move king
		this.getNewTile().setPiece(this.getOldTile().getPiece());
		this.getOldTile().setPiece(null);
		
		this.getNewTile().updateButton();
		this.getOldTile().updateButton();
		
		// move rook
		Board board = this.getOldTile().getBoard();
		if(this.getOldTile().getPiece().isColor()) { // white
			if(this.sideLeft) { // bottom left
				board.getTiles().get(new Tuple<Character, Integer>('d', 1)).setPiece(
						board.getTiles().get(new Tuple<Character, Integer>('a', 1)).getPiece());
				board.getTiles().get(new Tuple<Character, Integer>('a', 1)).setPiece(null);
			
				board.getTiles().get(new Tuple<Character, Integer>('d', 1)).updateButton();
				board.getTiles().get(new Tuple<Character, Integer>('a', 1)).updateButton();
			} else { // bottom right
				board.getTiles().get(new Tuple<Character, Integer>('f', 1)).setPiece(
						board.getTiles().get(new Tuple<Character, Integer>('h', 1)).getPiece());
				board.getTiles().get(new Tuple<Character, Integer>('h', 1)).setPiece(null);
			
				board.getTiles().get(new Tuple<Character, Integer>('f', 1)).updateButton();
				board.getTiles().get(new Tuple<Character, Integer>('h', 1)).updateButton();
			}
		} else { // black
			if(this.sideLeft) { // top left
				board.getTiles().get(new Tuple<Character, Integer>('d', 8)).setPiece(
						board.getTiles().get(new Tuple<Character, Integer>('a', 8)).getPiece());
				board.getTiles().get(new Tuple<Character, Integer>('a', 8)).setPiece(null);
				
				board.getTiles().get(new Tuple<Character, Integer>('d', 8)).updateButton();
				board.getTiles().get(new Tuple<Character, Integer>('a', 8)).updateButton();
			} else { // top right
				board.getTiles().get(new Tuple<Character, Integer>('f', 8)).setPiece(
						board.getTiles().get(new Tuple<Character, Integer>('h', 8)).getPiece());
				board.getTiles().get(new Tuple<Character, Integer>('h', 8)).setPiece(null);
			
				board.getTiles().get(new Tuple<Character, Integer>('f', 8)).updateButton();
			}
		}
	}
}
