/*char[] chars = str.toCharArray();
Arrays.sort();

*/
package lecture6;

public class StringOperations {

	public static void printAllSubString(String str) {

		String temp;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				temp = str.substring(i, j);
				if (checkPalindrome(temp))
					System.out.println(temp);

			}
		}

	}

	public static boolean checkPalindrome(String str) {

		boolean rv = true;

		int mid = (str.length() - 1) / 2;
		int endIndex = str.length() - 1;

		for (int i = 0; i <= mid; i++) {
			if (str.charAt(i) != str.charAt(endIndex)) {

				rv = false;
				//System.out.print("end");
				break;
			}
			endIndex--;
		}
		return rv;
	}

	public static String removeDuplicate(String str){
		
		String rv = "";
		
		for(int i = 0 ; i < str.length() - 1 ; i ++ )
		{
			
			if(str.charAt(i) != str.charAt(i+1))	
				rv = rv + str.charAt(i) + str.charAt(i+1);
		}
				
		return rv;
	}
	
	public static void main(String[] args) {

		//printAllSubString("aba");
		// System.out.println(checkPalindrome("aba"));
	
/*//		String str = "hello";
//		Character ch = str.charAt(4);
//		System.out.print(ch);
*/	
		//String str = removeDuplicate("aabca");
		//System.out.println(str);
		
		
	}

}
