package lecture7_Recursion;

public class Recursion {
	
	public static void PDISkip(int num){
		
		if(num == 0)
			return;
		
		if(num%2 != 0)
			System.out.println(num);
			
		PDISkip(num-1);
		
		if(num%2 == 0)
			System.out.println(num);
	
	}

	public static int Power(int base , int pow){
		
		if(pow == 0)
			return 1 ;
		
		int res = base * Power(base, pow - 1);
		
		return res ;
	}
	
	public static int Factorial(int number){
		
		if(number == 0){
			return 1 ;
		}
		int result = number * Factorial(number - 1 );
		
		return result;
	}
	
	public static int FibonacciSeries(int number){
		
		if(number == 0 || number == 1){
			return number;
		}
		
		int result = FibonacciSeries(number - 1) + FibonacciSeries(number - 2) ;
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Factorial(1211));
		System.out.println(FibonacciSeries(5));
	}

}
