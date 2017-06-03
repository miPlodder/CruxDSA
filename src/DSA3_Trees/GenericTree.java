//this just indicates that object belongs to the class 

package DSA3_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {

	private Node root;
	private int size;

	private class Node {

		int data;
		ArrayList<Node> children;

		public Node(int data) {

			this.data = data;
			this.children = new ArrayList<>();

		}

	}

	// take input here
	public GenericTree() {

		this.size = 0;

		Scanner scn = new Scanner(System.in);

		this.root = this.takeInput(scn, null, 0); ///////////////////

	}

	private Node takeInput(Scanner scn, Node parent, int ithChild) {

		if (parent == null) {
			System.out.println("Enter data of Root Node");
		} else {

			System.out.println("Enter the data for " + ithChild + " of " + parent.data);
		}

		Node child = new Node(scn.nextInt());
		this.size++;
		System.out.println("Enter the number of Children");
		int sizeGC = scn.nextInt();

		for (int i = 0; i < sizeGC; i++) {

			child.children.add(this.takeInput(scn, child, i));

		}

		return child;
	}

	public void display() {
		this.display(root);
	}

	private void display(Node node) {

		System.out.print(node.data + " => ");

		for (int i = 0; i < node.children.size(); i++) {

			System.out.print(node.children.get(i).data + " ,");

		}
		System.out.println(",END");
		for (int i = 0; i < node.children.size(); i++) {

			display(node.children.get(i));
		}

	}

	public int getsize() {
		return this.size;
	}

	public boolean isEmpty() {
		return getsize() == 0;
	}

	public int size2() {

		return this.size2(this.root);

	}

	public int size2(Node node) {

		int rv = 0;

		for (int i = 0; i < node.children.size(); i++) {

			rv += size2(node.children.get(i));

		}

		return rv + 1;
	}

	public int height() {

		return this.height(root);
	}

	public int height(Node node) {

		int hmax = -1;

		for (int i = 0; i < node.children.size(); i++) {

			int temp = height(node.children.get(i));

			if (hmax < temp)
				hmax = temp;

		}

		return hmax + 1;
	}

	public boolean find(int data) {

		return find(this.root, data);

	}

	public boolean find(Node node, int data) {

		if (node.data == data) {
			return true;
		}

		boolean rv = false;

		for (int i = 0; i < node.children.size(); i++) {

			boolean valueFound = find(node.children.get(i), data);
			if (valueFound) {
				return true;
			}

		}

		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	public int max(Node node) {

		if (node.children.size() == 0)
			return node.data;

		int max = 0;

		for (int i = 0; i < node.children.size(); i++) {

			int temp = max(node.children.get(i));
			if (temp > max)
				max = temp;

		}

		return max;
	}

	// public

	public Integer justLarger(int data) {
		if (justLarger(root, data) == null)
			return null;
		else
			return justLarger(root, data).data;
	}

	// TODO Using int return Value(below function)

	private Node justLarger(Node node, int data) {

		Node rv = null;

		if (node.data > data) {
			rv = node;
		}

		for (int i = 0; i < node.children.size(); i++) {

			// just Larger (cjl)
			Node cJL = justLarger(node.children.get(i), data);
			if (cJL == null) {
				continue;
			} else {
				if (rv == null) {
					rv = cJL;
				} else {
					if (rv.data > cJL.data)
						rv = cJL;
				}
			}

		}

		return rv;
	}

	public int kthSmallest(int pos) {

		int temp = Integer.MIN_VALUE;

		for (int i = 0; i < pos; i++) {

			temp = justLarger(temp);

		}

		return temp;
	}

	public void mirror() {

		this.mirror(this.root);

	}

	private void mirror(Node node) {

		for (int i = 0; i < (node.children.size() - 1) / 2; i++) {

			Node temp = node.children.get(i);
			node.children.set(i, node.children.get(node.children.size() - i - 1));
			node.children.set(node.children.size() - i - 1, temp);

		}

		for (int i = 0; i < node.children.size(); i++) {

			mirror(node.children.get(i));

		}
	}

	public void printAtLevel(int level) {

		this.printAtLevel(this.root, level, 1);

	}

	// If level is 2, it display all the node data at level 2 (Working of Below
	// Function)
	
	//print at level means its LEVELORDER TRANSVERSAL
	
	private void printAtLevel(Node node, int level, int height) {

		if (level == height) {

			// for(int i = 0 ; i < node.children.size() ; i++)
			System.out.print(node.data + " ,");

		}

		for (int i = 0; i < node.children.size(); i++) {

			printAtLevel(node.children.get(i), level, height + 1);

		}

	}

	public void eulerPath() {

		this.eulerPath(this.root);
	}

	private void eulerPath(Node node) {

		for (int i = 0; i < node.children.size(); i++) {

			eulerPath(node.children.get(i));

		}

		System.out.print(node.data + " ,");
	}

	public void preOrder() {

		this.preOrder(this.root);
		System.out.println(" END");
	}

	private void preOrder(Node node) {

		System.out.print(node.data + ", ");
		for (int i = 0; i < node.children.size(); i++) {

			preOrder(node.children.get(i));

		}

	}

	public void postOrder() {

		this.postOrder(this.root);
		System.out.print(" END" + ", ");

	}

	private void postOrder(Node node) {

		for (int i = 0; i < node.children.size(); i++) {

			postOrder(node.children.get(i));

		}

		System.out.print(node.data + ", ");

	}

	public void linearize() {

		this.linearize(this.root);

	}

	private void linearize(Node node) {

		for (int i = 0; i < node.children.size(); i++) {

			linearize(node.children.get(i));

		}
		Node tail = null;

		while (node.children.size() > 1) {

			Node removed = node.children.remove(1);
			tail = getTail(tail == null ? node.children.get(0) : tail);
			tail.children.add(removed);

		}

	}

	private Node getTail(Node node) {

		while (node.children.size() != 0) {

			node = node.children.get(0);

		}

		return node;
	}

	// Linearize Without Tail
	public void linearizeWT() {

		this.linearize(this.root);

	}

	private Node linearizeWT(Node node) {

		if (node.children.size() == 0) {
			return node;
		}

		Node tail = linearizeWT(node.children.get(0));

		while (node.children.size() > 1) {

			Node removedTail = node.children.remove(1);

			tail.children.add(removedTail);

			Node newTail = linearizeWT(removedTail);

			tail = newTail;

		}

		return tail;
	}

	/*
	 * public int maxSONC() {
	 * 
	 * 
	 * int maxSum = 0; Node maxNode = maxSONC(this.root); maxSum = maxNode.data;
	 * for (int i = 0; i < maxNode.children.size(); i++) {
	 * 
	 * maxSum += maxNode.children.get(i).data;
	 * 
	 * } return maxSum; }
	 * 
	 *//*
		 * private Node maxSONC(Node node, int maxSum) {
		 * 
		 * 
		 * int temp = 0;
		 * 
		 * maxSum = node.data;
		 * 
		 * for (int i = 0; i < node.children.size(); i++) {
		 * 
		 * maxSum += node.children.get(i).data;
		 * 
		 * }
		 * 
		 * if(maxSum < temp){ maxSum = temp ; }
		 * 
		 * 
		 * //calls for (int i = 0; i < node.children.size(); i++) {
		 * 
		 * maxSONC(node.children.get(i),maxSum);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
	public int maxSONC() {

		return this.maxSONC(this.root).data;
	}

	private Node maxSONC(Node node) {

		Node rv = node;

		for (int i = 0; i < node.children.size(); i++) {

			Node temp = maxSONC(node.children.get(i));
			if (getSum(temp) > getSum(rv)) {

				rv = temp;

			}

		}

		return rv;
	}

	private int getSum(Node node) {

		int rv = node.data;

		for (int i = 0; i < node.children.size(); i++)
			rv += node.children.get(i).data;

		return rv;
	}

	public class heapMover {

		Node node;
		int score;

		public heapMover(Node node) {
			this.node = node;
			this.score = getSum(node);

		}

	}

	public int maxSONC2() {

		heapMover rm = this.maxSONC2(this.root);

		return rm.node.data;

	}

	public heapMover maxSONC2(Node node) {

		heapMover max = new heapMover(node);

		for (int i = 0; i < node.children.size(); i++) {
			heapMover cmax = this.maxSONC2(node.children.get(i));

			if (cmax.score > max.score)
				max = cmax;
		}

		return max;
	}

	private class heapMoverTR {

		int max;
		int min;

		public heapMoverTR() {

			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
		}
		
		public heapMoverTR(Node root){
			
			this.min = root.data;
			this.max = root.data;
		
		}

	}

	// ==============================================================================================
	// bottom Up Approach
	public int getRange() {

		heapMoverTR hm = new heapMoverTR(this.root);
		hm = this.getRange(this.root, hm);
		System.out.println(hm.max+""+hm.min);
		return hm.max - hm.min;

	}

	// TR - Tree Range
	private heapMoverTR getRange(Node node, heapMoverTR hm) {

		
		
		for (int i = 0; i < node.children.size(); i++) {

			getRange(node.children.get(i), hm);

			if (hm.max < node.children.get(i).data) {

				hm.max = node.children.get(i).data;

			}
			if (hm.min > node.children.get(i).data) {

				hm.min = node.children.get(i).data;

			}

		}

		return hm;

	}

	// top down approach
	public int getRangeTD() {

		heapMoverTR rm = new heapMoverTR();
		getRangeTD(this.root, rm);
		return rm.max - rm.min;

	}

	private void getRangeTD(Node node, heapMoverTR mover) {

		if (mover.max < node.data) {
			mover.max = node.data;
		}

		if (mover.min > node.data) {
			mover.min = node.data;
		}

		for (int i = 0; i < node.children.size(); i++) {

			getRangeTD(node.children.get(i), mover);

		}

	}

	public void levelOrderIterative() {

		// queue is interface but stack is class
		Queue<Node> q = new LinkedList<Node>();
		q.add(this.root);

		while (!q.isEmpty()) {

			Node temp = q.remove();
			System.out.print(temp.data + ", ");

			for (int i = 0; i < temp.children.size(); i++) {
				q.add(temp.children.get(i));
			}

		}

	}

	// heap mover class
	private class HML {

	}

	// top down approach
	private void linearizeTD(Node node, HML mover) {

	}

}
