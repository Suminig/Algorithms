import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] parents;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Star {
		int num;
		double x, y;

		public Star(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	public static class Edge implements Comparable<Edge> {
		int from, to;
		double dist;

		public Edge(int from, int to, double dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge e) {
			return (int) (this.dist - e.dist);
		}
	}

	public static double dist(Star e1, Star e2) {
		double x = Math.abs(e2.x - e1.x);
		double y = Math.abs(e2.y - e1.y);
		double pythagoras = Math.pow(x, 2) + Math.pow(y, 2);

		return Math.sqrt(pythagoras);
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
		Star[] stars = new Star[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			stars[i] = new Star(i, x, y);
		}

		ArrayList<Edge> edgeList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				edgeList.add(new Edge(i, j, dist(stars[i], stars[j])));
			}
		}

		makeSet();
		Collections.sort(edgeList);

		double sum = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				sum += edge.dist;

				if (++cnt == N - 1)
					break;
			}
		}

		sb.append(String.format("%.2f", sum));

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}