package textProcessing;

public class client {

	// pattern search
	public static int bruteForcePS(String src, String pat) {

		int i = 0;
		while (i <= src.length() - pat.length()) {

			int j = 0;
			while (j < pat.length() && src.charAt(i + j) == pat.charAt(j)) {

				j++;

			}

			if (j == pat.length()) {

				return i;

			}

			i++;

		}

		return -1;

	}

	public static void main(String[] args) {
		
		System.out.println(bruteForcePS("dsakjsdadsa", "da"));

	}

}
// scjp - sun certified java programming 