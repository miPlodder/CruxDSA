//this just indicates that variable or function is of that CLASS ONLY

package genericsHashMap;

public class LinkedList<T> {

	private Node head;
	private Node tail;
	private int size;

	private class Node {

		T data;
		Node next;

		public Node(T data, Node next) {

			this.data = data;
			this.next = next;

		}

	}

	public LinkedList() {

		head = null;
		tail = null;
		size = 0;

	}

	public void AddFirst(T data) {

		Node newNode = new Node(data, this.head);

		this.head = newNode;

		if (this.size == 0)
			this.tail = newNode;

		size++;

	}

	public void display() {

		Node rv = this.head;

		while (rv != null) {

			System.out.print(rv.data + " ");
			rv = rv.next;
		}

		System.out.println("END");
		System.out.println("****************************************");

	}

	public void AddLast(T data) {

		Node newNode = new Node(data, null);

		if (this.size == 0) {

			this.head = newNode;
			this.tail = newNode;

		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}

		this.size++;

	}

	public Node getNodeAt(int index) {

		Node rv = this.head;
		int counter = 0;
		while (counter < index) {

			rv = rv.next;
			counter++;
		}

		return rv;
	}

	public void AddInBetween(T data, int index) {

		if (index == 0)
			this.AddFirst(data);

		else if (index == this.size)
			this.AddLast(data);

		else {

			Node prev = getNodeAt(index - 1);
			Node newNode = new Node(data, prev.next);
			prev.next = newNode;
			this.size++;
		}
	}

	public int getSize() {

		return size;
	}

	public boolean isEmpty() {

		return size == 0;

	}

	public T getFirst() throws Exception {

		if (size == 0)
			throw new Exception("Linked List is EMPTY");

		return this.head.data;

	}

	public T getLast() throws Exception {

		if (size == 0)
			throw new Exception("Linked List is EMPTY");

		return this.tail.data;

	}

	public T getAt(int index) throws Exception {

		if (index < 0 || index >= size)
			throw new Exception("Index Out of Bound");

		if (size == 0)
			throw new Exception("Linked List is EMPTY");

		else {

			Node n = getNodeAt(index);
			return n.data;
		}
	}

	public T removeFirst() throws Exception {

		T rv;

		if (this.size == 0)
			throw new Exception("Linked List is EMPTY");

		if (this.size == 1) {
			rv = this.head.data;
			this.head = this.tail = null;
			this.size--;

		} else {

			rv = this.head.data;
			this.head = this.head.next;
			this.size--;
		}

		return rv;
	}

	public T removeLast() throws Exception {

		T rv;

		if (this.size == 0)
			throw new Exception("Linked List is EMPTY");

		else if (this.size == 1) {
			rv = this.tail.data;
			this.head = this.tail = null;
			this.size--;

		} else {

			rv = this.tail.data;
			Node nm1 = getNodeAt(size - 2);
			this.tail = nm1;
			nm1.next = null;
			this.size--;
		}

		return rv;
	}

	public T removeAt(int index) throws Exception {

		T rv = null;

		if (index < 0 || index > this.size) {
			throw new Exception("Index Out of Bound");

		}

		if (this.size == 0)
			throw new Exception("Linked List is EMPTY");

		if (this.size == 1) {

			this.head = this.tail = null;
			this.size--;

		} else {

			Node nm1 = getNodeAt(index - 1);
			rv = nm1.next.data;

			nm1.next = nm1.next.next;
			this.tail = nm1;
			this.size--;
		}

		return rv;
	}

}
