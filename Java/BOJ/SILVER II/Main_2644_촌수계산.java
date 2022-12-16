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

		int N = Integer.parseInt(in.readLine());
		boolean[][] matrix = new boolean[N + 1][N + 1];

		st = new StringTokenizer(in.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			matrix[x][y] = true;
			matrix[y][x] = true;
		}

		int res = -1;

		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(new int[] { from, 0 });
		visited[from] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int num = cur[0];
			int chonsu = cur[1];

			if (num == to) {
				res = chonsu;
				break;
			}

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && matrix[num][i]) {
					visited[i] = true;
					q.offer(new int[] { i, chonsu + 1 });
				}
			}
		}

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}