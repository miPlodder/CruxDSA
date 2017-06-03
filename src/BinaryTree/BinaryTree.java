//50 true 25 true 12 false false true 30 false false true 75 true 62 false false true 87 false false
 
//50 true 20 false false true 22 false true 12 false true 24 false false
//50 true 25 true 43 false false true 37 false false true 75 true 62 false false true 87 false false

package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
//import DataStructure.Queue.Queue;
import java.util.Queue;

import javax.xml.bind.DataBindingException;

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

	// -------HOMEWORK STARTS ------------------------------------

	// remove leaf nodes

	public void remLeaf() {

		if (this.root.left == null && this.root.right == null)
			root = null;
		else
			this.remLeaf(this.root, null, false);

	}

	private void remLeaf(Node node, Node parent, boolean ilc) {
		// left - true right - false

		if (node == null)
			return;

		if (node.left == null && node.right == null && ilc == true)
			parent.left = null;

		if (node.left == null && node.right == null && ilc == false)
			parent.right = null;

		remLeaf(node.left, node, true);
		remLeaf(node.right, node, false);

	}

	// printing siblingLess nodes
	public void siblingLess() {

		this.siblingLess(this.root);

	}

	private void siblingLess(Node node) {

		if (node == null)
			return;

		if (node.left != null && node.right == null)
			System.out.print(node.left.data + ",");

		if (node.left == null && node.right != null)
			System.out.print(node.right.data + ",");

		siblingLess(node.left);
		siblingLess(node.right);

	}

	public void levelOrder() {

		// DataStructure.Queue.Queue queue = new DataStructure.Queue.Queue();
		PriorityQueue<Node> queue = new PriorityQueue<Node>();

		queue.offer(this.root);
		levelOrder(queue);

	}

	// error here level order recursive
	// ----------------------------------------------------
	private void levelOrder(PriorityQueue<Node> queue) {

		if (queue.isEmpty())
			return;

		System.out.print(queue.peek().data + "-->");
		Node temp = queue.poll();

		if (queue.peek().left != null)
			queue.offer((temp.left));

		if (queue.peek().right != null)
			queue.offer(temp.right);

		levelOrder(queue);

	}

	// problem using level and height to create levelOrderTraversal
	private class levelOrderQueue {

		// not working
		// Queue<Node> queue = new Queue<Node>();

	}

	// preorder iterative
	public void levelOrderI() {

		this.levelOrderI(this.root);

	}

	private void levelOrderI(Node node) {

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);

		while (!queue.isEmpty()) {

			Node temp = queue.removeFirst();
			System.out.print(temp.data + "-->");

			if (temp.left != null)
				queue.addLast(temp.left);

			if (temp.right != null)
				queue.addLast(temp.right);

		}

	}

	public void preOrderI() {

		LinkedList<Node> stack = new LinkedList<>();
		stack.addLast(this.root);
		preOrderI(stack);

	}

	private void preOrderI(LinkedList stack) {

		while (!stack.isEmpty()) {

			// typecasting
			// ----------------------------------------------------------------------------------
			Node temp = (Node) stack.removeLast();
			System.out.print(temp.data + "-->");

			if (temp.right != null)
				stack.addLast(temp.right);

			if (temp.left != null)
				stack.addLast(temp.left);
		}
	}

	// ---------HOMEWORK ENDS ------------------------------

	// MAIN FUNCTION-----------------------------------------------

	public static void main(String[] args) {

		int[] pre = { 50, 25, 12, 37, 30, 40, 75, 62, 60, 70, 87 };
		int[] in = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };

		// BinaryTree bt = new BinaryTree(pre, in);

		BinaryTree bt = new BinaryTree();
		bt.preOrder();
		bt.InOrder();
		System.out.println("This Tree is " + bt.isBST());
		System.out.println(bt.diameter());
		bt.display(bt.root);
		System.out.println("------LEVEL ORDER STARTS-----------");
		// bt.levelOrder();
		System.out.println("-------LEVEL ORDER ENDS----------");

		System.out.println("------LEVEL ORDER Iterative STARTS-----------");
		bt.levelOrderI();
		System.out.println("-------LEVEL ORDER Iterative ENDS----------");

		System.out.println("------PRE ORDER Iterative STARTS-----------");
		bt.preOrderI();
		System.out.println("-------PRE ORDER Iterative ENDS----------");

		System.out.println("------SiblingLess STARTS-----------");
		bt.siblingLess();
		System.out.println("-------SiblingLess ENDS----------");

		System.out.println("------Remove LEaf STARTS-----------");
		// bt.remLeaf();
		bt.display();
		System.out.println("-------Remove LEaf ENDS----------");
		
		bt.findPath(30);
		System.out.println("---------------------------------------\n"
							+ "\t|largest BST|\n"
							+ "------------------------------------");
		bt.isBST();
	}
	
	public void findLeafSum(int var) {

		this.findLeafSum(var, this.root, "",1);

	}

	private void findLeafSum(int length, Node node, String osf,int curr) {

		// base condition

		if (node.data == length) {
			osf += node.data;
			System.out.println(osf);
			return;

		} 
		
		if (node.left != null) {

			findPath(length, node.left, osf + node.data);

		} 
		
		if (node.right != null) {

	//		osf += node.data;
			findPath(length, node.right, osf+node.data);

		}

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

	public BinaryTree(int[] pre, int in[]) {

		this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);

	}

	// isBalanced

	// isBST

	private class BSTPair {

		Boolean isBSTBool;
		int min, max;
		Node lbstRoot;
		
		//size of tree indicates the number of nodes in the tree
		int lbstSize;

	}

	public boolean isBST() {

		BSTPair res = this.isBST(this.root);
		System.out.print("Largest BST node is " + res.lbstRoot.data + "and size is "+res.lbstSize);
		return res.isBSTBool;
	}

	
	//prints the data of the largest bst pair
	private BSTPair isBST(Node node) {

		BSTPair myBST = new BSTPair();

		// basecase
		if (node == null) {

			myBST.min = Integer.MAX_VALUE;
			myBST.max = Integer.MIN_VALUE;
			myBST.isBSTBool = true;
			myBST.lbstSize = 0;

			return myBST;
		}

		BSTPair lp = isBST(node.left);
		BSTPair rp = isBST(node.right);

		myBST.min = Math.min(lp.min, Math.min(rp.min, node.data));
		myBST.max = Math.max(lp.max, Math.max(rp.max, node.data));

		if (node.data > lp.max && node.data < rp.min && lp.isBSTBool && rp.isBSTBool) {

			myBST.isBSTBool = true;

		} else
			myBST.isBSTBool = false;

		
		
		if (myBST.isBSTBool) {

			myBST.lbstRoot = node;
			
			//number of node in the tree is SIZE
			myBST.lbstSize = lp.lbstSize + rp.lbstSize + 1;

		} else {
			
			if (lp.lbstSize > rp.lbstSize) {

				myBST.lbstRoot = lp.lbstRoot;
				myBST.lbstSize = lp.lbstSize;

			} else {

				myBST.lbstRoot = rp.lbstRoot;
				myBST.lbstSize = rp.lbstSize;

			}

		}

		return myBST;
	}

	// print path for a node from the root node
	public void findPath(int var) {

		this.findPath(var, this.root, "");

	}

	private void findPath(int var, Node node, String osf) {

		// base condition

		if (node.data == var) {
			osf += node.data;
			System.out.println(osf);
			return;

		} 
		
		if (node.left != null) {

			findPath(var, node.left, osf + node.data);

		} 
		
		if (node.right != null) {

	//		osf += node.data;
			findPath(var, node.right, osf+node.data);

		}

	}

	// maximum diameter of BINARY TREE problem
	public int diameter() {

		return diameter(this.root).diameter;
	}

	public diaPair diameter(Node node) {

		diaPair myDia = new diaPair();

		if (node == null) {

			myDia.diameter = 0;
			myDia.height = -1;
			return myDia;
		}

		diaPair ld = diameter(node.left);
		diaPair rd = diameter(node.right);

		myDia.height = Math.max(ld.height, rd.height) + 1;

		int f1 = ld.height + rd.height + 2;
		int f2 = ld.diameter;
		int f3 = rd.diameter;

		myDia.diameter = Math.max(f1, Math.max(f2, f3));

		return myDia;
	}

	private class diaPair {

		int diameter;
		int height;

	}

	// making tree which has same preOrder and postOrder as given in input as
	// down below

	// making tree which has same preOrder and inOrder as given in input
	private Node construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {

		// base condition
		if (psi > pei)
			return null;

		int var = pre[psi];
		int si = -1;
		for (int i = isi; i <= iei; i++) {

			if (var == in[i]) {

				si = i;
				break;

			}

		}

		int cl = si - isi;

		Node node = new Node(pre[psi], this.construct(pre, psi + 1, psi + cl, in, isi, si - 1),
				this.construct(pre, psi + cl + 1, pei, in, si + 1, iei));

		return node;
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

	public void preOrder1() {

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

}
