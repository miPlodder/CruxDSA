//this() -- used to call different constructor
//this.VariableName -- used to represent/access object variables

package DataStructure.Stack;

public class Stack {

	// this indicates the data MEMBERS OF OBJECT

//	private final int FINAL_CAPACITY = 5;
	protected static final int FINAL_CAPACITY = 5;
	protected int[] stack;
	protected int top;

	public Stack() {
		this(FINAL_CAPACITY);

	}

	public Stack(int capacity) {

		this.stack = new int[capacity];
		this.top = -1;

	}

	public void push(int value) throws Exception {

		

		if (this.stack.length - 1 == top) {

			throw new Exception("Stack is FULL");

		}

		this.top++;
		this.stack[this.top] = value;

	}

	public int pop() throws Exception {

		if (this.top == -1) {

			throw new Exception("Stack is Empty");

		}

		int rv = this.stack[this.top];
		this.stack[this.top] = 0;
		this.top--;
		return rv;

	}

	public int size() {

		return this.top + 1;

	}

	public int top() throws Exception {
		
		if (this.top == -1) {

			throw new Exception("Stack is Empty");

		}

		return this.stack[this.top];

	}
	
	public void display(){
		
		
		for(int i = this.top; i >=0 ; i-- ){
			
			System.out.print(this.stack[i]+" ");
			
		}
		
		System.out.println();
	}

	public boolean isEmpty() {

		return this.top == -1;

	}

}