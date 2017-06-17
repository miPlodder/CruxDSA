package graphDS;

public class GraphClient {

	//final String name ;
	
	public static void main(String[] args) throws Exception {

		Graph graph = new Graph();
		
		//final String name ;
		//name = "saksham";

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 40);
		graph.addEdge("B", "C", 10);
		graph.addEdge("C", "D", 10);
		graph.addEdge("D", "E", 2);
		graph.addEdge("E", "F", 3);
		graph.addEdge("E", "G", 8);
		graph.addEdge("F", "G", 3);

		graph.display();
//		graph.removeEdge("D", "E");
		// graph.display();
		// graph.removeVertex("E");
		// graph.display();

		// System.out.println(graph.hasPath("D", "A"));
		// System.out.println(graph.hasPathBFS("A", "G"));
		// System.out.println(graph.hasPathDFSI("A", "G"));
		// graph.BFT();
		// System.out.println();

		// graph.DFT();
		System.out.println(graph.isConnected());

		System.out.println(graph.isAcyclic());
		System.out.println(graph.gcc());
		System.out.println(graph.isBipartite());

		System.out.println(graph.djikstra("A"));
	}
}
