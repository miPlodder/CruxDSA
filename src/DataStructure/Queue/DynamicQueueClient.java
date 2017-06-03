package DataStructure.Queue;

import java.util.Scanner;

public class DynamicQueueClient {

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);
		DynamicQueue object = new DynamicQueue(7);

		char ch ;
		
		try{
		
				do {
		
					System.out.println("Enter 1 for ENQUEUE");
					System.out.println("Enter 2 for DEQUEUE");
					System.out.println("Enter 3 for DISPLAY");
		
					ch = scn.next().charAt(0);
		
					switch (ch) {
		
					case '1':
		
						object.enqueue(scn.nextInt());
						break;
					case '2':
		
						object.dequeue();
						break;
					case '3':
		
						object.display();
						break;
					default:
		
						break;
					}
		
				} while (ch != 'x' || ch != 'X');

		}
		catch(Exception ex){
			
			System.out.println("You Performed a wrong Operation.Please try Again");
			
		}
	}
}
