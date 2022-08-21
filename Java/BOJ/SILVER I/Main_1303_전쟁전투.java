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

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int bfs(Node node) {
		Deque<Node> q = new ArrayDeque<>();
		q.offer(node);
		visited[node.x][node.y] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;

				if (arr[nx][ny] == arr[x][y]) {
					visited[nx][ny] = true;
					cnt++;
					q.offer(new Node(nx, ny));
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		visited = new boolean[N][M];
		int white = 0, blue = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					continue;
				
				int cnt = bfs(new Node(i, j));
				white = arr[i][j] == 'W' ? white + cnt * cnt : white;
				blue = arr[i][j] == 'B' ? blue + cnt * cnt : blue;
			}
		}
		sb.append(white).append(" ").append(blue);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}