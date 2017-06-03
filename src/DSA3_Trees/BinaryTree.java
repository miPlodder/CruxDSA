package DSA3_Trees;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	Node root;
	int size;

	private class Node {

		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {

			this.data = data;
			this.left = left;
			this.right = right;

		}

	}

	public BinaryTree() {

		Scanner scn = new Scanner(System.in);
		this.root = this.getInput(scn, null, false);

	}

	private Node getInput(Scanner scn, Node parent, boolean wChild) {

		if (parent == null) {

			System.out.println("Enter data for Root Node");

		} else {

			if (wChild) {

				System.out.println("Enter data for left child" + parent.data);

			}

			else {

				System.out.println("Enter data for right child" + parent.data);

			}
		}

		Node child = new Node(scn.nextInt(), null, null);
		this.size++;

		System.out.println("Do you have a left child");

		boolean choiceLeft = scn.nextBoolean();

		if (choiceLeft)
			child.left = getInput(scn, child, true);

		System.out.println("Do you have a right child");
		boolean choiceRight = scn.nextBoolean();
		if (choiceRight)
			child.right = getInput(scn, child, false);

		return child;

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

		if (node.left != null){
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

	public int size2() {

		return size2(this.root);

	}

	private int size2(Node node) {

		int lsize = 0, rsize = 0;

		if (node.left != null) {

			lsize = this.size2(node.left);

		}
		if (node.right != null) {

			rsize = this.size2(node.right);

		}
		return lsize + lsize + 1;

	}

	public int min() {

		return this.min(this.root);

	}

	private int min(Node node) {

		int rmin = Integer.MAX_VALUE;
		int lmin = Integer.MAX_VALUE;

		if (node.left != null) {
			lmin = this.min(node.left);
		}

		if (node.right != null) {
			rmin = this.min(node.right);
		}

		int rv = Math.min(node.data, Math.min(rmin, lmin));

		return rv;
	}

	// max, mirror questions pending
	public boolean find(int data) {

		return this.find(this.root, data);

	}

	public boolean find(Node node, int data) {

		if (node == null)
			return false;

		if (node.data == data)
			return true;

		if (find(node.left, data))
			return true;

		if (find(node.right, data))
			return true;

		return false;
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

	public void preOrder() {

		preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);

	}

	public void postOrder() {

		this.postOrder(this.root);
		System.out.println("END");
	}

	public void postOrder(Node node) {

		if (node == null) {
			return;
		}

		postOrder(node.left);

		postOrder(node.right);

		System.out.print(node.data + ", ");

}

	public void InOrder() {

		this.InOrder(this.root);
		System.out.println("END");

	}

	public void InOrder(Node node) {

		if (node == null) {
			return;
		}

		InOrder(node.left);
		System.out.print(node.data + ", ");
		InOrder(node.right);

	}

	public void levelOrder() {

		this.levelOrder(this.root);
		System.out.println("END");

	}

	private void levelOrder(Node node) {

		LinkedList<Node> queue = new LinkedList<>();

		queue.add(node);

		while (!queue.isEmpty()) {

			Node temp = queue.removeFirst();

			System.out.print(temp.data + ", ");

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}

		}

	}

	// using stack
	public void preOrderIterative() {

		this.preOrderItertive(this.root);
		System.out.println("END");

	}

	private void preOrderItertive(Node node) {

		LinkedList<Node> stack = new LinkedList<>();

		stack.addFirst(node);

		while (!stack.isEmpty()) {

			Node temp = stack.removeFirst();
			System.out.print(temp.data + ", ");

			if (temp.right != null) {
				stack.addFirst(temp.right);
			}

			if (temp.left != null) {
				stack.addFirst(temp.left);
			}

		}

	}

	private class HeapMover {

		Node prev;
		Node curr;
		Node succ;

	}

	// Integer can give value as NULL as NON - PRIMITIVE
	// whereas int is PRIMITIVE so value cannot be NULL
	public Integer getPostPrev(int item) {

		HeapMover mover = new HeapMover();
		this.getPostPrev(this.root, mover, item);
		return mover.prev.data;
	}

	private void getPostPrev(Node node, HeapMover mover, int item) {

		this.getPostPrevSucc(this.root, mover, item);

	}

	// bottom up approach
	public void getPostPrevSucc(Node node, HeapMover mover, int item) {

		if (node == null)
			return;

		getPostPrevSucc(node.left, mover, item);
		getPostPrevSucc(node.right, mover, item);

		// if(mover.curr )

	}

}
