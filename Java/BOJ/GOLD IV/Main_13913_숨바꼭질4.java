import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] visited = new int[100_001];
		int[] parent = new int[100_001];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(N);
		visited[N] = 1;
		int minTime = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == K) {
				break;
			}

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0)
					next = cur * 2;
				else if (i == 1)
					next = cur - 1;
				else
					next = cur + 1;

				if (next < 0 || next > 100_000)
					continue;

				if (visited[next] == 0) {
					visited[next] = visited[cur] + 1;
					parent[next] = cur;
					q.offer(next);
				}
			}
		}

		sb.append(visited[K] - 1).append("\n");

		Stack<Integer> path = new Stack<>();
		path.push(K);

		while (K != N) {
			path.push(parent[K]);
			K = parent[K];
		}

		while (!path.isEmpty()) {
			sb.append(path.pop()).append(" ");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}