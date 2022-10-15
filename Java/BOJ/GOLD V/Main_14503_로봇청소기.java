import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, cnt;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int getDir(int dir) {
		if (dir == 0)
			return 3;
		else if (dir == 1)
			return 0;
		else if (dir == 2)
			return 1;
		else
			return 2;
	}

	public static boolean cleanable(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];

		if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 1)
			return false;

		return true;
	}

	public static void clean(int x, int y, int d) {
		if (!visited[x][y]) {
			visited[x][y] = true;
			cnt++;
		}

		int temp = 0;
		int nd = d;
		boolean goBack = false;

		while (true) {
			nd = getDir(nd);

			if (temp++ >= 4) {
				goBack = true;
				break;
			}

			if (cleanable(x, y, nd)) {
				int nx = x + dx[nd];
				int ny = y + dy[nd];

				clean(nx, ny, nd);
				break;
			}
		}

		if (goBack) {
			int nx = x - dx[d];
			int ny = y - dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 1)
				return;

			if (arr[nx][ny] == 0)
				clean(nx, ny, d);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0;
		clean(x, y, dir);
		sb.append(cnt);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}