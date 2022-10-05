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
	private static int N, M, time;
	private static int[][] arr;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static boolean[][] visited;
	private static List<int[]> edges;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void bfs() {
		time++;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				if (arr[nx][ny] == 0) {
					q.offer(new int[] { nx, ny });
				} else {
					edges.add(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int cheese = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					cheese++;
			}
		}

		time = 0;
		int prev = 0;
		while (cheese > 0) {
			prev = cheese;

			visited = new boolean[N][M];
			edges = new ArrayList<>();

			bfs();

			for (int[] edge : edges) {
				arr[edge[0]][edge[1]] = 0;
				cheese--;
			}
		}

		sb.append(time).append("\n").append(prev);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}