import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static HashMap<Character, Node> tree;
	private static StringBuilder sb = new StringBuilder();

	public static class Node {
		char val, left, right;

		public Node(char val, char left, char right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void preorder(char cur) {
		Node node = tree.get(cur);
		sb.append(node.val);
		if (node.left != '.') {
			preorder(node.left);
		}
		if (node.right != '.') {
			preorder(node.right);
		}
	}

	public static void inorder(char cur) {
		Node node = tree.get(cur);
		if (node.left != '.') {
			inorder(node.left);
		}
		sb.append(node.val);
		if (node.right != '.') {
			inorder(node.right);
		}
	}

	public static void postorder(char cur) {
		Node node = tree.get(cur);
		if (node.left != '.') {
			postorder(node.left);
		}
		if (node.right != '.') {
			postorder(node.right);
		}
		sb.append(node.val);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		tree = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			char val = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			tree.put(val, new Node(val, left, right));
		}

		preorder('A');
		sb.append("\n");
		inorder('A');
		sb.append("\n");
		postorder('A');

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}