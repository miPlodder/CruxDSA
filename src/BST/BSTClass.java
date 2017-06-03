package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BSTClass {

	Node root;
	int size;

	private class Node {

		int data;
		Node left;
		Node right;
	}

	public BSTClass(int... arr) {

		this.root = this.constructor(arr, 0, arr.length - 1);

	}

	private Node constructor(int[] arr, int lo, int hi) {

		if (lo > hi)
			return null;

		int mid = (lo + hi) / 2;

		Node node = new Node();
		this.size++;
		node.data = arr[mid];

		node.left = constructor(arr, lo, mid - 1);
		node.right = constructor(arr, mid + 1, hi);

		return node;

	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {

		display(this.root);

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {

			System.out.print("END =>");
		}

		System.out.print(node.data);

		if (node.right != null) {
			System.out.println(" <= " + node.right.data);
		} else {

			System.out.println("<= END ");
		}

		if (node.left != null)
			display(node.left);
		if (node.right != null)
			display(node.right);

	}

	// 1
	public int min() {

		return this.min(this.root);

	}

	private int min(Node node) {

		if (node.left == null)
			return node.data;

		int rv = min(node.left);

		return rv;
	}

	public int max() {

		return this.max(this.root);

	}

	private int max(Node node) {

		if (node.right == null)
			return node.data;

		int rv = max(node.right);

		return rv;
	}

	// 2
	public boolean find(int data) {

		return this.find(this.root, data);

	}

	public boolean find(Node node, int data) {

		boolean rv = false;

		if (node == null)
			return rv;

		if (node.data == data)
			rv = true;
		else if (node.data < data)
			rv = find(node.right, data);
		else if (node.data > data)
			rv = find(node.left, data);

		return rv;

	}

	public int height() {

		return height(this.root);

	}

	public int height(Node node) {

		if (node == null) {
			return -1;
		}

		int leftH = this.height(node.left);
		int rightH = this.height(node.right);

		int rv = Math.max(leftH, rightH) + 1;

		return rv;
	}

	public void printInRange(int snum, int lnum) {

		printInRange(this.root, snum, lnum);

	}

	private void printInRange(Node node, int snum, int lnum) {

		if (node.data < snum) {

			if (node.right != null)
				printInRange(node.right, snum, lnum);

		}

		else if (node.data > lnum) {

			if (node.left != null)
				printInRange(node.left, snum, lnum);

		} else {

			if (node.left != null)
				printInRange(node.left, snum, lnum);

			if (node.right != null)
				printInRange(node.right, snum, lnum);

			System.out.print(node.data + "->");

		}

	}

	// using HeapMover

	public class HeapMover {

		int sum;

	}

	// question
	// ?-----------------------------------------------------------------------------------problem in question
	private void rwsl() {

		this.rwsl(this.root);

	}

	// replace with sum of larger
	public void rwsl(Node node) {

	}

	// level order
	// in order
	// pre order
	// post order

	public void printInOrder() {

		this.printInOrder(this.root);

	}

	private void printInOrder(Node node) {

		if (node == null)
			return;

		printInOrder(node.left);
		System.out.print(node.data + "--");
		printInOrder(node.right);

	}

	public void printLevelOrderI() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		this.printLevelOrderI(this.root, queue);
	}

	private void printLevelOrderI(Node node, LinkedList<Node> queue) {

		while (!queue.isEmpty()) {

			Node temp = queue.removeFirst();
			System.out.print(temp.data + "-");

			if (temp.left != null)
				queue.addLast(temp.left);
			if (temp.right != null)
				queue.addLast(temp.right);

		}

	}

	public void printLevelOrder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		this.printLevelOrder(queue);
	}

	private void printLevelOrder(LinkedList<Node> queue) {

		if (!queue.isEmpty()) {

			Node temp = queue.removeFirst();
			System.out.print(temp.data + "-");

			if (temp.left != null)
				queue.addLast(temp.left);
			if (temp.right != null)
				queue.addLast(temp.right);

			printLevelOrder(queue);

		}

		else {
			return;
		}

	}

	public void insertNode(int data) {
		if (this.isEmpty()) {

			this.size++;
			this.root = new Node();
			this.root.data = data;

		} else {
			this.insertNode(data, this.root);

		}

	}

	private void insertNode(int data, Node node) {

		if (node.data > data) {

			if (node.left == null) {

				node.left = new Node();
				this.size++;
				node.left.data = data;

			} else {
				insertNode(data, node.left);
			}

		}

		if (node.data < data) {

			if (node.right == null) {

				node.right = new Node();
				this.size++; // best place to increase size is when you create
								// new NODE
				node.right.data = data;

			} else {

				insertNode(data, node.right);

			}
		}

	}

	public void removeNode(int data) {

		this.removeNode(data, null, this.root, false);

	}

	// 4
	// ilc -- isLeftChild
	private void removeNode(int data, Node parent, Node node, boolean ilc) {

		if (node == null)
			return;

		if (node.data > data) {

			// left
			removeNode(data, node, node.left, true);

		} else if (node.data < data) {

			// right
			removeNode(data, node, node.right, false);

		} else {

			// equal

			// no child
			if (node.left == null && node.right == null) {

				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				this.size--;

			}

			// left child
			else if (node.left != null && node.right == null) {

				if (ilc) // left child
					parent.left = node.left;
				else
					parent.right = node.left;

				this.size--;

			}

			// right child
			else if (node.left == null && node.right != null) {

				if (ilc) // left child
					parent.left = node.right;
				else
					parent.right = node.right;

				this.size--;

			}

			// 2 child
			else {

				int maxL = this.max(node.left);
				node.data = maxL;
				this.removeNode(maxL, node, node.left, true);

			}

		}

	}

	
	//here problem ---------------------------------------------------------problem in question
	// 5
	public void printKFar(int data, int k) {

		// ArrayList<Integer>
		this.printKFarDown(data, k, this.root, 0, false);
		this.printKFar(data, k, null, this.root, false, 0);

	}

	private void printKFar(int data, int k, Node parent, Node node, boolean ilc, int curr) {

		if (data == node.data || curr != 0) {
			
			if (ilc) {
				// left node to parent

			} else {
				// right node to parent

			}
		} else {
			
			printKFar(data, k, node, node.left, true, 0);
			
			printKFar(data, k, node, node.right, true, 0);
		}

	}

	private void printKFarDown(int data, int k, Node node, int curr, boolean isFound) {

		if (node == null)
			return;

		if (k == curr) {

			System.out.println(node.data);
			return;
		}

		if (node.data == data || isFound) {

			printKFarDown(data, k, node.left, curr + 1, true);
			printKFarDown(data, k, node.right, curr + 1, true);

		} else {

			printKFarDown(data, k, node.left, curr, false);
			printKFarDown(data, k, node.right, curr, false);

		}

	}

	// hsf -- height so far
	// fsf -- found so far
	/*
	 * private void printKFar(int data, int k, Node node, int hsf, boolean fsf)
	 * {
	 * 
	 * if (k == hsf) { System.out.print(node.data + "--"); return; }
	 * 
	 * if (node.data == data || fsf) {
	 * 
	 * fsf = true;
	 * 
	 * if (node.left != null) printKFar(data, k, node.left, hsf + 1, fsf);
	 * 
	 * if (node.right != null) printKFar(data, k, node.right, hsf + 1, fsf);
	 * 
	 * } else {
	 * 
	 * if (node.left != null) printKFar(data, k, node.left, hsf, fsf);
	 * 
	 * if (node.right != null) printKFar(data, k, node.right, hsf, fsf);
	 * 
	 * }
	 * 
	 * }
	 */

}