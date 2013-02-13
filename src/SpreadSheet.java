import java.io.IOException;

/**
 * The Main class
 * @author Pooya
 */
public class SpreadSheet {

	/**
	 * The main method. It gets the filename argument from the user.
	 * @param args input filename
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		if (args.length == 1) {

			CSVFileManager fileManager = new CSVFileManager(args[0]);
			fileManager.tokenizeTheFile();

			try {
				Evaluator eval = new Evaluator(fileManager);
				eval.evaluate();
			} catch (IOException e) {
				System.out.println("Error!");
			}
		} else {
			System.out.print("too many arguments!");
		}
	}
}
