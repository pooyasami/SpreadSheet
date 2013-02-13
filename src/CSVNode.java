import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class holds the information for each Node
 * @author Pooya Samizadeh-Yazd
 *
 */
public class CSVNode {
	
	String originalToken;
	ArrayList<String> tokenized = new ArrayList<String>();
	
	/**
	 * returns the tokenized arraylist of the expression
	 * @return
	 */
	public ArrayList<String> getTokenized() {
		return tokenized;
	}

	/**
	 * Constructor, it takes the token between the commas and tokenizes it
	 * @param token
	 */
	public CSVNode(String token) {
		super();
		this.originalToken = token;
		
		StringTokenizer tokenizer = new StringTokenizer(originalToken);
		while (tokenizer.hasMoreTokens()) {
			String parsedToken = tokenizer.nextToken();
			if (parsedToken.startsWith("=")) {
				parsedToken = parsedToken.substring(1);
			}
			
			tokenized.add(parsedToken);
		}
	}
}
