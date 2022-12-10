import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int[] visited;
	private static ArrayList<Integer>[] adjList;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void dfs(int x, int team) {
		visited[x] = team;
		for (int next : adjList[x]) {
			if (visited[next] == 0)
				dfs(next, 3 - team);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			adjList = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				adjList[A].add(B);
				adjList[B].add(A);
			}

			// 방문 체크 - 0 : 미방문 / 1 : A팀 / 2 : B팀
			visited = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0)
					dfs(i, 1);
			}

			boolean flag = true;
			for (int i = 1; i <= V; i++) {
				for (int next : adjList[i]) {
					if (visited[i] == visited[next])
						flag = false;
				}
			}

			sb.append(flag ? "YES" : "NO").append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}