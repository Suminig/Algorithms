import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int startX = 0, startY = 0, endX = 0, endY = 0;
		char[][] arr = new char[R][C];
		Deque<int[]> q = new ArrayDeque<>();
		int[][][] visited = new int[R][C][2];
		int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = line.charAt(j);

				if (arr[i][j] == 'S') {
					startX = i;
					startY = j;
				} else if (arr[i][j] == 'D') {
					endX = i;
					endY = j;
				} else if (arr[i][j] == '*') {
					visited[i][j][1] = 1;
					q.offer(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny][1] > 0)
					continue;

				if (arr[nx][ny] == '.') {
					visited[nx][ny][1] = visited[cur[0]][cur[1]][1] + 1;
					q.offer(new int[] { nx, ny });
				}
			}
		}

		q.offer(new int[] { startX, startY });
		visited[startX][startY][0] = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny][0] > 0 || arr[nx][ny] == 'X')
					continue;

				if (visited[nx][ny][1] != 0 && arr[nx][ny] != 'D' && visited[cur[0]][cur[1]][0] + 1 >= visited[nx][ny][1])
					continue;

				visited[nx][ny][0] = visited[cur[0]][cur[1]][0] + 1;
				q.offer(new int[] { nx, ny });
			}
		}

		sb.append(visited[endX][endY][0] == 0 ? "KAKTUS" : visited[endX][endY][0] - 1);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}