import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Node {
		int num;
		ArrayList<Integer> connected = new ArrayList<>();

		public Node(int num) {
			this.num = num;
		}

		public void add(int x) {
			connected.add(x);
		}

		public ArrayList<Integer> getList() {
			return connected;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		Node[] tree = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node(i);
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			tree[A].add(B);
			tree[B].add(A);
		}

		int[] visited = new int[N + 1];
		Deque<Node> q = new ArrayDeque<>();
		q.add(tree[1]);
		visited[1] = 1;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (Integer x : cur.getList()) {
				if (visited[x] == 0) {
					visited[x] = cur.num;
					q.add(tree[x]);
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}