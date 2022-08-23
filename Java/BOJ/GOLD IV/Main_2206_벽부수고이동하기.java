import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] arr;
	private static boolean[][][] visited;
	private static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Node {
		int x, y, cnt, crash;

		public Node(int x, int y, int cnt, int crash) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.crash = crash;
		}
	}

	private static int bfs() {
		Deque<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			int crash = cur.crash;

			if (x == N - 1 && y == M - 1)
				return cnt;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || (arr[nx][ny] == 1 && crash == 1))
					continue;

				int newCrash = crash;
				if (arr[nx][ny] == 1 && crash == 0)
					newCrash = 1;

				if (visited[nx][ny][newCrash])
					continue;

				visited[nx][ny][crash] = true;
				q.offer(new Node(nx, ny, cnt + 1, newCrash));

			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line.charAt(j) + "");
			}
		}

		visited = new boolean[N][M][2];

		sb.append(bfs());

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}