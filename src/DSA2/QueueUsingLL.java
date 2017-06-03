package DSA2;

import genericsHashMap.LinkedList;

public class QueueUsingLL {

	private LinkedList list = new LinkedList();

	public void display() {
		//
		list.display();

	}

	public boolean isEmpty() {
		return this.list.getSize() == 0;
	}

	public int size() {
		return this.list.getSize();
	}

	public void enqueue(int data) {

		this.list.AddLast(data);

	}

	public int dequeue() throws Exception {

		return this.list.removeFirst();

	}

	public int front() throws Exception {

		return this.list.getFirst();
	}

}
