package trieDS;

public class TriesClient {

	public static void main(String[] args) {

		// System.out.println('\0'); // what is this \0

		// System.out.println("before\0"+'\0'+"saksham");

		TrieDS obj = new TrieDS();
				
		obj.addWord("sea");
		obj.addWord("see");
		obj.addWord("and");
		obj.addWord("seen");
		obj.addWord("as");
		obj.addWord("art");
		obj.addWord("arc");
		obj.addWord("be");
		obj.addWord("bet");
		obj.addWord("been");

		obj.displayWord();
		obj.removeWord("see");
		obj.removeWord("seen");

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		obj.displayWord();

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		obj.displayAsGraph();
		/*
		 * System.out.println(obj.isEmpty());
		 * 
		 * System.out.println(obj.size()); System.out.println(obj.numWords());
		 * System.out.println(obj.searchWord("saksham")+ " searching saksham");
		 * 
		 * System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
		 * );
		 * 
		 * // problem here System.out.println(obj.removeWord("saksham"));
		 * obj.displayWord(); //System.out.println(obj.numWords());
		 * //System.out.println(obj.removeWord("sea"));
		 * //System.out.println(obj.removeWord("see"));
		 * System.out.println(obj.removeWord("saksha")); obj.displayWord();
		 * //System.out.println(obj.removeWord("saw"));
		 * 
		 * //System.out.println(obj.removeWord("saksham")+ " searching saksham"
		 * );
		 * 
		 * //size is number of nodes System.out.println(obj.size);
		 * obj.displayWord();
		 * 
		 * //numWords is number of words System.out.println(obj.numWords());
		 * 
		 * System.out.println(obj.isEmpty()); obj.addWord("saksham");
		 * System.out.println(obj.isEmpty());
		 * 
		 * 
		 * System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
		 * ); obj.displayWord();
		 * 
		 * System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
		 * ); obj.displayAsGraph();
		 */

	}

}
