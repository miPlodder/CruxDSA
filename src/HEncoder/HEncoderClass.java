package HEncoder;

import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Set;

import DataStructure.Queue.Queue;
import HeapDSGeneric.Heap;

//heap is priority queue

public class HEncoderClass {

	HashMap<Character, String> encoder = new HashMap<>();
	HashMap<String, Character> decoder = new HashMap<>();

	public HEncoderClass(String text) {

		HashMap<Character, Integer> fm = new HashMap<>();
		Heap<Node> pQueue = new Heap<>();

		// Make frequency map
		for (int i = 0; i < text.length(); i++) {

			Character ch = text.charAt(i);

			if (fm.containsKey(ch)) {

				int ov = fm.get(ch);

				fm.put(ch, ov + 1);

			} else {

				fm.put(ch, 1);

			}

		}
		// add fm into heap
		Set<Character> keys = fm.keySet();

		for (Character key : keys) {

			Node node = new Node(key, fm.get(key));
			pQueue.add(node);

		}

		Node root = pQueue.getHP();

		// make priority queue(heap) and make binary tree
		while (pQueue.size() != 1) {

			Node one = pQueue.removeHP();
			Node two = pQueue.removeHP();

			Node merge = new Node('\0', one.freq + one.freq);
			merge.left = one;
			merge.right = two;

			pQueue.add(merge);
		}

		Node finalremoved = pQueue.removeHP();

		// start filling
		this.fillEncoderDecoder(finalremoved, "");

	}

	private void fillEncoderDecoder(Node node, String osf) {

		if (node == null)
			return;

		if (node.left == null && node.right == null) {

			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);

			return;
		}

		this.fillEncoderDecoder(node.left, osf + "0");
		this.fillEncoderDecoder(node.right, osf + "1");

	}

	public String encodeData(String str) {

		String rv = "";

		for (int i = 0; i < str.length(); i++) {

			Character ch = str.charAt(i);
			rv += this.encoder.get(ch);

		}

		return rv;
	}

	public String decodeData(String str) {

		String rv = "";

		String chars = "";
		for (int i = 0; i < str.length(); i++) {

			Character ch = str.charAt(i);
			chars += ch;
			if (this.decoder.containsKey(chars)) {

				rv += this.decoder.get(chars);
				chars = "";

			}

		}

		return rv;

	}

	private class Node implements Comparable<Node> {

		Character data;
		int freq;
		Node left;
		Node right;

		public Node(Character data, int freq) {

			this.data = data;
			this.freq = freq;

		}

		@Override
		public int compareTo(Node o) {

			return o.freq - this.freq;
		}

	}

}
