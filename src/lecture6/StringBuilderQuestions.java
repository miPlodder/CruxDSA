package lecture6;

import java.util.Scanner;

//import java.util.*;

public class StringBuilderQuestions {

	public static String toggleCase(String str) {

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			// character convert themselves
			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - 'a' + 'A');

			}

			else {
				ch = (char) (ch - 'A' + 'a');
			}
			sb.append(ch);

		}

		return sb.toString();
	}

	public static String oddEven(String str){
		
		StringBuilder sb = new StringBuilder();
		
		char ch ;
		for(int i = 0 ; i < str.length() ; i ++){
			
			if(i%2 == 0)
			{
				ch = (char)(str.charAt(i) - 1) ;
				
			}
			else
			{
				ch = (char)(str.charAt(i)+1 );
				
			}
			
			sb.append(ch);
			
		}
		
		
		
		return sb.toString();
	}
	
	public static String diffInside(String str){
		
		//no args means that StringBuilder is of length 0
		StringBuilder sb = new StringBuilder();
		
		sb.append(str.charAt(0));
		
		for(int i = 0 ; i < str.length() - 1 ; i++ )
		{
			int diff = str.charAt(i+1) - str.charAt(i);
			
			sb.append(diff);
			
			sb.append(str.charAt(i+1));
			
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {

		//StringBuilder are like arrays list but for characters
	}

}
