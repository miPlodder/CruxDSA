package DSA2;

public class TestClient {

	public static void reverse(QueueUsingLL qu) {

	}

	public static void reverse(StackUsingLL stack, StackUsingLL helper, int floor) throws Exception {

		if (stack.size() == 0)
			return;

		int storage = stack.pop();

		reverse(stack, helper, floor + 1);

		helper.push(storage);

		if (floor == 0) {

			while (!helper.isEmpty()) {

				stack.push(helper.pop());

			}

		}

	}

	public static boolean isBalanced(String str) {

		return true;
	}

	public static void main(String[] args) throws Exception {

		/*
		 * StackUsingQueue q = new StackUsingQueue();
		 * 
		 * q.push(11); q.push(21); q.push(31); q.push(41); q.display();
		 */

		StackUsingLL stack = new StackUsingLL();
		stack.push(1);
		stack.push(12);
		stack.push(13);
		stack.display();
		reverse(stack, new StackUsingLL(), 0);
		stack.display();

	}

}
