package lecture10_Completies;

public class substring_in_n2 {

	public static void subString(String str) {
		
		int res = 0;

		for (int i = 0; i < str.length(); i++) {

			for (int j = i + 1; j < str.length(); j++) {

				String sub = str.substring(i, j);
				int counter = 0;
				
				for (int k = 0; k < (sub.length() / 2); k++) {
					
					
				}

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
