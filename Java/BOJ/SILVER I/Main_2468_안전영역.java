import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, maxHeight, max;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void bfs(int i, int j, int height) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;

				if (arr[nx][ny] > height) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		maxHeight = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, arr[i][j]);
			}
		}

		for (int k = 0; k < maxHeight; k++) {
			int cnt = 0;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > k && !visited[i][j]) {
						bfs(i, j, k);
						cnt++;
					}
				}
			}

			max = Math.max(max, cnt);
		}

		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}