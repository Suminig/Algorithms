import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, min, ans;
	private static ArrayList<Integer>[] edgeList;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void bfs(int x) {
		int cnt = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, x });
		visited[x] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int relation = cur[0];
			int num = cur[1];

			for (Integer next : edgeList[num]) {
				if (!visited[next]) {
					visited[next] = true;
					cnt += relation + 1;
					q.offer(new int[] { relation + 1, next });
				}
			}
		}

		if (cnt < min) {
			min = cnt;
			ans = x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edgeList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			edgeList[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			edgeList[A].add(B);
			edgeList[B].add(A);
		}

		min = Integer.MAX_VALUE;
		ans = 0;
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}