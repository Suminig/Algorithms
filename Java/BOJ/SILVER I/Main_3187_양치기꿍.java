import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, v, k, wolf, lamb;
	private static char[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			if (arr[x][y] == '#')
				continue;
			else if (arr[x][y] == 'v')
				v++;
			else if (arr[x][y] == 'k')
				k++;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
			}
		}

		if (v >= k)
			wolf += v;
		else
			lamb += k;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		visited = new boolean[R][C];
		lamb = wolf = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j]) {
					v = k = 0;
					bfs(i, j);
				}
			}
		}

		sb.append(lamb).append(" ").append(wolf);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}