package Introduction;
import java.util.Scanner;

public class FibonacciCheck {

	public static void main(String args[]) {

		// ctrl + space file will be used to import new Classes Implicitly
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number");
		int num = sc.nextInt();

		int sum = 0;
		int i = 1;

		int a = 0;
		int b = 1;

		while (i <= num) {

			sum = a + b;
			a = b;
			b = sum;
			i++;
		}

	System.out.println(sum);
		
	}

}
