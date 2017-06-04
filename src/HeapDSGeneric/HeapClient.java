package HeapDSGeneric;

import java.util.ArrayList;

public class HeapClient {

	public static void main(String[] args) {

		// o.new problem

		Student[] std = new Student[7];

		std[0] = new Student("A", 1000, 10);

		std[1] = new Student("B", 900, 90);

		std[2] = new Student("C", 800, 1000);

		std[3] = new Student("D", 700, 1100);

		std[4] = new Student("E", 1350, 5);

		std[5] = new Student("F", 200, 1200);
		
		std[6] = new Student("G", 100, 2000);
		
		Heap<Student> heap = new Heap<>(std);

		heap.display();
		
		System.out.println(heap.removeHP());
		
		heap.display();
		
		
		//System.out.println(heap.getHP());
		//System.out.println(heap.removeHP());
		
		//heap.display();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		std[5].modifyData(2000, 1);
		System.out.println(std[5]);
		
		heap.handleUpdatePriority(std[5]);
		heap.display();
		
		//Heap<ArrayList<Integer>> heaps = new Heap<>();
		
		
		// s5.modifyData(1000, 1);
		// heap.updatePriority(s5);

		// System.out.println(heap.getHP());
		// System.out.println(heap.removeHP());

	}
	
	
	

	public static class Student implements Comparable<Student> {

		String name;
		int mark;
		int rank;

		public Student(String name, int mark, int rank) {

			this.name = name;
			this.mark = mark;
			this.rank = rank;

		}

		// ?--------------
		public String toString() {

			return "(" + this.name + "@" + this.mark + "@" + this.rank + ")";

		}

		@Override
		public int compareTo(Student o) {

			return o.rank - this.rank;
		}

		public void modifyData(int mark, int rank) {

			this.mark = mark;
			this.rank = rank;

		}

	}
}
