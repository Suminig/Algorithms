import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private static int N;
	private static char[][] arr;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, 1, -1 }, dy = { -1, 1, 0, 0 };
	private static StringBuilder sb = new StringBuilder();

	private static int bfs(int i, int j) {
		int cnt = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				if (arr[nx][ny] == '1' && !visited[nx][ny]) {
					cnt++;
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		ArrayList<Integer> cnts = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '1' && !visited[i][j])
					cnts.add(bfs(i, j));
			}
		}

		Collections.sort(cnts);
		sb.append(cnts.size()).append("\n");
		for (Integer cnt : cnts) {
			sb.append(cnt).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}