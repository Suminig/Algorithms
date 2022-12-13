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

	public static class Knight {
		int x, y, moved;

		public Knight(int x, int y, int moved) {
			this.x = x;
			this.y = y;
			this.moved = moved;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		boolean[][] visited = new boolean[N][N];
		int[] dx = { -2, -2, 0, 0, 2, 2 }, dy = { -1, 1, -2, 2, -1, 1 };

		st = new StringTokenizer(in.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		Queue<Knight> q = new ArrayDeque<>();
		q.offer(new Knight(r1, c1, 0));
		visited[r1][c1] = true;

		while (!q.isEmpty()) {
			Knight cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int moved = cur.moved;

			if (x == r2 && y == c2) {
				sb.append(moved);
				break;
			}

			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				q.offer(new Knight(nx, ny, moved + 1));
			}
		}

		if (!visited[r2][c2])
			sb.append(-1);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}