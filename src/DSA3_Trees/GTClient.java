//height is levels - 1

package DSA3_Trees;

public class GTClient {

	public static void main(String[] args) {

		// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 1 100 0

		GenericTree t = new GenericTree();
		t.display();
		System.out.println(t.getsize()+" "+t.size2());
		System.out.println(t.find(120));
		System.out.println(t.height()+" MAX =>"+t.max());
	
		System.out.println(t.justLarger(-1));
		
		System.out.println(t.kthSmallest(5));
		
		//t.mirror();
		t.display();
		t.eulerPath();
		System.out.println("LEVEL ORDER STARTS");
		t.printAtLevel(4);
		System.out.println("LEVEL ORDER STARTS");
		t.preOrder();
		t.postOrder();
		t.display();
		//t.linearizeWT();
		t.display();
		System.out.println(t.maxSONC());
		System.out.println("*************************************");
		
		System.out.println(t.getRange());
		System.out.println(t.getRangeTD());
		//t.levelOrderIterative();
		
	}

}
