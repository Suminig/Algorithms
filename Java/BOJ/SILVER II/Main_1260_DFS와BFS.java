import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static Node[] tree;
	private static boolean[] visited;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Node {
		int num;
		ArrayList<Integer> list = new ArrayList<>();

		public Node(int num, ArrayList<Integer> list) {
			super();
			this.num = num;
			this.list = list;
		}

		public ArrayList<Integer> getList() {
			Collections.sort(list);
			return list;
		}
	}

	private static void dfs(int x) {
		sb.append(x).append(" ");
		visited[x] = true;

		for (Integer idx : tree[x].getList()) {
			if (!visited[idx])
				dfs(idx);
		}
	}

	private static void bfs(int x) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");

			for (Integer idx : tree[cur].getList()) {
				if (visited[idx])
					continue;

				visited[idx] = true;
				q.offer(idx);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		tree = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node(i, new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			tree[A].list.add(B);
			tree[B].list.add(A);
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}