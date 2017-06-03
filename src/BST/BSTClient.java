package BST;

public class BSTClient {
	
	
	public static void main(String[] args){
		
		int[] arr = {12,25,30,37,40,50,60,62,70,75,87};
		BSTClass bst = new BSTClass(12,25,30,37,40,50,60,62,70,75,87);
		System.out.println(bst.getSize());
		bst.display();
		System.out.println(bst.min());
		System.out.println(bst.max());
		bst.printInRange(51, 70);
		System.out.println();
		bst.printInOrder();
		System.out.println();
		//iteratively 
		bst.printLevelOrderI();
		System.out.println();
		//recursively 
		bst.printLevelOrder();
		//insertion of BST
		System.out.println();
		System.out.println("inserted node");
		bst.insertNode(72);
		bst.display();
		
		System.out.println("\nRemoving Node\n");
		bst.removeNode(50);
		bst.display();
		
		bst.printKFar(70, 2);
		
	}

}
