package genericsHashMap;

import java.util.ArrayList;

public class hashMap<K, V> {

	private int size;
	private LinkedList<HTNode>[] bucketArray;

	private class HTNode {

		K key;
		V value;

		public HTNode(K key, V value) {

			this.key = key;
			this.value = value;
		}

		public String toString() {

			// used in display
			return "( " + this.key + ", " + this.value + " )";

		}
	}

	public hashMap(int capacity) {

		// -------------------------------------------------
		this.bucketArray = (LinkedList<HTNode>[]) new LinkedList[capacity];
		for (int i = 0; i < capacity; i++) {

			this.bucketArray[i] = new LinkedList<>();

		}

	}

	// ?---------------problem
	public void put(K key, V value) throws Exception {

		int index = hashFunction(key);

		int val = findInBucket(index, key);

		if (val == -1) {

			HTNode htnode = new HTNode(key, value);
			this.bucketArray[index].AddLast(htnode);
			this.size++;

		} else {

			this.bucketArray[index].getAt(val).value = value;

		}

		// TODO --------------------------------------------------
		double check = (this.size * 1.0) / this.bucketArray.length;

		if (check > 2) {

			this.rehashing();

		}

	}

	public V remove(K key) throws Exception {

		int index = hashFunction(key);
		int val = findInBucket(index, key);

		if (val == -1) {

			return null;

		} else {

			V value = this.bucketArray[index].getAt(val).value;
			this.size--;
			this.bucketArray[index].removeAt(val);
			return value;
		}

	}

	public V get(K key) throws Exception {

		int index = hashFunction(key);

		int val = findInBucket(index, key);

		if (val == -1) {

			return null;

		} else {

			return this.bucketArray[index].getAt(val).value;

		}

	}

	public boolean containsKey(K key) throws Exception {

		int index = hashFunction(key);

		int val = findInBucket(index, key);

		if (val == -1) {

			return true;

		} else {

			return false;

		}

	}

	public boolean isEmpty() {

		return (this.size == 0);

	}

	public int getSize() {

		return this.size;
	}

	public ArrayList<K> keySet() throws Exception {

		ArrayList<K> al = new ArrayList<>();

		// ioa - index of array
		// posInBucket
		for (int ioa = 0; ioa < this.bucketArray.length; ioa++) {

			for (int posInBucket = 0; posInBucket < this.bucketArray[ioa].getSize(); posInBucket++) {

				al.add(this.bucketArray[ioa].getAt(posInBucket).key);

			}

		}

		return al;
	}

	public void display() throws Exception {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		for (int ioa = 0; ioa < this.bucketArray.length; ioa++) {

			for (int posInBucket = 0; posInBucket < this.bucketArray[ioa].getSize(); posInBucket++) {

				System.out.println(ioa + "->" + this.bucketArray[ioa].getAt(posInBucket).toString());

			}

		}

	}

	private int hashFunction(K key) {

		int hashCode = key.hashCode();

		int rv = (hashCode % this.bucketArray.length);

		return rv;
	}

	private void rehashing() throws Exception {

		// old bucket array - ola

		LinkedList<HTNode>[] oba = this.bucketArray;

		this.bucketArray = (LinkedList<HTNode>[]) new LinkedList[2 * oba.length];
		
		for (int i = 0; i < this.bucketArray.length; i++) {

			this.bucketArray[i] = new LinkedList<>();

		}
		this.size = 0;

		for (int i = 0; i < oba.length; i++) {

			for (int j = 0; j < oba[i].getSize(); j++) {

				this.put(oba[i].getAt(j).key, oba[i].getAt(j).value);

			}

		}

	}

	private int findInBucket(int index, K key) throws Exception {

		for (int i = 0; i < this.bucketArray[index].getSize(); i++) {

			if (this.bucketArray[index].getAt(i).key.equals(key)) {

				return i;

			}

		}

		return -1;

	}

}
