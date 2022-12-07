import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, cheese, time;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static int[][] arr, visited;
	private static List<int[]> edges;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		visited[0][0] = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 0)
					continue;

				visited[nx][ny]++;
				if (arr[nx][ny] == 0) {
					q.offer(new int[] { nx, ny });
				} else {
					visited[nx][ny]++;
					edges.add(new int[] { nx, ny });
				}
			}
		}
	}

	public static void melt() {
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (visited[nx][ny] == 1)
					cnt++;
			}

			if (cnt >= 2) {
				arr[x][y] = 0;
				cheese--;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cheese = 0;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					cheese++;
			}
		}

		time = 0;
		while (cheese > 0) {
			visited = new int[N][M];
			edges = new ArrayList<>();
			bfs();
			melt();
			time++;
		}

		sb.append(time);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}