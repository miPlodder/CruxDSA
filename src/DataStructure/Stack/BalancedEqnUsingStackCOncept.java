package DataStructure.Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class BalancedEqnUsingStackCOncept {

	public static ArrayList<String> al = new ArrayList<>();

	public static boolean isBalanced(String str) {


		if (str.length() == 0) {
			return true;
		}

		String ch = str.substring(0, 1);
		String ros = str.substring(1);

		if (ch.equals("(") || ch.equals("{") || ch.equals("]")) {

			al.add(ch);

		}

		if (ch.equals(")") || ch.equals("}") || ch.equals("]")) {

			if (ch.equals(")")){
				if (al.get(al.size() - 1).equals("("))
					{
					al.remove(al.size() - 1);
					
					}
				else{
					return false;
				}
			
			}
			

			if (ch.equals("]")){
				
				if (al.get(al.size() - 1).equals("[")){
				
					al.remove(al.size() - 1);
				
				}
				else{
					return false;
				}
			}
			

			if (ch.equals("}")){
				
		
				if (al.get(al.size() - 1).equals("{")){
					al.remove(al.size() - 1);
				}else{
						return false;
					}
				}
			}	

		isBalanced(ros);
		
		if (al.size() == 0)
			{
			System.out.println(al);
			return true;
			}
		
		return false;
	}

//	private static boolean isBalancedWithRecursionStack(String str) {
//
//
//		char ch = str.charAt(0);
//		String ros = str.substring(0,1);
//		
//		if(ch == ')' || ch == ']' || ch == '}'){
//			return false;
//		}
//		
//		
//		
//		
//		return true;
//	}

	public static void main(String args[]) {


		Scanner scn = new Scanner(System.in); 
		System.out.println(isBalanced(scn.nextLine()));
		
	}

}
