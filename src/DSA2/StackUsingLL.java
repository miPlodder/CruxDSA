package DSA2;

import genericsHashMap.LinkedList;

public class StackUsingLL {

	private LinkedList list = new LinkedList();

	public void display() {

		list.display();

	}

	public boolean isEmpty() {
		return this.list.getSize() == 0;
	}

	public int size() {
		return this.list.getSize();
	}

	public void push(int data) {

		this.list.AddLast(data);

	}

	public int pop() throws Exception {

		int rv = 0;
		try {

			rv = this.list.removeLast();
		} catch (Exception ex) {

			System.out.println("Stack is EMPTY");

		}
		return rv;
	}

	public int top() throws Exception {

		return this.list.getLast();
	}

}
