import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static int[] hx = { -1, -2, -2, -1, 1, 2, 2, 1 }, hy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] arr = new int[H][W];
		int[][][] visited = new int[H][W][31];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		int minMove = Integer.MAX_VALUE;

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, K, 0 });
		visited[0][0][K] = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int left = cur[2];
			int moved = cur[3];

			if (moved > minMove)
				continue;

			if (x == H - 1 && y == W - 1 && arr[x][y] == 0) {
				minMove = Math.min(minMove, moved);
				continue;
			}

			if (left > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = x + hx[i];
					int ny = y + hy[i];

					if (nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] == 1)
						continue;

					if (visited[nx][ny][left - 1] == Integer.MAX_VALUE) {
						visited[nx][ny][left - 1] = visited[x][y][left] + 1;
						q.offer(new int[] { nx, ny, left - 1, moved + 1 });
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] == 1)
					continue;

				if (visited[nx][ny][left] == Integer.MAX_VALUE) {
					visited[nx][ny][left] = visited[x][y][left] + 1;
					q.offer(new int[] { nx, ny, left, moved + 1 });
				}
			}
		}

		sb.append(minMove == Integer.MAX_VALUE ? -1 : minMove);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}