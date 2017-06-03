package HeapDSGeneric;

public class HeapClient {

	public static void main(String[] args) {

		//o.new problem
		Heap<Student> heap = new Heap<>();
		
		Student s1 = new Student("A", 600, 60);
		heap.add(s1);

		Student s2 = new Student("B", 500, 50);
		heap.add(s2);
		
		Student s3 = new Student("C", 300, 40);
		heap.add(s3);

		Student s4 = new Student("D", 300, 30);
		heap.add(s4);
		
		
		heap.display();
		
		//System.out.println(heap.removeHP());
		
		
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

		
		//?--------------
		public String toString() {

			return "(" + this.name + "@" + this.mark + "@" + this.rank + ")";

		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.rank-o.rank;
		}

	}
}
