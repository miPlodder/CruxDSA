//collection duplicates can be there
//set duplicates are not there

package graphDS;

import java.util.HashMap;
import java.util.Set;

public class Graph {

	HashMap<String, Vertex> vertices = new HashMap<>();

	public class Vertex {

		HashMap<String, Integer> nbours = new HashMap<>();

	}

	// vertices functions

	public int numVertex() {

		return this.vertices.size();

	}

	public void addVertex(String vname) {

		if (this.vertices.containsKey(vname)) {
			return;
		}

		Vertex v = new Vertex();
		this.vertices.put(vname, v);

	}

	public void removeVertex(String vname) {

		if (!this.vertices.containsKey(vname)) {
			return;
		}

		Vertex v = this.vertices.get(vname);
		Set<String> nbrV = v.nbours.keySet();

		for (String val : nbrV) {

			this.vertices.get(val).nbours.remove(vname);
		}

		this.vertices.remove(vname);

	}

	public boolean containsVertex(String vname) {

		return this.vertices.containsKey(vname);

	}

	// edges functions

	public int numEdge() {

		int rv = 0;

		Set<String> vertex = this.vertices.keySet();

		for (String val : vertex) {

			rv += this.vertices.get(val).nbours.size();

		}

		rv /= 2;

		return rv;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);

		if (v1 == null || v2 == null) {

			return false;

		}

		if (v1.nbours.containsKey(vname2)) {
			return true;
		}

		return false;

	}

	public void addEdge(String vname1, String vname2, int weight) {

		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);

		if (v1 == null || v2 == null) {

			return;

		}

		v1.nbours.put(vname2, weight);
		v2.nbours.put(vname1, weight);

	}

	public void removeEdge(String vname1, String vname2) {

		Vertex v1 = this.vertices.get(vname1);
		Vertex v2 = this.vertices.get(vname2);

		// both vertex are present
		if (v1 == null || v2 == null) {

			return;

		}

		// edge present

		v1.nbours.remove(vname2);
		v2.nbours.remove(vname1);

	}

	public void display() {

		System.err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		Set<String> keys = this.vertices.keySet();

		for (String key : keys) {

			String str = "";
			str += key + "-> ";

			Set<String> keysV = this.vertices.get(key).nbours.keySet();
			for (String val : keysV) {

				str += val + " ( " + this.vertices.get(key).nbours.get(val) + " ), ";

			}

			str += "END";
			System.out.println(str);

		}

		System.err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	public boolean hasPath(String vname1, String vname2) {

		HashMap<String, Boolean> processed = new HashMap<>();
		return this.hasPathDFS(vname1, vname2, processed);

	}

	// depth first search
	private boolean hasPathDFS(String vname1, String vname2, HashMap<String, Boolean> processed) {

		boolean rv = false;

		if (processed.containsKey(vname1)) {

			return false;

		}

		processed.put(vname1, true);

		if (this.containsEdge(vname1, vname2)) {
			rv = true;

		} else {

			Set<String> vertex = this.vertices.get(vname1).nbours.keySet();
			for (String val : vertex) {

				rv = this.hasPathDFS(val, vname2, processed);
				if(rv){
					return true;
				}

			}

		}

		return rv;
	}

	// print the DFS Path
	public String printDFS(String vname1, String vname2, HashMap<String, Boolean> processed, String osf) {

		boolean rv = false;

		if (processed.get(vname1)) {

			// return false;

		}

		processed.put(vname1, true);

		if (this.containsEdge(vname1, vname2)) {
			rv = true;

		} else {

			Set<String> vertex = this.vertices.get("vname1").nbours.keySet();
			for (String val : vertex) {

				rv = this.hasPathDFS(val, vname2, processed);

			}

		}

		return osf;
	}

}