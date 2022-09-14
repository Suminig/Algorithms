import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] parents;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void make() {
		parents = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
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

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		make();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (cmd == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}