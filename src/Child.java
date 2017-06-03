class Parent {

	int data = 5;

	public void FunP() {

		System.out.println("Parent Fun");

	}

	public void Fun() {

		System.out.println("Parent FunOverriden One");

	}

}

public class Child extends Parent {

	int data = 10;

	public void FunC() {

		System.out.println("Child Fun");

	}

	public void Fun() {

		System.out.println("Child FunOverriden One");

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Parent p = new Child();
		// Child c = p;
		p.Fun();
		p.FunP();
		// p.FunC(); bcoz Compiler Thinks p can access Only p variables and
		// functions

		// preference is given to Reference Variable data
		System.out.println(p.data);
		System.out.println(p.data);

		System.out.println("**********************************");

		// //Problem in TYPECASTING
		// Child c = Child(p);

		((Child) p).FunC();
		((Child) p).Fun();
		((Child) p).FunP();

	}
}
