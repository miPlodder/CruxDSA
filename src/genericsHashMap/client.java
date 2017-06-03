//TODO

package genericsHashMap;

/*
 * Documentation Comments
 */

public class client {

	// including bounds in Generics
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			int count = 0;

			while (count < arr.length - i - 1) {

				// if (arr[count] > arr[count + 1]) {
				if (arr[count].compareTo(arr[count + 1]) > 0) {
					T temp = arr[count];
					arr[count] = arr[count + 1];
					arr[count + 1] = temp;
				}
				count++;
			}
		}
	}

	private static class Cars implements Comparable<Cars> {

		String name;
		Integer price;
		Integer speed;

		public Cars(String name, Integer speed, Integer price) {

			this.name = name;
			this.price = price;
			this.speed = speed;

		}

		@Override
		public int compareTo(Cars arg0) {

			// TODO Auto-generated method stub

			// ?----------------------------------------------------------------------------string
			// passing problem
			System.out.println(arg0.hashCode() + ", " + arg0.name.hashCode() + ", " + arg0.price.hashCode() + ", "
					+ arg0.speed.hashCode());

			return this.speed - arg0.speed;

		}

		// this method is used in displaying the 3 Attributes
		public String toString() {

			String rv = "";
			rv += "{ " + this.name + " @P (" + this.price + ") @S (" + this.speed + ") }";
			return rv;

		}

	}

	public static void main(String[] args) {

		Integer[] arr = { 11, 2, 4, 1, 7, 5, 6 };
		String[] strArr = { "the", "a", "sak", "xyz" };
		bubbleSort(strArr);
		display(strArr);

		Cars[] car = new Cars[5];

		car[0] = new Cars("b", 100, 10000);
		car[1] = new Cars("a", 300, 6000);
		car[2] = new Cars("d", 600, 3000);
		car[3] = new Cars("c", 200, 50000);
		car[4] = new Cars("e", 500, 2000);

		System.out.println();
		display(car);
		bubbleSort(car);
		System.out.println();
		display(car);

	}

	public static <T> void display(T[] arr) {

		for (T val : arr) {
			System.out.println(val.toString() + ",");
		}

		// ?-------------------------------------------------------------------println
		// inner class problem
		System.out.println();

	}

}

// Interface Comparable has only one function
// -------------------------------------------------------------comparable
/*
 * Inside Generics, we use extends for Interface function
 */

// ?-------------------------generics primitive datatypes not use
// ?------------------------add F3 in eclipse