package game;

/**
 * main class from which the program launches
 * @author jakobbussas
 *
 */
public class App
{
	/**
	 * launches the program
	 * by default launches with a graphical user interface
	 * @param args first argument is the type of the interface (optional)
	 */
	public static void main(String[] args) {
		Game game = new Game(1);
		if(args.length == 0) {
			game.run(new String[] {"gui"});
		} else if(args.length == 1) {
			game.run(args);
		} else {
			System.out.println("Invalid number of command line arguments, only <= 1 arguments accepted");
			return;
		}
	}
}
