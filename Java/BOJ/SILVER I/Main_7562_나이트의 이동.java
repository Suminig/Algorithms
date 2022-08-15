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

	private static class Knight {
		int x, y, move;

		public Knight(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		int l, startX, startY, targetX, targetY, minMove;
		boolean[][] visited;
		int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 }, dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

		for (int tc = 0; tc < T; tc++) {
			l = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			targetX = Integer.parseInt(st.nextToken());
			targetY = Integer.parseInt(st.nextToken());

			minMove = Integer.MAX_VALUE;
			visited = new boolean[l][l];
			Queue<Knight> q = new ArrayDeque<>();
			q.offer(new Knight(startX, startY, 0));
			visited[startX][startY] = true;
			while (!q.isEmpty()) {
				Knight cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				int move = cur.move;

				if (x == targetX && y == targetY) {
					sb.append(move).append("\n");
					break;
				}

				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= l || ny < 0 || ny >= l)
						continue;

					if (visited[nx][ny] == false) {
						visited[nx][ny] = true;
						q.offer(new Knight(nx, ny, move + 1));
					}
				}
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}