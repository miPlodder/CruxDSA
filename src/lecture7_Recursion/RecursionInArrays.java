package lecture7_Recursion;

public class RecursionInArrays {

	public static boolean isSortedA1(int[] arr){
		
		if(arr.length == 1){
			return true;
		}
		
		
		
		if(arr[0] <= arr[1]){
			
			int[] sa = new int[arr.length - 1];
			for(int i = 1 ; i < arr.length ; i++)
				sa[i-1] = arr[i];
			
			boolean rv = isSortedA1(sa);
			
			return rv;
		}
		else{
			return false;
		}
		//return rv;
	}
	
	public static boolean isSortedSmarter(int[] arr,int index){
		
		//base case
		if(index == arr.length-1){
			return true;
		}
		
		
		if(arr[index] < arr[index + 1])
		{
			
			return isSortedSmarter(arr,index+1);
			
			
		}
		else{
			return false;
		}
		
		
		
	}
	

	
	public static void main(String[] args) {
		
		
		
		int[] arr = {1,2,3};
		System.out.print(isSortedSmarter(arr,0));
	}

}
