//time complexity is (n*log(logn))

package lecture13;

public class primeNumBest {

	public static void PrimeNumberOptimised(int N) {

		boolean[] arr = new boolean[N];
		for (int i = 0; i < N; i++) {

			arr[i] = true;

		}

		for (int i = 2; i * i < N; i++) {

			if (arr[i] == false) {

				continue;
			}

			for (int j = 2; j * i < N; j++) {

				arr[i * j] = false;
				
			}

		}
		for(int i = 2 ; i < N ; i++){
			
			if(arr[i]){
				
				System.out.println(i);
				
			}
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumberOptimised(100);
	}

}
