package lecture7_Recursion;

public class Patterns {

	public static void pattern1(int N,int row , int col){
		
		
		//conditions
		if(row > N)
			return;
		
		if(col > row){
			
			System.out.println();
			pattern1(N,row+1,1);
			return;
			
		}
		
		//body
		System.out.print("*");
		pattern1(N,row,col+1);
		
	}
	
	
	public static void main(String[] args) {
		
		pattern1(3,1,1);

	}

}
