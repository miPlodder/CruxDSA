package DSA3_Trees;


// 	50 true 25 true 12 false false true 37 false false true 75 true 62 false false true 87 false false
public class BinaryTreeClient {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.display();
		System.out.println(bt.getSize());
		System.out.println(bt.size2());
		
		System.out.println(bt.min());
		System.out.println(bt.find(62));
		System.out.println(bt.height());
		bt.preOrder();
		bt.postOrder();
		bt.InOrder();
		bt.levelOrder();
		bt.preOrderIterative();
	}

}
