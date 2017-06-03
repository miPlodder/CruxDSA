package lecture7_Recursion;

import java.io.*;
import java.util.*;

public class hckerank {

	public static String duplicateFormatting(String str) {

		String rv;
		if (str.length() == 0) {

			return " ";

		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		String resm1 = duplicateFormatting(ros); // result minus 1
		char temp = resm1.charAt(0);
		if (ch == temp) {
			rv = ch + "*" + resm1;
		} else {
			rv = ch + resm1;
		}

		return rv;
	}

	public static String moveXToEnd(String str) {

		// STARTING INDEX
		/* Enter the code here and do not forget the base case */

		String rv;

		if (str.length() == 0)
			return "";

		char ch = str.charAt(0);
		String ros = str.substring(1);

		String resm1 = moveXToEnd(ros);

		if (ch == 'x') {

			rv = resm1 + ch;

		} else {

			rv = ch + resm1;

		}

		return rv;
	}

	public static String replaceHiWBye (String str){

        /* Enter the code here and do not forget the base case*/
        if(str.length() == 1){
            
           return str;

       }
       
       
       
       String rv;
       
       String ch = str.substring(0,2);
       String ros = str.substring(1);
       
       String prev = replaceHiWBye(ros);
       
       if(ch.equals("hi")){
           
           rv = "bye"+prev.substring(1);
       }
       else{
           rv = ch.charAt(0) + prev ;
       }
       
       return rv ;
   
   
   
   }
	
	
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from Scanner.Call the recursive
		 * function here Your class should be named Solution.
		 */
		Scanner scn = new Scanner(System.in);
		System.out.println(replaceHiWBye(scn.next()));

	}

	public static int countHi(String str) {

		if (str.length() == 1)
			return 0;

		String hi = str.substring(0, 2);
		String ros = str.substring(1);

		int rv = countHi(ros);

		if (hi.equals("hi")) {
			rv++;
		} 
		return rv;
	}
}