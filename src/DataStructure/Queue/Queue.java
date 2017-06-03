package DataStructure.Queue;

public class Queue {

	protected int[] data;
	protected int front;
	protected int size;

	public static final int DEFAULT_CAPACITY = 5;

	public Queue() {

		//this(this.DEFAULT_CAPACITY) --will show error 
		this(DEFAULT_CAPACITY);

	}

	public Queue(int capacity) {

		this.data = new int[capacity];
		this.front = 0;
		this.size = 0;

	}

	public int size() {

		return this.size;

	}

	public boolean isEmpty() {

		return (this.size == 0);

	}

	public void display() {

		for (int i = 0; i < this.size; i++) {

			int ai = (i + this.front) % this.data.length;
			System.out.print(this.data[ai] + " ");

		}
		System.out.println();
		System.out.println("******************************");

	}

	public void enqueue(int item) throws Exception {

		if (this.size == this.data.length)
			throw new Exception("Queue is full");

		int index = (this.front + this.size) % (this.data.length);
		data[index] = item;
		this.size++;
	}

	public int dequeue() throws Exception {

		if (this.size == 0)
			throw new Exception("Queue is empty");

		int rv = this.data[this.front];

		this.data[front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;

		return rv;
	}

	public int firstElement() throws Exception {

		if (this.size == 0)
			throw new Exception("Queue is empty");

		int rv = this.data[this.front];

		return rv;
	}

}
