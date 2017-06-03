//this.tail.next = newNode;


package DSA2;

import genericsHashMap.LinkedList;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {

		LinkedList ll = new LinkedList();

		System.out.println(ll.isEmpty() + " " + ll.getSize());


		ll.AddFirst(1);
		ll.display();

		ll.AddFirst(2);
		ll.display();
		
		ll.AddLast(3);
		ll.display();

		System.out.println(ll.isEmpty() + " " + ll.getSize());

		ll.AddFirst(3);
		ll.display();

		ll.AddLast(4);
		ll.display();

		ll.AddLast(5);
		ll.display();

		ll.AddInBetween(6, 1);
		ll.display();

//		System.out.println(ll.isEmpty() + " " + ll.getSize());

	//	ll.AddInBetween(7, 1);
		//ll.display();
		
		//ll.AddInBetween(6, 1);
		ll.display();
		ll.reversePI();
		ll.display();
		
		ll.reverseSupport();
		ll.display();
		//System.out.println(ll.getFirst());
		System.out.println(ll.mid());
		
		ll.mergeSort();
		ll.display();
		
		
		//	System.out.println(ll.getAt(7));
/*		

		System.out.println(ll.removeFirst());
		System.out.println(ll.removeLast());
		ll.display();
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeLast());
		ll.display();
	
		System.out.println(ll.removeAt(1));
		System.out.println(ll.removeAt(1));
		System.out.println(ll.removeLast());
		ll.display();
	
	}
*/
		System.out.println(ll.find(6));
		
		
	}
}
