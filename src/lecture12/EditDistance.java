package lecture12;

//make str2 equal to str1 in minimum steps

public class EditDistance {

	public static int EditDistanceRecursion(String str1, String str2) {


		if(str1.length() == 0){
			
			return str2.length();
		}
		
		if(str2.length() == 0){
			
			return str1.length();
			
		}
			
			
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);

		int rv=0;

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);

		if (ch1 == ch2) {

			rv = EditDistanceRecursion(ros1, ros2);

		} else {

			// replacement
			int f1 = 1 + EditDistanceRecursion(ros1, ros2);

			// insertion
			int f2 = 1 + EditDistanceRecursion(ros1, str2);

			// removal
			int f3 = 1 + EditDistanceRecursion(str1, ros2);

			rv = Math.min(f1, Math.min(f2, f3));

		}

		return rv;
	}

	public static int EditDistanceRecursionPractice(String str1,String str2){
		
		if(str1.length() == 0){
			
			return str2.length();
		}
		
		if(str2.length() == 0){
			
			return str1.length();
			
		}
		
		
		int rv = 0 ;
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		
		if(ch1 == ch2){
			
			rv = EditDistanceRecursionPractice(ros1, ros2);
			
		}
		else{
			
			//replace
			int temp1 = 1 + EditDistanceRecursionPractice(ros1,ros2 );
			//insert
			int temp2 = 1 + EditDistanceRecursionPractice(ros1, str2);
			//remove
			int temp3 = 1 + EditDistanceRecursionPractice(str1, ros2);
			
			rv = Math.min(temp1, Math.min(temp2, temp3));
	
		}
		
		
		return rv ;
	}
	
	
	public static int EditDistanceIteration(String str1, String str2,int[][] arr){
		
		
		int rv = 0 ;		
		
		for(int i = 0; i <= str1.length(); i++){
			
			for(int j = 0 ; j <= str2.length() ; j++){
				
				if(i == 0){
					arr[i][j] = j;
					continue;
				}
				if(j == 0){
					arr[i][j] = i ;
					continue;
				}
				char ch1 = str1.charAt(i-1);
				char ch2 = str2.charAt(j-1);
				
				if(ch1 == ch2){
					
					arr[i][j] = arr[i-1][j-1];
					
				}
				else{
					
					arr[i][j] = Math.min(arr[i-1][j], Math.min(arr[i][j-1], arr[i-1][j-1]));
					
				}
			}
		}
				
				return arr[str1.length()][str2.length()];
			}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(EditDistanceRecursion("abc","bcd"));
		System.out.println(EditDistanceRecursionPractice("abc","bcd"));
		System.out.println(EditDistanceIteration("abc","bcd",new int[4][4]));

	}

}
