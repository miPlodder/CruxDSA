package DataStructure.Queue;

public class DynamicQueue extends Queue{
	
	public DynamicQueue(){
		
		this(DEFAULT_CAPACITY);
		
	}
	public DynamicQueue(int capacity){
	
//		PROBLEM
//		DEFAULT_CAPACITY = item ;
		super(capacity);
		
	}
	
	
	@Override
	public void enqueue(int item) throws Exception {
		
		if(this.data.length == this.size){	
			
			int[] temp = new int[2 * this.data.length];
			
			for(int i = 0 ; i < this.size ; i++){
				temp[i] = this.data[(i+front)%this.data.length]; 
			}
			
			this.data = temp ;
		}
		
		super.enqueue(item);
		
	}
	
	@Override
	public int dequeue() throws Exception {
		
		if((this.data.length/4) == this.size){
			
			int[] temp = new int[this.data.length/4];
			
			for(int i = 0 ; i < this.size ; i++){
				
				temp[i] = this.data[(i+front)%this.data.length];
				
			}
			this.data = temp ;
		}
		
		return super.dequeue();
		
	}

}
