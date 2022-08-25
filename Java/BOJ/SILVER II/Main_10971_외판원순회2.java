import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int V, minDist;
	private static boolean[] visited;
	private static int[][] adjMatrix;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void dfs(int cur, int start, int cnt, int sum) {
		if (cnt == V) {
			if (adjMatrix[cur][start] == 0)
				return;
			sum += adjMatrix[cur][start];
			minDist = Math.min(minDist, sum);
			return;
		}

		if (sum > minDist)
			return;

		for (int i = 0; i < V; i++) {
			if (visited[i] || adjMatrix[cur][i] == 0)
				continue;
			visited[i] = true;
			dfs(i, start, cnt + 1, sum + adjMatrix[cur][i]);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		V = Integer.parseInt(in.readLine());
		adjMatrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minDist = Integer.MAX_VALUE;

		visited = new boolean[V];
		visited[0] = true;
		dfs(0, 0, 1, 0);

		sb.append(minDist);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}