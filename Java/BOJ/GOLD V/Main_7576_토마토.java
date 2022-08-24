import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<int[]> q = new ArrayDeque<>();

		st = new StringTokenizer(in.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					q.offer(new int[] { i, j });
			}
		}

		int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] != 0)
					continue;

				arr[nx][ny] = arr[x][y] + 1;
				q.offer(new int[] { nx, ny });
			}
		}

		int ans = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					ans = -1;
					flag = true;
					break;
				}
				ans = Math.max(ans, arr[i][j]);
			}
			if (flag)
				break;
		}

		sb.append(ans == -1 ? -1 : ans - 1);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}