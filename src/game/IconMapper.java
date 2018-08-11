package game;

import pieces.Piece;

/**
 * maps a piece to the path of its icon
 * @author jakobbussas
 *
 */
public class IconMapper
{
	public static String pieceToIcon(Piece piece) {
		String path = piece.isColor() ? "white" : "black";
		path += "_";
		path += piece.getClass().getName().split("\\.")[1];
		path += ".png";
		path = path.toLowerCase();
		return path;
	}
}
