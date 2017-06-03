package DataStructure.Stack;

public class stackClient {

	public static void main(String[] args) throws Exception {

		Stack st = new Stack(6);

		for (int i = 0; i < 6; i++) {
			st.push(i);
			Display(st);
		}

		while (!st.isEmpty()) {
			System.out.println(st.pop());
			Display(st);
		}

		System.out.println(st.size());
		// System.out.println(st.top());
		System.out.println(st.isEmpty());

	}

	public static void Display(Stack st) throws Exception{

		System.out.println(st.size());
		System.out.println(st.top());
		System.out.println("**********************************");

	}

}
