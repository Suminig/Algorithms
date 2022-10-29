import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;

		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[F + 1];
		q.offer(new int[] { S, 0 });
		visited[S] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int floor = cur[0];
			int moved = cur[1];

			if (floor == G) {
				min = Math.min(moved, min);
			}

			if (floor + U <= F && !visited[floor + U]) {
				visited[floor + U] = true;
				q.offer(new int[] { floor + U, moved + 1 });
			}

			if (floor - D > 0 && !visited[floor - D]) {
				visited[floor - D] = true;
				q.offer(new int[] { floor - D, moved + 1 });
			}
		}

		sb.append(min == Integer.MAX_VALUE ? "use the stairs" : min);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}