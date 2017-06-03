package DataStructure.Stack;

public class StackDynamic extends Stack{

	
	public StackDynamic(){
		
		this(FINAL_CAPACITY);
		
	}
	
	public StackDynamic(int capacity){
		
		
		//super.Stack(capacity)
		super(capacity);
		
	}
	
	@Override
	public void push(int item) throws Exception{
		
		if(this.stack.length == this.top + 1){
			
			int[] temp = new int[2*this.stack.length];
			for(int i = 0 ; i < this.stack.length ; i++)
				temp[i] = this.stack[i];
		
			this.stack = temp ;
		}
		
	/*	this.top ++ ;
		this.stack[top] = item ;	*/
		super.push(item);
		
	}
	
	@Override
	public int pop() throws Exception{
		
		if((this.stack.length/4) == this.top + 1){
			
			int[] temp = new int[this.stack.length/2];
			
			for(int i=0 ; i < temp.length  ; i++){
				temp[i] = this.stack[i];
			}
			
			this.stack = temp;
		}
		
		
		return super.pop();
	}
	
}
