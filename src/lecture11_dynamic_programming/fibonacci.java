package lecture11_dynamic_programming;

public class fibonacci {
	
	public static long start =0;
	public static long end =0;
	
	public static long timeStart(){
		
		fibonacci.start = System.currentTimeMillis();
		return fibonacci.start;
	}
	
	public static long timeStop(){
		
		fibonacci.end = System.currentTimeMillis();
		return fibonacci.end - fibonacci.start;
		
	}
	
	
	public static int Fib(int element) {

		if (element == 0 || element == 1) {

			return element;

		}

		int rv;

		rv = Fib(element - 1) + Fib(element - 2);

		return rv;
	}

	public static int FibMod(int element,int[] arr) {

		if (element == 0 || element == 1) {

			return element;

		}
		
		if(arr[element] != 0){
			
			return arr[element];
			
		}

		int rv;

		rv = FibMod(element - 1,arr) + FibMod(element - 2,arr);

		arr[element] = rv ;
		
		return rv;
	}

	public static int FibIt(int n){
		
		int[] arr = new int[n+1];
		arr[0] = 0 ;
		arr[1] = 1 ;
		
		for(int i = 2 ; i <= n ; i++){
			
			arr[i] = arr[i-1] + arr[i-2];
			
		}
		
	return arr[n];
	}
	
	public static int FibBest(int n){
		
		//moving mirror method
		int[] arr = {0,1};
		
		for(int i = 2 ; i <= n ; i++){
			
			int temp = arr[0];
			arr[0] = arr[1];
			arr[1] = arr[0] + temp ;
		
		}
		
		return arr[1];
		
	}
	
	public static void main(String[] args) {

		int[] arr = new int[100];
	
		System.out.println(FibIt(20));
		System.out.println(FibBest(20));
		
		fibonacci.timeStart();
		System.out.println(FibMod(20,arr));
		System.out.println(fibonacci.timeStop());
		
		timeStart();
		System.out.println(Fib(20));
		System.out.println(fibonacci.timeStop());
	
	}

}
