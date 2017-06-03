package Introduction;

//this indicates the data MEMBERS OF OBJECT 

public class Stack {

	private final int FINAL_CAPACITY;
	private int[] stack;
	private int top ;
	
	public Stack(){
		
		this(5);
		
	}
	
	public Stack(int FINAL_CAPACITY){
		
		this.FINAL_CAPACITY = FINAL_CAPACITY ;
		stack = new int[FINAL_CAPACITY];
		this.top = -1;
		
	}
	
	public void push(int value) throws Exception {

		
		this.top++;
		
		if(this.FINAL_CAPACITY  == top){
			
			throw new Exception("Stack is FULL");
			
		}
		
		
		this.stack[this.top] = value;
		
	}

	public int pop() throws Exception{
		
		if(this.top == -1){
			
			throw new Exception("Stack is Empty");
			
		}
		
		
		
		int rv = this.stack[this.top];
		this.stack[this.top] = 0 ;
		this.top--;
		return rv ;
		
	}
	
	public int size(){
		
		return this.top+1;
		
	}
	public int top(){
		
		return this.stack[this.top];
		
	}
	public boolean isEmpty(){
		
		return this.top == -1 ;
		
	}
	
	
}
