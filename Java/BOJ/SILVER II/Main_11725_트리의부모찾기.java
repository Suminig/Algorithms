import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adjList[A].add(B);
			adjList[B].add(A);
		}

		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[N + 1];
		q.offer(1);
		visited[1] = -1;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : adjList[cur]) {
				if (visited[next] == 0) {
					visited[next] = cur;
					q.offer(next);
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}