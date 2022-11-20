import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static int[][] arr;
	private static boolean[][] visited;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void melt() {
		int[][] temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] > 0) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] > 0)
							continue;

						temp[i][j]++;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = arr[i][j] - temp[i][j] < 0 ? 0 : arr[i][j] - temp[i][j];
			}
		}
	}

	public static void bfsCheck(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;

				if (arr[nx][ny] != 0) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static int check() {
		int cnt = 0;
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] > 0 && !visited[i][j]) {
					bfsCheck(i, j);
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		while (true) {
			ans++;
			melt();

			int cnt = check();
			if (cnt == 0) {
				ans = 0;
				break;
			} else if (cnt >= 2) {
				break;
			}
		}

		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}