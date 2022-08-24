import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static int N;
	private static boolean[][][] visited;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringBuilder sb = new StringBuilder();

	private static void bfs(int i, int j, char[][] arr, int mode) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		visited[i][j][mode] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny][mode])
					continue;

				if (arr[nx][ny] == arr[x][y]) {
					visited[nx][ny][mode] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		char[][] arr = new char[N][N];
		char[][] blindArr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				char cur = line.charAt(j);
				if (cur == 'G')
					blindArr[i][j] = 'R';
				else {
					arr[i][j] = cur;
					blindArr[i][j] = cur;
				}
			}
		}

		visited = new boolean[N][N][2];
		int normal = 0, blind = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j][0]) {
					bfs(i, j, arr, 0);
					normal++;
				}
				if (!visited[i][j][1]) {
					bfs(i, j, blindArr, 1);
					blind++;
				}
			}
		}

		sb.append(normal).append(" ").append(blind);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}