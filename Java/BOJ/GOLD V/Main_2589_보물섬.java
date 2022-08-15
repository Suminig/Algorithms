import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static char[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Land {
		int x, y, move;

		public Land(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}

	private static int bfs(Land land) {
		int cnt = 0;
		visited = new boolean[N][M];
		Deque<Land> q = new ArrayDeque<>();
		q.offer(land);
		visited[land.x][land.y] = true;
		while (!q.isEmpty()) {
			Land cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int move = cur.move;

			cnt = Math.max(cnt, move);

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (arr[nx][ny] == 'L' && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					q.offer(new Land(nx, ny, move + 1));
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
		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line[j];
			}
		}

		int maxMoved = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'L')
					maxMoved = Math.max(maxMoved, bfs(new Land(i, j, 0)));
			}
		}

		sb.append(maxMoved);
			
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}