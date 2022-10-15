import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, max, maxValue;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static int[][] arr;
	private static boolean[][] visited;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void dfs(int cnt, int x, int y, int sum) {
		if (max >= sum + maxValue * (3 - cnt))
			return;

		if (cnt == 3) {
			max = max < sum ? sum : max;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
				continue;

			if (cnt == 1) {
				visited[nx][ny] = true;
				dfs(cnt + 1, x, y, sum + arr[nx][ny]);
				visited[nx][ny] = false;
			}

			visited[nx][ny] = true;
			dfs(cnt + 1, nx, ny, sum + arr[nx][ny]);
			visited[nx][ny] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		maxValue = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxValue = maxValue < arr[i][j] ? arr[i][j] : maxValue;
			}
		}

		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(0, i, j, arr[i][j]);
				visited[i][j] = false;
			}
		}

		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}