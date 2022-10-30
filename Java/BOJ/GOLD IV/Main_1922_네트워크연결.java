import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] parents;
	private static Edge[] edgeList;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}

	public static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		edgeList = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(A, B, C);
		}

		makeSet();
		Arrays.sort(edgeList);

		int sum = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				sum += edge.cost;

				if (++cnt == N - 1)
					break;
			}
		}

		sb.append(sum);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}