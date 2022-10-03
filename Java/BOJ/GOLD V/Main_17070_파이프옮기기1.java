import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Pipe {
		int x, y, dir;

		public Pipe(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		int ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<Pipe> q = new ArrayDeque<>();
		q.offer(new Pipe(0, 1, 0));
		while (!q.isEmpty()) {
			Pipe cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int dir = cur.dir;

			if (x == N - 1 && y == N - 1 && arr[x][y] == 0) {
				ans++;
				continue;
			}

			if (dir == 0) { // 가로
				int nx1 = x + 0;
				int ny1 = y + 1;
				int dir1 = 0;

				if (nx1 < N && ny1 < N && arr[nx1][ny1] == 0)
					q.offer(new Pipe(nx1, ny1, dir1));

				int nx2 = x + 1;
				int ny2 = y + 1;
				int dir2 = 2;

				if (nx2 < N && ny2 < N && arr[x][ny2] == 0 && arr[nx2][y] == 0 && arr[nx2][ny2] == 0)
					q.offer(new Pipe(nx2, ny2, dir2));
			} else if (dir == 1) { // 세로
				int nx1 = x + 1;
				int ny1 = y + 0;
				int dir1 = 1;

				if (nx1 < N && ny1 < N && arr[nx1][ny1] == 0)
					q.offer(new Pipe(nx1, ny1, dir1));

				int nx2 = x + 1;
				int ny2 = y + 1;
				int dir2 = 2;

				if (nx2 < N && ny2 < N && arr[x][ny2] == 0 && arr[nx2][y] == 0 && arr[nx2][ny2] == 0)
					q.offer(new Pipe(nx2, ny2, dir2));
			} else { // 대각선
				int nx1 = x + 0;
				int ny1 = y + 1;
				int dir1 = 0;

				if (nx1 < N && ny1 < N && arr[nx1][ny1] == 0)
					q.offer(new Pipe(nx1, ny1, dir1));

				int nx2 = x + 1;
				int ny2 = y + 0;
				int dir2 = 1;

				if (nx2 < N && ny2 < N && arr[nx2][ny2] == 0)
					q.offer(new Pipe(nx2, ny2, dir2));

				int nx3 = x + 1;
				int ny3 = y + 1;
				int dir3 = 2;

				if (nx3 < N && ny3 < N && arr[x][ny3] == 0 && arr[nx3][y] == 0 && arr[nx3][ny3] == 0)
					q.offer(new Pipe(nx3, ny3, dir3));
			}
		}

		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}