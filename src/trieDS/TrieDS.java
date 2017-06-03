package trieDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TrieDS {

	public int size;
	private int numWord;
	private Node root;

	private class Node {

		Character data;
		HashMap<Character, Node> table;
		// end of word - eow
		Boolean eow;

		public Node(Character data) {

			this.data = data;
			this.table = new HashMap<>();
			this.eow = false;

		}

	}

	public TrieDS() {

		this.root = new Node('*');
		this.size = 1;
		this.numWord = 0;

	}

	// add
	public void addWord(String str) {

		this.addWord(str, this.root);

	}

	private void addWord(String str, Node node) {

		// base case
		if (str.length() == 0) {

			// indicate that this word is the ending of a word
			// ?-----------------
			//if (node.eow == false) {
				node.eow = true;
				this.numWord++;
			//}
			return;

		}

		Character ch = str.charAt(0);
		String ros = str.substring(1, str.length());

		if (!node.table.containsKey(ch)) {

			Node newNode = new Node(ch);
			this.size++;
			node.table.put(ch, newNode);

		}

		this.addWord(ros, node.table.get(ch));

	}

	// search
	public boolean searchWord(String word) {

		return this.searchWord(word, this.root);

	}

	private boolean searchWord(String word, Node node) {

		if (word.length() == 0) {

			return (node.eow == true);

		}

		boolean rv = false;

		Character ch = word.charAt(0);
		String ros = word.substring(1);

		if (node.table.get(ch) != null) {
			// do something
			rv = this.searchWord(ros, node.table.get(ch));

		} else {

			return false;
		}

		return rv;

	}

	// ? ------------------------------------------problem here
	// remove word --> remove unused nodes
	public boolean removeWord(String word) {

		// true means that the word has been removed
		// false means that the word has not been found
		return this.removeWord(word, this.root);

	}

	private boolean removeWord(String word, Node node) {

		if (word.length() == 0) {

			if (node.eow == true) {

				this.numWord--;
				node.eow = false;
				return (node.eow == true);

			}

			return false;

		}

		boolean rv = false;

		Character ch = word.charAt(0);
		String ros = word.substring(1);

		if (node.table.get(ch) != null) {

			rv = this.removeWord(ros, node.table.get(ch));

		} else {

			return false;
		}

		// do something after finding the word
		if (rv) {
			// not the ending of any word and not a part of any word, so remove
			// the word

			// ?-----------------
			if (node.table.get(ch).eow == false && node.table.get(ch).table.size() == 0) {

				node.table.remove(ch);
				this.size--;

			} else {

			}

		} else

		{
			// word not found, so do nothing
		}

		return rv;

	}

	// display words 1
	public void displayWord() {

		this.displayWord(this.root, "");

	}

	private void displayWord(Node node, String osf) {

		if (node.eow) {
			System.out.println(osf + ",");
		}

		// ?-----------------set parsing other method
		Set<Character> set = node.table.keySet();

		// ArrayList<Character> lset = new ArrayList<>(set);
		for (Character var : set) {

			this.displayWord(node.table.get(var), osf + var);

		}

	}

	// display 2 as display as graph
	public void displayAsGraph() {

		this.displayAsGraph(this.root);

	}

	// ?------------------------------------------------------------------

	private void displayAsGraph(Node node) {

		String str = "(" + node.data + ", " + node.eow + " ) =>";
		System.out.print(str);

		// no duplicate elements
		Set<Character> keys = node.table.keySet();

		// System.out.print(keys+"keys");
		// String child = "("+node.data + ", "+node.eow+" ) =>" ;

		// parsing set keys and set is interface ----------------------------

		for (Character key : keys) {

			String child = "(" + node.table.get(key).data + ", " + node.table.get(key).eow + " ) ,";
			System.out.print(child);

		}

		System.out.println(" END");

		// calling other nodes
		for (Character key : keys) {

			this.displayAsGraph(node.table.get(key));

		}

	}

	// size
	public int size() {
		return this.size;
	}

	// numWords
	public int numWords() {
		return this.numWord;
	}

	// isEmpty
	public boolean isEmpty() {

		return (this.numWord == 0);

	}

}
