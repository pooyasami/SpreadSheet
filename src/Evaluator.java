import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;


public class Evaluator {
	CSVFileManager fileManager;
	Pattern pattern = Pattern.compile("[A-Z]\\d*");
	
	/**
	 * Constructor
	 * @param fileManager CSVFileManager object that has been tokenized properly
	 * @throws IOException
	 */
	public Evaluator(CSVFileManager fileManager) throws IOException {
		super();
		this.fileManager = fileManager;
	}
	
	/**
	 * This function evaluates the references and also makes the output
	 * @throws IOException
	 */
	public void evaluate() throws IOException {
		int count = 0;
		Iterator<TreeMap<Character, CSVNode>> rowIterator = fileManager.getParsedFile().iterator();
		
		while (rowIterator.hasNext()) {
			TreeMap<Character, CSVNode> row = rowIterator.next();
			Set<Character> rowKeySet = row.keySet();
			
			Iterator<Character> keySetIterator = rowKeySet.iterator();
			while (keySetIterator.hasNext()) {
				// call to node evaluator
				Character key = keySetIterator.next();
				ArrayList<String> tokenized = fileManager.getParsedFile().get(count).get(key).getTokenized();
				
				NumberFormat nf = new DecimalFormat("##.###");
				
				System.out.print(nf.format(evaluateNode(tokenized)));
				
				if (keySetIterator.hasNext()) {
					System.out.print(",");
				} else {
					if (rowIterator.hasNext())
						System.out.print("\n");
				}
			}
			++count;
		}
	}
	
	/**
	 * Evaluates each node. If there is a reference, it evaluates that node as well.
	 * It also evaluates the expressions in postfix notation.
	 * @param postfix
	 * @return
	 */
	public Double evaluateNode (ArrayList<String> postfix) {
		
		Iterator<String> iterator = postfix.iterator();
		Stack<Double> stack = new Stack<Double>();
		while (iterator.hasNext()) {
			String token = iterator.next();
			
			// pattern matching happening here!
			if (pattern.matcher(token).matches()) {
				Character column = token.substring(0, 1).toCharArray()[0];
				int row = Integer.parseInt(token.substring(1));
				ArrayList<String> tokenized = fileManager.getParsedFile().get(row - 1).get(column).getTokenized();
				token = evaluateNode(tokenized).toString();
			}
			
			double temp = 0;
			if (tokenIsOp(token)) {
				double lit2 = stack.pop();
				double lit1 = stack.pop();
				
				if (token.equals("+")) {
					temp = lit1 + lit2;
				} else if (token.equals("-")) {
					temp = lit1 - lit2;
				} else if (token.equals("*")) {
					temp = lit1 * lit2;
				} else if (token.equals("/")) {
					temp = lit1 / lit2;
				}
				
				stack.push(temp);
			} else {
				Double value = Double.parseDouble(token);
				stack.push(value);
			}
		}
		return stack.pop();
	}
	
	/**
	 * Helper fucntion for evaluateNode to know if a token is an operation token
	 * @param token
	 * @return
	 */
	public boolean tokenIsOp (String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}
}
