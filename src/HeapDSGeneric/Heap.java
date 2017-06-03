package HeapDSGeneric;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

	ArrayList<T> list;
	
	public Heap() {

		list = new ArrayList<>();
		

	}

	public int size() {

		return this.list.size();

	}

	public void display() {

		System.out.println(list);

	}

	public boolean isEmpty() {

		return (this.list.size() == 0);

	}

	//get HighestPriority
	public T getHP() {

		return this.list.get(0);
	}

	public T removeHP() {

		T root = this.list.get(0);

		// first swap then remove
		this.swap(0, this.list.size() - 1);
		this.list.remove(this.list.size() - 1);
		this.downHeapify(0);
		

		return root;
	}

	// downheapify
	private void downHeapify(int pi) {

		//left child index
		int lci = (2 * pi) + 1;
		//right child index
		int rci = lci + 1;

		int maxI = pi;

		if (lci < this.list.size() && this.list.get(lci).compareTo(this.list.get(maxI)) > 0) {

			maxI = lci;

		}

		if (rci < this.list.size() && this.list.get(rci).compareTo(this.list.get(maxI)) > 0) {

			maxI = rci;

		}

		if (maxI != pi) {

			this.swap(maxI, pi);
			this.downHeapify(maxI);

		}

	}

	public void add(T data) {

		this.list.add(data);
		
		this.upHeapify(list.size() - 1);
	
	}

	// upheapify
	// ci - child index
	private void upHeapify(int ci) {

		if (ci == 0)
			return;

		int pi = (ci - 1) / 2;

		if (this.list.get(ci).compareTo(this.list.get(pi)) < 0) {

			this.swap(ci, pi);
			this.upHeapify(pi);

		} else {
			// do nothing
		}

	}

	// swapping -------------------------------------------------------------------problem
	private void swap(int i, int j) {

		T ith = list.get(i);
		T jth = list.get(j);
		
		list.add(i, jth);
		list.add(j, ith);

	}
	
}
