// collection duplicates can be there
// set duplicates are not there
// game's icon
// 2 lines initialization in java 
// Arrays Class
// prism
// djishtra's
// game

package graphDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.tools.Diagnostic;

import HeapDSGeneric.Heap;
import genericsHashMap.LinkedList;

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
				if (rv) {
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

	private class Pair {

		String vname;
		Vertex vtx;
		String psf;
		String color;

		public Pair(String vname, Vertex vtx, String psf) {

			this.vname = vname;
			this.vtx = vtx;
			this.psf = psf;

		}

		public Pair(String vname, Vertex vtx, String psf, String color) {

			this.vname = vname;
			this.vtx = vtx;
			this.psf = psf;
			this.color = color;

		}

	}

	public boolean hasPathBFS(String vname1, String vname2) throws Exception {

		// processing
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		queue.AddLast(new Pair(vname1, this.vertices.get(vname1), vname1));

		while (!queue.isEmpty()) {

			Pair rmV = queue.removeFirst();
			if (processed.containsKey(rmV.vname)) {
				// do nothing
			} else {

				processed.put(rmV.vname, true);
				if (this.containsEdge(vname2, rmV.vname)) {
					System.out.println(rmV.psf + vname2);
					return true;
				}

				Set<String> rmNghs = rmV.vtx.nbours.keySet();

				for (String rmNgh : rmNghs) {

					// check ---
					if (!processed.containsKey(rmNgh)) {
						queue.AddLast(new Pair(rmNgh, this.vertices.get(rmNgh), rmV.psf + rmNgh));
					}
				}

			}

		}

		return false;
	}

	public boolean hasPathDFSI(String vname1, String vname2) throws Exception {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		stack.AddFirst(new Pair(vname1, this.vertices.get(vname1), vname1));

		while (!stack.isEmpty()) {
			Pair rmV = stack.removeFirst();
			if (processed.containsKey(rmV.vname)) {
				// do nothing
			} else {

				processed.put(rmV.vname, true);
				if (this.containsEdge(vname2, rmV.vname)) {
					System.out.println(rmV.psf + vname2);
					return true;
				}
				Set<String> rmNghs = rmV.vtx.nbours.keySet();
				for (String rmNgh : rmNghs) {
					// check --- vertex
					if (!processed.containsKey(rmNgh))
						stack.AddFirst(new Pair(rmNgh, this.vertices.get(rmNgh), rmV.psf + rmNgh));
				}
			}
		}
		return false;
	}

	// level order traversal
	public void BFT() throws Exception {

		// processing
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		for (String vname : this.vertices.keySet()) {
			if (processed.containsKey(vname)) {
				continue;
			}
			queue.AddLast(new Pair(vname, this.vertices.get(vname), vname));

			while (!queue.isEmpty()) {

				Pair rmV = queue.removeFirst();

				if (processed.containsKey(rmV.vname)) {

					// do nothing

				} else {

					processed.put(rmV.vname, true);

					System.out.println(rmV.vname + "[" + rmV.psf + "]");

					Set<String> rmNghs = rmV.vtx.nbours.keySet();

					for (String rmNgh : rmNghs) {

						// check ---
						if (!processed.containsKey(rmNgh)) {
							queue.AddLast(new Pair(rmNgh, this.vertices.get(rmNgh), rmV.psf + rmNgh));
						}
					}

				}

			}
		}
	}

	// depth first traversal
	public void DFT() throws Exception {

		// processing
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		Set<String> nodes = this.vertices.keySet();

		for (String vname : nodes) {

			if (processed.containsKey(vname)) {

				continue;
			}

			stack.AddFirst(new Pair(vname, this.vertices.get(vname), vname));

			while (!stack.isEmpty()) {

				Pair rmV = stack.removeFirst();

				if (processed.containsKey(rmV.vname)) {

					// do nothing

				} else {

					processed.put(rmV.vname, true);

					System.out.println(rmV.vname + "[" + rmV.psf + "]");

					Set<String> rmNghs = rmV.vtx.nbours.keySet();

					for (String rmNgh : rmNghs) {

						// check --- vertex
						if (!processed.containsKey(rmNgh))
							stack.AddFirst(new Pair(rmNgh, this.vertices.get(rmNgh), rmV.psf + rmNgh));

					}

				}
			}
		}

	}

	// without counter
	public boolean isConnected() throws Exception {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		Set<String> nodes = this.vertices.keySet();
		Boolean firstTime = true;

		for (String vname : nodes) {

			if (processed.containsKey(vname)) {
				continue;
			}

			else {

				if (!firstTime) {
					return false;
				}

				firstTime = false;
				queue.AddLast(new Pair(vname, this.vertices.get(vname), vname));

				while (!queue.isEmpty()) {

					Pair rmV = queue.removeFirst();
					if (processed.containsKey(rmV.vname)) {
					} else {
						processed.put(rmV.vname, true);
						Set<String> rmNghs = rmV.vtx.nbours.keySet();
						for (String rmNgh : rmNghs) {
							if (!processed.containsKey(rmNgh)) {
								queue.AddLast(new Pair(rmNgh, this.vertices.get(rmNgh), rmV.psf + rmNgh));
							}
						}
					}
				}
			}
		}

		return true;

	}

	public boolean isAcyclic() throws Exception {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		for (String vname : this.vertices.keySet()) {

			// limits for loop
			if (processed.containsKey(vname)) {
				continue;
			}
			queue.AddLast(new Pair(vname, this.vertices.get(vname), vname));

			while (!queue.isEmpty()) {

				Pair rmV = queue.removeFirst();

				// if the removed variable is processed, quits
				if (processed.containsKey(rmV.vname)) {

					// do nothing
					return false;

				} else {

					processed.put(rmV.vname, true);

					System.out.println(rmV.vname + "[" + rmV.psf + "]");

					Set<String> rmNghs = rmV.vtx.nbours.keySet();

					for (String rmNgh : rmNghs) {

						// allows us not to add processed variables
						if (!processed.containsKey(rmNgh)) {
							queue.AddLast(new Pair(rmNgh, this.vertices.get(rmNgh), rmV.psf + rmNgh));
						}
					}

				}

			}
		}
		return true;
	}

	public boolean isTree() throws Exception {
		return (this.isAcyclic() == true) && (this.isConnected() == true);
	}

	public ArrayList<ArrayList<String>> gcc() throws Exception {

		// processing
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<ArrayList<String>> rv = new ArrayList<>();
		Set<String> nodes = this.vertices.keySet();

		for (String vname : nodes) {

			if (processed.containsKey(vname)) {
				continue;
			}
			stack.AddFirst(new Pair(vname, this.vertices.get(vname), vname));
			ArrayList<String> group = new ArrayList<>();
			while (!stack.isEmpty()) {
				Pair rmV = stack.removeFirst();
				if (processed.containsKey(rmV.vname)) {
					// do nothing
				} else {
					processed.put(rmV.vname, true);
					group.add(rmV.vname);
					Set<String> rmNghs = rmV.vtx.nbours.keySet();
					for (String rmNgh : rmNghs) {
						// check --- vertex
						if (!processed.containsKey(rmNgh))
							stack.AddFirst(new Pair(rmNgh, this.vertices.get(rmNgh), rmV.psf + rmNgh));
					}
				}
			}
			rv.add(group);
		}
		return rv;
	}

	public boolean isBipartite() throws Exception {

		HashMap<String, String> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Set<String> nodes = this.vertices.keySet();

		for (String vname : nodes) {

			if (processed.containsKey(vname)) {
				continue;
			}

			stack.AddFirst(new Pair(vname, this.vertices.get(vname), vname, "red"));

			while (!stack.isEmpty()) {
				Pair rmV = stack.removeFirst();

				if (processed.containsKey(rmV.vname)) {
					// do nothing
				} else {
					processed.put(rmV.vname, rmV.color);
					Set<String> rmNghs = rmV.vtx.nbours.keySet();
					for (String rmNgh : rmNghs) {

						String color = (rmV.color == "red") ? "green" : "red";

						if (!processed.containsKey(rmNgh)) {
							stack.AddFirst(new Pair(rmNgh, this.vertices.get(rmNgh), rmV.psf + rmNgh, color));
						} else {
							if (color.equals(processed.get(rmNgh))) {
								// ok
							} else {

								System.out.println(processed.toString());
								return false;
							}
						}
					}
				}
			}
		}
		System.out.println(processed.toString());
		return true;

	}

	class DjikstraPair implements Comparable<DjikstraPair> {

		String vname;
		String psf; // path so far
		int csf; // cost so far

		public DjikstraPair(String vname, String psf, int csf) {

			this.vname = vname;
			this.psf = psf;
			this.csf = csf;
		}

		// -----------------------------
		@Override
		public int compareTo(DjikstraPair o) {
			// TODO Auto-generated method stub
			return o.csf - this.csf;
		}

		public String toString() {
			return "[" + vname + "@" + psf + "@" + csf + "]";

		}

	}

	public HashMap<String, DjikstraPair> djikstra(String src) {

		HashMap<String, DjikstraPair> rv = new HashMap<>();
		Heap<DjikstraPair> heap = new Heap<>();

		Set<String> nodes = this.vertices.keySet();

		// copying to heap and hashmap
		for (String node : nodes) {

			if (node.equals(src)) {

				DjikstraPair newNode = new DjikstraPair(node, src, 0);
				heap.add(newNode);
				rv.put(node, newNode);

			} else {
				DjikstraPair newNode = new DjikstraPair(node, "", Integer.MAX_VALUE);
				heap.add(newNode);
				rv.put(node, newNode);
			}
		}

		while (!heap.isEmpty()) {

			DjikstraPair rmPair = heap.removeHP();

			Vertex rmV = this.vertices.get(rmPair.vname);

			Set<String> Nbours = rmV.nbours.keySet();

			for (String Nbour : Nbours) {

				DjikstraPair nbourPair = rv.get(Nbour);

				int nCost = rmPair.csf + rmV.nbours.get(Nbour);
				int oCost = nbourPair.csf;

				if (nCost < oCost) {

					nbourPair.csf = nCost;
					nbourPair.psf = rmPair.psf + Nbour;

					heap.handleUpdatePriority(nbourPair);
				}

			}

		}

		return rv;
	}

}
