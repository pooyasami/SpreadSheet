import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class is for opening and parsing the input file
 * @author Pooya
 *
 */
public class CSVFileManager {
	String fileName;
	ArrayList<TreeMap<Character, CSVNode>> parsedFile = new ArrayList<TreeMap<Character,CSVNode>>();

	/**
	 * Constructor that gets the filename.
	 * @param fileName
	 */
	public CSVFileManager(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	/**
	 * Returns the filename
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * returns the result of parsing which is an ArrayList of TreeMaps
	 * @return
	 */
	public ArrayList<TreeMap<Character, CSVNode>> getParsedFile() {
		return parsedFile;
	}
	
	/**
	 * This function first tokenizes the each line and calls the tokenizeLine function on each of them
	 */
	public void tokenizeTheFile () {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				String lineToken = scanner.nextLine();
				parsedFile.add(tokenizeLine(lineToken));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found!");
		}
	}
	
	/**
	 * It's a helper function for tokenizeTheFile function. It gets CSV line and tokenizes it and creates a
	 * TreeMap to be inserted into the ArrayList
	 * @param line CSV Line
	 * @return
	 */
	public TreeMap<Character, CSVNode> tokenizeLine (String line) {
		TreeMap<Character, CSVNode> lineTreeMap = new TreeMap<Character, CSVNode>();
		
		StringTokenizer st = new StringTokenizer(line, ",");
		int count = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			lineTreeMap.put(intToChar(count), new CSVNode(token));
			++count;
		}
		
		return lineTreeMap;
	}
	
	/**
	 * It converts the decimal character to the character itself. This is necessary for
	 * handling the columns of the spreadsheet. (e.g. 0 is A and 25 is Z)
	 * @param number character decimal value
	 * @return the actual charachter
	 */
	public Character intToChar (int number) {
		return new Character((char)(number + 65));
	}
}
