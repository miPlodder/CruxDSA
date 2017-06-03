package DataStructure.Stack;

import java.util.Scanner;

public class StackDynamicClient {

	public static void main(String[] args) {

		StackDynamic obj = new StackDynamic();

		Scanner scn = new Scanner(System.in);

		char ch;

		try{
			do {
	
	
				System.out.println("Enter any Character");
				System.out.println("1 for PUSH");
				System.out.println("2 for POP");
				System.out.println("3 for DISPLAY");
				
				ch = scn.next().charAt(0);
	
				switch (ch) {
	
				case '1':
					obj.push(scn.nextInt());
					break;
				case '2':
					obj.pop();
					break;
				case '3':
					obj.display();
					break;
				default:
					break;
				}

		} while (ch != 'x' || ch != 'X');
		
		}catch(Exception ex){
			
			System.out.println("There is Problem SomeWhere");
}
	}
}

