package DSA2;

public class StackUsingQueue {

	private QueueUsingLL qp = new QueueUsingLL();
	private QueueUsingLL qs = new QueueUsingLL();

	
	public void display() throws Exception{

		this.displayHelper();
		QueueUsingLL temp = this.qp;
		this.qp = this.qs;
		this.qs = temp ;
		
	}

	public void displayHelper() throws Exception{
		
		if(this.qp.size() == 0)
			return;
		
		int storage = this.qp.dequeue();
		this.qs.enqueue(storage);
		
		displayHelper();
		
		System.out.print(storage+", ");
		
		return;
	}

	public boolean isEmpty() {
	
		return this.qp.size() == 0;
	
	}

	public int size() {
	
		return this.qp.size();	
	
	
	}

	public void push(int data) {

		this.qp.enqueue(data);

	}

	public int pop() throws Exception {

		while (qp.size() != 1) {

			qs.enqueue(qp.dequeue());

		}

		int rv = qp.dequeue();
		QueueUsingLL temp = qp;
		qp = qs;
		qs = temp;
		return rv;
	}

	public int top() throws Exception {
		
		while (qp.size() != 1) {

			qs.enqueue(qp.dequeue());

		}

		int rv = qp.dequeue();
		
		qs.enqueue(rv);
		
		QueueUsingLL temp = qp;
		qp = qs;
		qs = temp;
		return rv;
	}
}
