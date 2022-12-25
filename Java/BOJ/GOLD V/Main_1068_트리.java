import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, root, delete, res;
	private static int[] parent;
	private static boolean[] visited;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void deleteNode(int node) {
		parent[node] = -2;
		for (int i = 0; i < N; i++) {
			if (parent[i] == node) {
				deleteNode(i);
			}
		}
	}

	public static void countLeaf(int node) {
		int cnt = 0;
		visited[node] = true;

		if (parent[node] != -2) {
			for (int i = 0; i < N; i++) {
				if (parent[i] == node && !visited[i]) {
					countLeaf(i);
					cnt++;
				}
			}

			if (cnt == 0) {
				res++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		root = 0;
		parent = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());

			if (parent[i] == -1)
				root = i;
		}

		delete = Integer.parseInt(in.readLine());
		res = 0;
		visited = new boolean[N];

		deleteNode(delete);
		countLeaf(root);

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}