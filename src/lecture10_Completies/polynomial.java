package lecture10_Completies;

public class polynomial {

	public static int power(int N, int exp) {

		// base case
		if (exp == 1) {

			return N;

		}
		// call
		int res;

		// converting n to logn by varying the parameter by 2

		int pwrb2 = power(N, exp / 2);
		if (exp % 2 == 0) {

			res = pwrb2 * pwrb2;

		} else {

			res = pwrb2 * pwrb2 * N;

		}

		return res;
	}

	public static void poly(int x, int n) {
		
		int res = 0 ;
		
		
		int pow = power(x,n);
		for(int i = 1 ; i <= n ; i++ ){
			
			
			res += i*pow;
			pow /=x ;
		}
		
		System.out.println(res);
		
		
	}

	public static void main(String[] args) {
		poly(2,3);
	}

}
